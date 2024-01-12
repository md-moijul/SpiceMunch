package com.example.spice_munch.ui.fragment.option

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.example.spice_munch.R
import com.example.spice_munch.data.model.Option
import com.example.spice_munch.databinding.FragmentOptionBinding
import com.example.spice_munch.ui.activity.modification.OrderSharedViewModel

class OptionFragment : Fragment() {

    private val sharedViewModel: OrderSharedViewModel by activityViewModels()
    private var _binding: FragmentOptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.orderItem.observe(viewLifecycleOwner) { orderItem ->
            resetButtonColors()

            when (orderItem.option) {
                Option.CHICKEN -> binding.buttonChicken.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.secondaryButton))
                Option.LAMB -> binding.buttonLamb.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.secondaryButton))
                Option.PRAWN -> binding.buttonPrawn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.secondaryButton))
                Option.VEGETABLE -> binding.buttonVegetable.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.secondaryButton))
            }
        }

        binding.buttonChicken.setOnClickListener { sharedViewModel.selectOption(Option.CHICKEN) }
        binding.buttonLamb.setOnClickListener { sharedViewModel.selectOption(Option.LAMB) }
        binding.buttonPrawn.setOnClickListener { sharedViewModel.selectOption(Option.PRAWN) }
        binding.buttonVegetable.setOnClickListener { sharedViewModel.selectOption(Option.VEGETABLE) }
    }

    private fun resetButtonColors() {
        val defaultColor = ContextCompat.getColor(requireContext(), R.color.primaryButton)
        binding.buttonChicken.setBackgroundColor(defaultColor)
        binding.buttonLamb.setBackgroundColor(defaultColor)
        binding.buttonPrawn.setBackgroundColor(defaultColor)
        binding.buttonVegetable.setBackgroundColor(defaultColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

