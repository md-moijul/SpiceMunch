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

class AmountFragment : Fragment() {

    private val viewModel: AmountViewModel by activityViewModels()
    private var _binding: FragmentAmountBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
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

        viewModel.currentNumber.observe(viewLifecycleOwner, Observer { number ->
            binding.txtNumber.text = number.toString().padStart(2, '0')
            binding.btnDecrease.isEnabled = number > 1
        })

        binding.btnIncrease.setOnClickListener {
            viewModel.increaseNumber()
        }

        binding.btnDecrease.setOnClickListener {
            viewModel.decreaseNumber()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}