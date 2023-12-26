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

class SpiceLevelFragment : Fragment() {

    private val viewModel: SpiceLevelViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spice_level, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val seekBar: SeekBar = view.findViewById(R.id.seekBarSpiceLevel)
        val textViewSpiceLevel: TextView = view.findViewById(R.id.textViewSpiceLevel)

        // Initialize the SeekBar and TextView based on the ViewModel's current state
        viewModel.spiceLevel.observe(viewLifecycleOwner) { model ->
            val spiceLevel = when (model.currentSpiceLevel) {
                SpiceLevelModel.SpiceLevel.MILD -> "Mild"
                SpiceLevelModel.SpiceLevel.MEDIUM -> "Medium"
                SpiceLevelModel.SpiceLevel.HOT -> "Hot"
                SpiceLevelModel.SpiceLevel.EXTRA_HOT -> "Extra Hot"
            }
            textViewSpiceLevel.text = spiceLevel

            // Update SeekBar progress based on the selected spice level
            seekBar.progress = when (model.currentSpiceLevel) {
                SpiceLevelModel.SpiceLevel.MILD -> 0
                SpiceLevelModel.SpiceLevel.MEDIUM -> 33
                SpiceLevelModel.SpiceLevel.HOT -> 66
                SpiceLevelModel.SpiceLevel.EXTRA_HOT -> 100
            }
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Only update the ViewModel if the user changed the SeekBar value
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
}