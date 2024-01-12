package com.example.spice_munch.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.spice_munch.data.entity.FoodItem

@Dao
interface FoodItemDao {
    @Insert
    suspend fun insert(foodItem: FoodItem)

    @Query("SELECT * FROM food_items")
    fun getAll(): LiveData<List<FoodItem>>
}