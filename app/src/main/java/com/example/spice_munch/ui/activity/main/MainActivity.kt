package com.example.spice_munch.ui.activity.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import android.widget.TextView
import android.widget.Button
import com.example.spice_munch.R
import com.example.spice_munch.ui.activity.foodItems.FoodActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        // Get references to the TextView and Button
        val countTextView: TextView = findViewById(R.id.countTextView)
        val incrementButton: Button = findViewById(R.id.incrementButton)

        // Observe changes in the count LiveData
        viewModel.count.observe(this, Observer { count ->
            countTextView.text = count.toString()
        })

        // Set a click listener on the button to increment the count
        incrementButton.setOnClickListener {
            viewModel.incrementCount()
        }

        //
        val startButton: Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            // Intent to start FoodActivity
            val intent = Intent(this, FoodActivity::class.java)
            intent.putExtra("counter_value", viewModel.count.value ?: 0)
            startActivity(intent)
        }
    }
}
