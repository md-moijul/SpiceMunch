package com.example.spice_munch.ui.fragment.extra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.example.spice_munch.R

class ExtraFragment : Fragment() {

    private val viewModel: ExtraViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extra, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnMushroom: Button = view.findViewById(R.id.btnMushroom)
        val btnCream: Button = view.findViewById(R.id.btnCream)
        val btnCoriander: Button = view.findViewById(R.id.btnCoriander)
        val btnOnion: Button = view.findViewById(R.id.btnOnion)

        // Observe the LiveData from the ViewModel
        viewModel.extras.observe(viewLifecycleOwner) { extras ->
            btnMushroom.isSelected = extras.mushroom
            btnCream.isSelected = extras.cream
            btnCoriander.isSelected = extras.coriander
            btnOnion.isSelected = extras.onion
        }

        btnMushroom.setOnClickListener { viewModel.toggleMushroom() }
        btnCream.setOnClickListener { viewModel.toggleCream() }
        btnCoriander.setOnClickListener { viewModel.toggleCoriander() }
        btnOnion.setOnClickListener { viewModel.toggleOnion() }
    }
}