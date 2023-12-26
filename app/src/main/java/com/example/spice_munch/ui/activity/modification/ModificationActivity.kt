package com.example.spice_munch.ui.activity.modification

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.spice_munch.R
import com.example.spice_munch.data.model.OptionModel
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

class ModificationActivity : AppCompatActivity() {

    private val TAG = "ModificationState"


    private val AmountViewModel: AmountViewModel by viewModels()
    private val AllergiesViewModel: AllergiesViewModel by viewModels()
    private val ExtraViewModel: ExtraViewModel by viewModels()
    private val OptionViewModel: OptionViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modification)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.amountFragment_container, AmountFragment())
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.allergiesFragment_container, AllergiesFragment())
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.ExtraFragment_container, ExtraFragment())
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.OptionFragment_container, OptionFragment())
                .commit()
        }

        //log current state
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
        // Observe the selected option from ExtraOptionViewModel
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