package com.example.spice_munch.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "food_items")
data class FoodItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Double
)