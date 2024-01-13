package com.example.spice_munch.ui.activity.foodItems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.spice_munch.R
import com.example.spice_munch.data.model.FoodItem
import com.example.spice_munch.databinding.ListItemFoodBinding

class FoodItemAdapter(private val items: List<FoodItem>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ListItemFoodBinding = if (convertView == null) {
            ListItemFoodBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        } else {
            ListItemFoodBinding.bind(convertView)
        }

        val item = getItem(position) as FoodItem
        binding.textViewFoodName.text = item.name

        return binding.root
    }
}