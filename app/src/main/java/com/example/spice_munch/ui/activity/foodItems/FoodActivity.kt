package com.example.spice_munch.ui.activity.foodItems

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.spice_munch.R
import com.example.spice_munch.databinding.ActivityFoodBinding
import com.example.spice_munch.ui.activity.modification.ModificationActivity

class FoodActivity : AppCompatActivity() {

    private lateinit var viewModel: FoodViewModel
    private lateinit var binding: ActivityFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        // Retrieve the table number from the Intent
        val tableNumber = intent.getIntExtra("table_number", 0)
        binding.TableNumberTextView.text = "Table number: $tableNumber"

        // Setup the ListView and Adapter
        val adapter = FoodItemAdapter(viewModel.items)
        binding.listViewFoodItems.adapter = adapter

        // Set the item click listener
        binding.listViewFoodItems.setOnItemClickListener { _, _, position, _ ->
            val selectedFoodItem = viewModel.items[position]
            val intent = Intent(this, ModificationActivity::class.java).apply {
                // Pass the selected FoodItem to the ModificationActivity
                putExtra("selected_item", selectedFoodItem)
            }
            startActivity(intent)
        }
    }
}
