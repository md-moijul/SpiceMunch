package com.example.spice_munch.ui.activity.foodItems

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spice_munch.R
import com.example.spice_munch.data.MyApplication
import com.example.spice_munch.data.adapter.FoodItemAdapter


class FoodActivity : AppCompatActivity() {
    private val viewModel: FoodViewModel by viewModels {
        FoodViewModelFactory((application as MyApplication).database)
    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        recyclerView = findViewById(R.id.recyclerViewFoodItems)
        adapter = FoodItemAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.foodItems.observe(this) { foodItems ->
            adapter.updateItems(foodItems)
        }
    }
}