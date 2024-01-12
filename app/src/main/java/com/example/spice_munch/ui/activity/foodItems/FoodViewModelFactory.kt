package com.example.spice_munch.ui.activity.foodItems

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spice_munch.data.database.AppDatabase

class FoodViewModelFactory(private val repository: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FoodViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}