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
import com.example.spice_munch.ui.activity.modification.ModificationActivity

class FoodActivity : AppCompatActivity() {

    private lateinit var viewModel: FoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        viewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        // Find the TextView and set the counter value from the Intent
        val counterTextView: TextView = findViewById(R.id.counterTextView)
        val counterValue = intent.getIntExtra("counter_value", 0)
        counterTextView.text = "Table number: $counterValue"

        // Setup the ListView and Adapter
        val listView: ListView = findViewById(R.id.listViewFoodItems)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, viewModel.items.map { it.name })
        listView.adapter = adapter

        // Set the item click listener
//        listView.setOnItemClickListener { _, _, position, _ ->
//            val selectedFoodItem = viewModel.items[position]
//            val intent = Intent(this, ModificationActivity::class.java).apply {
//                putExtra("selected_item", selectedFoodItem)
//            }
//            startActivity(intent)
//        }
    }
}
