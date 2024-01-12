package com.example.spice_munch.ui.fragment.itemAmount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.spice_munch.R
import com.example.spice_munch.databinding.FragmentAmountBinding
import com.example.spice_munch.ui.activity.modification.OrderSharedViewModel

class AmountFragment : Fragment() {

    private val sharedViewModel: OrderSharedViewModel by activityViewModels()
    private var _binding: FragmentAmountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.orderItem.observe(viewLifecycleOwner) { orderItem ->
            binding.txtNumber.text = orderItem.amount.toInt().toString().padStart(2, '0')
            binding.btnDecrease.isEnabled = orderItem.amount > 1
        }

        binding.btnIncrease.setOnClickListener {
            sharedViewModel.increaseAmount()
        }

        binding.btnDecrease.setOnClickListener {
            sharedViewModel.decreaseAmount()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
