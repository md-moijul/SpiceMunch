package com.example.spice_munch.ui.fragment.allergies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.example.spice_munch.R
import com.example.spice_munch.data.model.Allergy
import com.example.spice_munch.databinding.FragmentAllergiesBinding
import com.example.spice_munch.ui.activity.modification.OrderSharedViewModel

class AllergiesFragment : Fragment() {

    private val sharedViewModel: OrderSharedViewModel by activityViewModels()
    private var _binding: FragmentAllergiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllergiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.orderItem.observe(viewLifecycleOwner) { orderItem ->
            updateButtonColor(binding.btnNuts, orderItem.allergies.contains(Allergy.NUTS))
            updateButtonColor(binding.btnDairy, orderItem.allergies.contains(Allergy.DAIRY))
            updateButtonColor(binding.btnSeaFoods, orderItem.allergies.contains(Allergy.SEAFOODS))
            updateButtonColor(binding.btnWheat, orderItem.allergies.contains(Allergy.WHEAT))
        }

        binding.btnNuts.setOnClickListener {
            sharedViewModel.toggleAllergy(Allergy.NUTS)
            toggleButtonColor(binding.btnNuts)
        }
        binding.btnDairy.setOnClickListener {
            sharedViewModel.toggleAllergy(Allergy.DAIRY)
            toggleButtonColor(binding.btnDairy)
        }
        binding.btnSeaFoods.setOnClickListener {
            sharedViewModel.toggleAllergy(Allergy.SEAFOODS)
            toggleButtonColor(binding.btnSeaFoods)
        }
        binding.btnWheat.setOnClickListener {
            sharedViewModel.toggleAllergy(Allergy.WHEAT)
            toggleButtonColor(binding.btnWheat)
        }
    }

    private fun updateButtonColor(button: Button, isSelected: Boolean) {
        if (isSelected) {
            button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.primaryButton))
        } else {
            button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.secondaryButton))
        }
    }

    private fun toggleButtonColor(button: Button) {
        button.isSelected = !button.isSelected
        updateButtonColor(button, button.isSelected)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
