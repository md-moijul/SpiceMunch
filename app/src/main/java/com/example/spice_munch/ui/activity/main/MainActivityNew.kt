package com.example.spice_munch.ui.activity.main
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.view.View
import androidx.activity.viewModels
import android.widget.AdapterView
import android.widget.Toast
import android.content.Intent
import android.widget.Button
import com.example.spice_munch.data.model.TablesModel
import com.example.spice_munch.R
import com.example.spice_munch.ui.activity.foodItems.FoodActivity
import androidx.lifecycle.ViewModelProvider


class MainActivityNew : ComponentActivity() {

    private val viewModel: TablesViewModel by viewModels()
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var adapterItems: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main);

        title = "Tables"

        autoCompleteTextView = findViewById(R.id.autocompletetxt);
        adapterItems = ArrayAdapter(this, R.layout.list_item, viewModel.tableOptions)
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }
        })
        val continueButton: Button = findViewById(R.id.continuebtn)
        continueButton.setOnClickListener {
            val selectedTable = autoCompleteTextView.text.toString().trim()

            if (selectedTable.isNotEmpty()) {
                val tableNumber = selectedTable.removePrefix("Table ").toIntOrNull()

                if (tableNumber != null) {
                    val intent = Intent(this@MainActivityNew, FoodActivity::class.java).apply {
                        putExtra("table_number", tableNumber)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivityNew, "Invalid table number", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivityNew, "Please select a valid table", Toast.LENGTH_SHORT).show()
            }
        }
    }
}




