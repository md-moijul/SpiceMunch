package com.example.spice_munch.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.spice_munch.R

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        // Get the counter value from the Intent
        val counterValue = intent.getIntExtra("counter_value", 0)

        // Find the TextView and set the counter value
        val counterTextView: TextView = findViewById(R.id.counterTextView)
        counterTextView.text = "Table number: $counterValue"


        val selectItemButton: Button = findViewById(R.id.selectItemButton)
        selectItemButton.setOnClickListener {
            // Intent to start ModificationActivity
            val intent = Intent(this, ModificationActivity::class.java)
            startActivity(intent)
        }
    }
}
