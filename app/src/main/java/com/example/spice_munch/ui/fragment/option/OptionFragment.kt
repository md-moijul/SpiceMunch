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

class OptionFragment : Fragment() {

    private val viewModel: OptionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonChicken: Button = view.findViewById(R.id.buttonChicken)
        val buttonLamb: Button = view.findViewById(R.id.buttonLamb)
        val buttonPrawn: Button = view.findViewById(R.id.buttonPrawn)
        val buttonVegetable: Button = view.findViewById(R.id.buttonVegetable)

        viewModel.selectedOption.observe(viewLifecycleOwner) { selectedOption ->
            // Update buttons' selected state
            buttonChicken.isSelected = selectedOption == OptionModel.Option.CHICKEN
            buttonLamb.isSelected = selectedOption == OptionModel.Option.LAMB
            buttonPrawn.isSelected = selectedOption == OptionModel.Option.PRAWN
            buttonVegetable.isSelected = selectedOption == OptionModel.Option.VEGETABLE
        }

        // Set click listeners for buttons
        buttonChicken.setOnClickListener { viewModel.selectOption(OptionModel.Option.CHICKEN) }
        buttonLamb.setOnClickListener { viewModel.selectOption(OptionModel.Option.LAMB) }
        buttonPrawn.setOnClickListener { viewModel.selectOption(OptionModel.Option.PRAWN) }
        buttonVegetable.setOnClickListener { viewModel.selectOption(OptionModel.Option.VEGETABLE) }
    }
}