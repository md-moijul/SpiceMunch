package com.example.spice_munch.ui.fragment.allergies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.spice_munch.R
import com.example.spice_munch.ui.fragment.itemAmount.AmountViewModel

class AllergiesFragment : Fragment() {

    private val viewModel: AllergiesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_allergies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNuts: Button = view.findViewById(R.id.btnNuts)
        val btnDairy: Button = view.findViewById(R.id.btnDairy)
        val btnSeaFoods: Button = view.findViewById(R.id.btnSeaFoods)
        val btnWheat: Button = view.findViewById(R.id.btnWheat)

        // Observe the LiveData from the ViewModel
        viewModel.allergies.observe(viewLifecycleOwner) { allergies ->
            btnNuts.isSelected = allergies.nuts
            btnDairy.isSelected = allergies.dairy
            btnSeaFoods.isSelected = allergies.seaFoods
            btnWheat.isSelected = allergies.wheat
        }

        // Set up button click listeners
        btnNuts.setOnClickListener { viewModel.toggleNutsAllergy() }
        btnDairy.setOnClickListener { viewModel.toggleDairyAllergy() }
        btnSeaFoods.setOnClickListener { viewModel.toggleSeaFoodsAllergy() }
        btnWheat.setOnClickListener { viewModel.toggleWheatAllergy() }
    }
}
