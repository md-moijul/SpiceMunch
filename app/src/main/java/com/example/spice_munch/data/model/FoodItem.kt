package com.example.spice_munch.data.model

import java.io.Serializable

data class FoodItem(
    val name: String,
    val category: FoodCategory,
    val price: Double
) : Serializable

enum class FoodCategory {
    MAIN, SIDE, STARTER, RICE, BREAD
}