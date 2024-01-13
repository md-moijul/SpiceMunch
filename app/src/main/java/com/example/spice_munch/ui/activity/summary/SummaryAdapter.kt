package com.example.spice_munch.ui.activity.summary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.spice_munch.data.model.OrderItem
import com.example.spice_munch.databinding.ListItemFoodBinding

class SummaryAdapter(private var items: List<OrderItem>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ListItemFoodBinding
        if (convertView == null) {
            binding = ListItemFoodBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        } else {
            binding = ListItemFoodBinding.bind(convertView)
        }

        val item = getItem(position) as OrderItem
        binding.textViewAmount.text = item.amount.toString()
        binding.textViewFoodName.text = item.name
        binding.textViewFoodPrice.text = String.format("Price: £%.2f", item.price * item.amount)

        return binding.root
    }

    fun updateItems(newItems: List<OrderItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}