package com.example.spice_munch.ui.activity.foodItems

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.spice_munch.R
import com.example.spice_munch.data.model.FoodItem
import com.example.spice_munch.databinding.ActivityFoodBinding
import com.example.spice_munch.ui.activity.modification.ModificationActivity
import com.example.spice_munch.ui.activity.summary.SummaryActivity

class FoodActivity : AppCompatActivity() {

    private lateinit var viewModel: FoodViewModel
    private lateinit var binding: ActivityFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        val tableNumber = intent.getIntExtra("table_number", 0)
        binding.tableNumberTextView.text = "Table number: $tableNumber"

        setupListView(binding.listViewMainDishes, viewModel.itemsMains)
        setupListView(binding.listViewSides, viewModel.itemsSides)
        setupListView(binding.listViewStarters, viewModel.itemsStarters)
        setupListView(binding.listViewRice, viewModel.itemsRice)
        setupListView(binding.listViewBread, viewModel.itemsBread)

        binding.viewSummaryButton.setOnClickListener {
            startActivity(Intent(this, SummaryActivity::class.java))
        }
    }

    private fun setupListView(listView: ListView, items: List<FoodItem>) {
        val adapter = FoodItemAdapter(items)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedFoodItem = items[position]
            val intent = Intent(this, ModificationActivity::class.java).apply {
                putExtra("selected_item", selectedFoodItem)
            }
            startActivity(intent)
        }
    }
}

