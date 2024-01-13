package com.example.spice_munch.ui.activity.summary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spice_munch.R
import com.example.spice_munch.data.model.OrderItem
import com.example.spice_munch.data.model.OrderManager
import com.example.spice_munch.databinding.ActivitySummaryBinding
import com.example.spice_munch.ui.activity.foodItems.FoodItemAdapter
import com.example.spice_munch.ui.activity.foodItems.FoodViewModel

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListView()
    }

    private fun setupListView() {
        val adapter = SummaryAdapter(OrderManager.orderItems)
        binding.listViewSummary.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        // Refresh the list in case OrderManager.orderItems has changed
        (binding.listViewSummary.adapter as? SummaryAdapter)?.updateItems(OrderManager.orderItems)
    }
}


