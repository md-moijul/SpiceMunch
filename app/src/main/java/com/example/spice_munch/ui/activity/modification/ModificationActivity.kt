package com.example.spice_munch.ui.activity.modification

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.spice_munch.R
import com.example.spice_munch.data.model.FoodItem
import com.example.spice_munch.data.model.OrderItem
import com.example.spice_munch.data.model.OrderManager
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check if an existing OrderItem is passed
        val existingOrderItem = intent.getSerializableExtra("selected_order_item") as? OrderItem

        if (existingOrderItem != null) {
            // Use existing OrderItem
            sharedViewModel.setOrderItem(existingOrderItem)
        } else {
            // Extract the selected food item from the Intent and create a new OrderItem
            val selectedFoodItem = intent.getSerializableExtra("selected_item") as? FoodItem
            selectedFoodItem?.let {
                sharedViewModel.initializeOrderItemWithSelectedFoodItem(it)
                binding.selectedItemTextView.text = it.name
            }
        }

        val buttonColor = ContextCompat.getColor(this, R.color.colorSeconday)
        binding.addItemButton.setBackgroundColor(buttonColor)


        setupFragments()
        setupAddItemButton()
    }

    private fun setupFragments() {
        if (supportFragmentManager.fragments.isEmpty()) {
            supportFragmentManager.beginTransaction()
                .add(R.id.OptionFragment_container, OptionFragment())
                .add(R.id.SpiceLevelFragment_container, SpiceLevelFragment())
                .add(R.id.ExtraFragment_container, ExtraFragment())
                .add(R.id.allergiesFragment_container, AllergiesFragment())
                .add(R.id.amountFragment_container, AmountFragment())
                .commit()
        }
    }

    private fun setupAddItemButton() {
        binding.addItemButton.setOnClickListener {
            sharedViewModel.orderItem.value?.let { currentOrderItem ->
                OrderManager.addOrUpdateOrderItem(currentOrderItem)
                finish() // Close the activity after updating the item
            }
        }
    }
}