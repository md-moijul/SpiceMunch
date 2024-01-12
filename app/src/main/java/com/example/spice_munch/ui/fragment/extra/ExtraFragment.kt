package com.example.spice_munch.ui.fragment.extra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.example.spice_munch.R
import com.example.spice_munch.data.model.Extra
import com.example.spice_munch.databinding.FragmentExtraBinding
import com.example.spice_munch.ui.activity.modification.OrderSharedViewModel

class ExtraFragment : Fragment() {

    private val sharedViewModel: OrderSharedViewModel by activityViewModels()
    private var _binding: FragmentExtraBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExtraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.orderItem.observe(viewLifecycleOwner) { orderItem ->
            updateButtonState(binding.btnMushroom, orderItem.extras.contains(Extra.MUSHROOM))
            updateButtonState(binding.btnCream, orderItem.extras.contains(Extra.CREAM))
            updateButtonState(binding.btnCoriander, orderItem.extras.contains(Extra.CORIANDER))
            updateButtonState(binding.btnOnion, orderItem.extras.contains(Extra.ONION))
        }

        binding.btnMushroom.setOnClickListener { sharedViewModel.toggleExtra(Extra.MUSHROOM) }
        binding.btnCream.setOnClickListener { sharedViewModel.toggleExtra(Extra.CREAM) }
        binding.btnCoriander.setOnClickListener { sharedViewModel.toggleExtra(Extra.CORIANDER) }
        binding.btnOnion.setOnClickListener { sharedViewModel.toggleExtra(Extra.ONION) }
    }

    private fun updateButtonState(button: Button, isSelected: Boolean) {
        if (isSelected) {
            button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.primaryButton))
        } else {
            button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.secondaryButton))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

