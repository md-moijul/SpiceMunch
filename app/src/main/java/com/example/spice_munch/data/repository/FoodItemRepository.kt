package com.example.spice_munch.data.repository

import com.example.spice_munch.data.dao.FoodItemDao
import com.example.spice_munch.data.entity.FoodItem

class FoodItemRepository(private val foodItemDao: FoodItemDao) {
    fun getAllFoodItems() = foodItemDao.getAll()
    suspend fun insertFoodItem(foodItem: FoodItem) { foodItemDao.insert(foodItem) }
    // Add other methods as needed...
}