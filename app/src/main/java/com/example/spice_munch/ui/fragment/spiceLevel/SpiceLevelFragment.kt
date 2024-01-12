package com.example.spice_munch.ui.fragment.spiceLevel

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.spice_munch.R
import com.example.spice_munch.data.model.SpiceLevelModel
import com.example.spice_munch.databinding.FragmentSpiceLevelBinding

class SpiceLevelFragment : Fragment() {

    private val viewModel: SpiceLevelViewModel by activityViewModels()
    private var _binding: FragmentSpiceLevelBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpiceLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.spiceLevel.observe(viewLifecycleOwner) { model ->
            val spiceLevel = when (model.currentSpiceLevel) {
                SpiceLevelModel.SpiceLevel.MILD -> "Mild"
                SpiceLevelModel.SpiceLevel.MEDIUM -> "Medium"
                SpiceLevelModel.SpiceLevel.HOT -> "Hot"
                SpiceLevelModel.SpiceLevel.EXTRA_HOT -> "Extra Hot"
            }
            binding.textViewSpiceLevel.text = spiceLevel

            binding.seekBarSpiceLevel.progress = when (model.currentSpiceLevel) {
                SpiceLevelModel.SpiceLevel.MILD -> 0
                SpiceLevelModel.SpiceLevel.MEDIUM -> 33
                SpiceLevelModel.SpiceLevel.HOT -> 66
                SpiceLevelModel.SpiceLevel.EXTRA_HOT -> 100
            }
        }

        binding.seekBarSpiceLevel.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    viewModel.setSpiceLevel(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Not needed for this example
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Not needed for this example
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}