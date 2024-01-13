package com.example.spice_munch.ui.activity.summary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.spice_munch.R
import com.example.spice_munch.data.model.OrderManager
import com.example.spice_munch.databinding.ActivitySummaryBinding
import com.example.spice_munch.databinding.DialogPaymentBinding
import com.example.spice_munch.ui.activity.modification.ModificationActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.io.Serializable

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListView()
        updateTotalPrice()

        binding.payButton.setOnClickListener {
            showPaymentDialog()
        }
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

    private fun updateTotalPrice() {
        val totalPrice = OrderManager.orderItems.sumOf { it.price * it.amount }
        binding.totalPriceTextView.text = "Total Price: £%.2f".format(totalPrice)
    }

    override fun onResume() {
        super.onResume()
        // Refresh the list and total price in case OrderManager.orderItems has changed
        (binding.listViewSummary.adapter as? SummaryAdapter)?.updateItems(OrderManager.orderItems)
        updateTotalPrice()
    }

    private fun showPaymentDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_payment, null, false)
        val dialogBinding = DialogPaymentBinding.bind(dialogView)

        val totalPrice = OrderManager.orderItems.sumOf { it.price * it.amount }
        dialogBinding.textViewTotalPrice.text = "Total Price: £%.2f".format(totalPrice)

        AlertDialog.Builder(this)
            .setTitle("Pay Online")
            .setView(dialogView)
            .setPositiveButton("Confirm") { dialog, _ -> dialog.dismiss() }
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
            .show()
    }

}