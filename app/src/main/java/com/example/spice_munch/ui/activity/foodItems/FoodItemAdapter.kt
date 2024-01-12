package com.example.spice_munch.ui.activity.foodItems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.spice_munch.R
import com.example.spice_munch.data.model.FoodItem

class FoodItemAdapter(private val items: List<FoodItem>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.list_item_food, parent, false)

        val foodNameTextView: TextView = view.findViewById(R.id.textViewFoodName)
        val foodPriceTextView: TextView = view.findViewById(R.id.textViewFoodPrice)

        val item = getItem(position) as FoodItem
        foodNameTextView.text = item.name
        foodPriceTextView.text = "${item.price} $"

        return view
    }
}