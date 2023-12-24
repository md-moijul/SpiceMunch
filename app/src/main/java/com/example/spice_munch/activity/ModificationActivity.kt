package com.example.spice_munch.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.spice_munch.R

class ModificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modification)


        // Extract the selected food item from the Intent
        val selectedFoodItem = intent.getStringExtra("selected_item") ?: "No item selected"

        // Find the TextView and set the selected food item
        val selectedItemTextView: TextView = findViewById(R.id.selectedItemTextView)
        selectedItemTextView.text = selectedFoodItem
    }
}