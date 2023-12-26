package com.example.spice_munch.ui.fragment.itemAmount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.spice_munch.R

class AmountFragment : Fragment() {

    private val viewModel: AmountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtNumber: TextView = view.findViewById(R.id.txtNumber)
        val btnIncrease: Button = view.findViewById(R.id.btnIncrease)
        val btnDecrease: Button = view.findViewById(R.id.btnDecrease)

        viewModel.currentNumber.observe(viewLifecycleOwner, Observer { number ->
            txtNumber.text = number.toString().padStart(2, '0')
            btnDecrease.isEnabled = number > 1
        })

        btnIncrease.setOnClickListener {
            viewModel.increaseNumber()
        }

        btnDecrease.setOnClickListener {
            viewModel.decreaseNumber()
        }
    }
}
