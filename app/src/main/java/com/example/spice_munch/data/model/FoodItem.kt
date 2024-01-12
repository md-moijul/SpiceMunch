package com.example.spice_munch.data.model

import java.io.Serializable

data class FoodItem(
    val name: String,
    val category: String,
    val price: Double
) : Serializable

