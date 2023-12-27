package com.example.spice_munch.ui.activity.modification

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.spice_munch.R
import com.example.spice_munch.data.model.OptionModel
import com.example.spice_munch.data.model.SpiceLevelModel
import com.example.spice_munch.ui.activity.foodItems.FoodActivity
import com.example.spice_munch.ui.activity.main.CounterViewModel
import com.example.spice_munch.ui.fragment.allergies.AllergiesFragment
import com.example.spice_munch.ui.fragment.allergies.AllergiesViewModel
import com.example.spice_munch.ui.fragment.extra.ExtraFragment
import com.example.spice_munch.ui.fragment.extra.ExtraViewModel
import com.example.spice_munch.ui.fragment.itemAmount.AmountFragment
import com.example.spice_munch.ui.fragment.itemAmount.AmountViewModel
import com.example.spice_munch.ui.fragment.option.OptionFragment
import com.example.spice_munch.ui.fragment.option.OptionViewModel
import com.example.spice_munch.ui.fragment.spiceLevel.SpiceLevelFragment
import com.example.spice_munch.ui.fragment.spiceLevel.SpiceLevelViewModel

class ModificationActivity : AppCompatActivity() {

    private val TAG = "ModificationState"

    private val OptionViewModel: OptionViewModel by viewModels()
    private val SpiceLevelViewModel: SpiceLevelViewModel by viewModels()
    private val ExtraViewModel: ExtraViewModel by viewModels()
    private val AllergiesViewModel: AllergiesViewModel by viewModels()
    private val AmountViewModel: AmountViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modification)

        // Extract the selected food item from the Intent
        val selectedFoodItem = intent.getStringExtra("selected_item") ?: "No item selected"
        // Find the TextView and set the selected food item

        val selectedItemTextView: TextView = findViewById(R.id.selectedItemTextView)
        selectedItemTextView.text = selectedFoodItem

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()

                .add(R.id.OptionFragment_container, OptionFragment())

                .add(R.id.SpiceLevelFragment_container, SpiceLevelFragment())

                .add(R.id.ExtraFragment_container, ExtraFragment())

                .add(R.id.allergiesFragment_container, AllergiesFragment())

                .add(R.id.amountFragment_container, AmountFragment())

                .commit()

        }

        //log current state
        SpiceLevelViewModel.spiceLevel.observe(this, Observer { spiceLevel ->
            Log.i(AmountViewModel.currentNumber.toString(), "Current Amount: ${spiceLevel.currentSpiceLevel}")
        })
        AmountViewModel.currentNumber.observe(this, Observer { number ->
            Log.i(AmountViewModel.currentNumber.toString(), "Current Amount: $number")
        })
        AllergiesViewModel.allergies.observe(this, Observer { allergies ->
            val allergiesMap = mapOf(
                "Nuts" to allergies.nuts,
                "Dairy" to allergies.dairy,
                "Sea Foods" to allergies.seaFoods,
                "Wheat" to allergies.wheat
            )

            allergiesMap.forEach { (allergy, isAllergic) ->
                if (isAllergic) {
                    Log.i(TAG, "Allergic to $allergy")
                }
            }
        })
        ExtraViewModel.extras.observe(this, Observer { extras ->
            val extrasMap = mapOf(
                "mushroom" to extras.mushroom,
                "cream" to extras.cream,
                "coriander" to extras.coriander,
                "onion" to extras.onion
            )

            extrasMap.forEach { (extra, isExtra) ->
                if (isExtra) {
                    Log.i(TAG, "Extra : $extra")
                }
            }
        })
        OptionViewModel.selectedOption.observe(this, Observer { option ->
            val selected = when (option) {
                OptionModel.Option.CHICKEN -> "Chicken"
                OptionModel.Option.LAMB -> "Lamb"
                OptionModel.Option.PRAWN -> "Prawn"
                OptionModel.Option.VEGETABLE -> "Vegetable"
            }
            Log.i(TAG, "Selected Extra Option: $selected")
        })

        val addItemButton: Button = findViewById(R.id.addItemButton)
        addItemButton.setOnClickListener {
            // Finish ModificationActivity to return to the previous Activity
            finish()
        }



    }
}