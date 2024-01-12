package com.example.spice_munch.ui.fragment.allergies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.spice_munch.databinding.FragmentAllergiesBinding

class AllergiesFragment : Fragment() {

    private val viewModel: AllergiesViewModel by activityViewModels()
    private var _binding: FragmentAllergiesBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
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

        // Observe the LiveData from the ViewModel
        viewModel.allergies.observe(viewLifecycleOwner) { allergies ->
            binding.btnNuts.isSelected = allergies.nuts
            binding.btnDairy.isSelected = allergies.dairy
            binding.btnSeaFoods.isSelected = allergies.seaFoods
            binding.btnWheat.isSelected = allergies.wheat
        }

        // Set up button click listeners
        binding.btnNuts.setOnClickListener { viewModel.toggleNutsAllergy() }
        binding.btnDairy.setOnClickListener { viewModel.toggleDairyAllergy() }
        binding.btnSeaFoods.setOnClickListener { viewModel.toggleSeaFoodsAllergy() }
        binding.btnWheat.setOnClickListener { viewModel.toggleWheatAllergy() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}