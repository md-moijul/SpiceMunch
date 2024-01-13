package com.example.spice_munch.ui.activity.summary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spice_munch.data.model.OrderManager
import com.example.spice_munch.databinding.ActivitySummaryBinding
import com.example.spice_munch.ui.activity.modification.ModificationActivity
import java.io.Serializable

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

        binding.listViewSummary.setOnItemClickListener { _, _, position, _ ->
            OrderManager.startEditingItem(position)
            val selectedOrderItem = OrderManager.orderItems[position]
            val intent = Intent(this, ModificationActivity::class.java).apply {
                putExtra("selected_order_item", selectedOrderItem as Serializable)
            }
            startActivity(intent)
        }


    }



    override fun onResume() {
        super.onResume()
        // Refresh the list in case OrderManager.orderItems has changed
        (binding.listViewSummary.adapter as? SummaryAdapter)?.updateItems(OrderManager.orderItems)
    }
}


