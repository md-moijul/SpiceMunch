package com.example.spice_munch.ui.activity.modification

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.spice_munch.R
import com.example.spice_munch.data.model.FoodItem
import com.example.spice_munch.databinding.ActivityModificationBinding
import com.example.spice_munch.ui.activity.foodItems.FoodViewModel
import com.example.spice_munch.ui.fragment.allergies.AllergiesFragment
import com.example.spice_munch.ui.fragment.extra.ExtraFragment
import com.example.spice_munch.ui.fragment.itemAmount.AmountFragment
import com.example.spice_munch.ui.fragment.option.OptionFragment
import com.example.spice_munch.ui.fragment.spiceLevel.SpiceLevelFragment

class ModificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModificationBinding
    private val sharedViewModel: OrderSharedViewModel by viewModels()
    private val foodViewModel: FoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Extract the selected food item from the Intent
        val selectedFoodItem = intent.getSerializableExtra("selected_item") as FoodItem
        selectedFoodItem?.let {
            sharedViewModel.initializeOrderItemWithSelectedFoodItem(it)
        }

        // Use binding to set the text
        binding.selectedItemTextView.text = selectedFoodItem.name

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()

                .add(R.id.OptionFragment_container, OptionFragment())

                .add(R.id.SpiceLevelFragment_container, SpiceLevelFragment())

                .add(R.id.ExtraFragment_container, ExtraFragment())

                .add(R.id.allergiesFragment_container, AllergiesFragment())

                .add(R.id.amountFragment_container, AmountFragment())

                .commit()
        }


        // Use binding for all view references
        binding.addItemButton.setOnClickListener {
            sharedViewModel.orderItem.value?.let { currentOrderItem ->
                foodViewModel.addOrderItem(currentOrderItem)
                // Optionally, clear or reset the sharedViewModel's OrderItem here
                // Log the current OrderItem
                Log.d("ModificationActivity", "Order Item Added: $currentOrderItem")
                finish()
            }
        }

    }


}