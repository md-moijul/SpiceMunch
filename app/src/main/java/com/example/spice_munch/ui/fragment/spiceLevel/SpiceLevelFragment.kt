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
import com.example.spice_munch.ui.activity.modification.OrderSharedViewModel

class SpiceLevelFragment : Fragment() {

    private val sharedViewModel: OrderSharedViewModel by activityViewModels()
    private var _binding: FragmentSpiceLevelBinding? = null
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

        sharedViewModel.orderItem.observe(viewLifecycleOwner) { orderItem ->
            binding.textViewSpiceLevel.text = orderItem.spiceLevel

            binding.seekBarSpiceLevel.progress = when (orderItem.spiceLevel) {
                "Mild" -> 0
                "Medium" -> 33
                "Hot" -> 66
                "Extra Hot" -> 100
                else -> 0
            }
        }

        binding.seekBarSpiceLevel.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    val newSpiceLevel = when (progress) {
                        in 0..25 -> "Mild"
                        in 26..50 -> "Medium"
                        in 51..75 -> "Hot"
                        else -> "Extra Hot"
                    }
                    sharedViewModel.setSpiceLevel(newSpiceLevel)
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
