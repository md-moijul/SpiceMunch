package com.example.spice_munch.ui.fragment.option

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.example.spice_munch.R
import com.example.spice_munch.data.model.OptionModel
import com.example.spice_munch.databinding.FragmentOptionBinding

class OptionFragment : Fragment() {

    private val viewModel: OptionViewModel by activityViewModels()
    private var _binding: FragmentOptionBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
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

        viewModel.selectedOption.observe(viewLifecycleOwner) { selectedOption ->
            // Update buttons' selected state
            binding.buttonChicken.isSelected = selectedOption == OptionModel.Option.CHICKEN
            binding.buttonLamb.isSelected = selectedOption == OptionModel.Option.LAMB
            binding.buttonPrawn.isSelected = selectedOption == OptionModel.Option.PRAWN
            binding.buttonVegetable.isSelected = selectedOption == OptionModel.Option.VEGETABLE
        }

        // Set click listeners for buttons
        binding.buttonChicken.setOnClickListener { viewModel.selectOption(OptionModel.Option.CHICKEN) }
        binding.buttonLamb.setOnClickListener { viewModel.selectOption(OptionModel.Option.LAMB) }
        binding.buttonPrawn.setOnClickListener { viewModel.selectOption(OptionModel.Option.PRAWN) }
        binding.buttonVegetable.setOnClickListener { viewModel.selectOption(OptionModel.Option.VEGETABLE) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
