package com.example.spice_munch.ui.activity.modification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.spice_munch.R
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class ModificationActivity : AppCompatActivity() {

    private lateinit var viewModel: ModificationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modification)


        // Extract the selected food item from the Intent
        val selectedFoodItem = intent.getStringExtra("selected_item") ?: "No item selected"

        // Find the TextView and set the selected food item
        val selectedItemTextView: TextView = findViewById(R.id.selectedItemTextView)
        selectedItemTextView.text = selectedFoodItem

        viewModel = ViewModelProvider(this).get(ModificationViewModel::class.java)

        // Set a listener for radio button check changes
        val radioGroup: RadioGroup = findViewById(R.id.optionsRadioGroup)
        val radioButtonChicken: RadioButton = findViewById(R.id.radioButtonChicken)
        val radioButtonLamb: RadioButton = findViewById(R.id.radioButtonLamb)
        val radioButtonPrawn: RadioButton = findViewById(R.id.radioButtonPrawn)
        val radioButtonVegetable: RadioButton = findViewById(R.id.radioButtonVegetable)

        val radioButtons = listOf(radioButtonChicken, radioButtonLamb, radioButtonPrawn, radioButtonVegetable)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            viewModel.selectOption(checkedId)
        }

        viewModel.selectedOptionId.observe(this, Observer { selectedOptionId ->
            radioButtons.forEach { radioButton ->
                if (radioButton.id == selectedOptionId) {
                    // Set the background for the selected RadioButton
                    radioButton.setBackgroundColor(ContextCompat.getColor(this, R.color.secondaryButton))
                } else {
                    // Reset the background for non-selected RadioButtons
                    radioButton.setBackgroundColor(ContextCompat.getColor(this, R.color.primaryButton))
                }
            }
        })

    }
}