package com.example.spice_munch.ui.fragment.extra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.example.spice_munch.R
import com.example.spice_munch.databinding.FragmentExtraBinding

class ExtraFragment : Fragment() {

    private val viewModel: ExtraViewModel by activityViewModels()
    private var _binding: FragmentExtraBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
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

        // Observe the LiveData from the ViewModel
        viewModel.extras.observe(viewLifecycleOwner) { extras ->
            binding.btnMushroom.isSelected = extras.mushroom
            binding.btnCream.isSelected = extras.cream
            binding.btnCoriander.isSelected = extras.coriander
            binding.btnOnion.isSelected = extras.onion
        }

        binding.btnMushroom.setOnClickListener { viewModel.toggleMushroom() }
        binding.btnCream.setOnClickListener { viewModel.toggleCream() }
        binding.btnCoriander.setOnClickListener { viewModel.toggleCoriander() }
        binding.btnOnion.setOnClickListener { viewModel.toggleOnion() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}