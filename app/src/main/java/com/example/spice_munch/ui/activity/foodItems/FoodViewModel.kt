package com.example.spice_munch.ui.activity.foodItems

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spice_munch.data.database.AppDatabase
import com.example.spice_munch.data.entity.FoodItem
import kotlinx.coroutines.launch

class FoodViewModel(private val database: AppDatabase) : ViewModel() {

    val foodItems = database.foodItemDao().getAll()

    fun insertFoodItem(foodItem: FoodItem) = viewModelScope.launch {
        database.foodItemDao().insert(foodItem)
    }
}