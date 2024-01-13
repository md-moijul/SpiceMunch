package com.example.spice_munch.ui.activity.foodItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.FoodCategory
import com.example.spice_munch.data.model.FoodItem
import com.example.spice_munch.data.model.OrderItem

class FoodViewModel : ViewModel() {


    private val allItems = listOf(
        FoodItem("Tikka Masala", FoodCategory.MAIN, 12.99),
        FoodItem("Vindaloo", FoodCategory.MAIN, 13.99),
        FoodItem("Makhani", FoodCategory.MAIN, 10.99),

        // Sides
        FoodItem("Saag Aloo", FoodCategory.SIDE, 5.99),
        FoodItem("Aloo Gobi", FoodCategory.SIDE, 4.99),


        // Starters
        FoodItem("Chicken Pakora", FoodCategory.STARTER, 6.99),
        FoodItem("Onion Bhajis", FoodCategory.STARTER, 4.99),
        FoodItem("Sheekh Kebab", FoodCategory.STARTER, 7.99),
        FoodItem("Tandoori Chicken", FoodCategory.STARTER, 8.99),

        // Rice
        FoodItem("Plain Rice", FoodCategory.RICE, 3.50),
        FoodItem("Pilau Rice", FoodCategory.RICE, 3.99),

        // Bread
        FoodItem("Naan", FoodCategory.BREAD, 2.99),
        FoodItem("Chapati", FoodCategory.BREAD, 1.99),
        FoodItem("Roti", FoodCategory.BREAD, 1.75)
    )

    // Filter to only include MAIN category items

    val itemsMains: List<FoodItem> = allItems.filter { it.category == FoodCategory.MAIN }
    val itemsSides: List<FoodItem> = allItems.filter { it.category == FoodCategory.SIDE }
    val itemsStarters: List<FoodItem> = allItems.filter { it.category == FoodCategory.STARTER }
    val itemsRice: List<FoodItem> = allItems.filter { it.category == FoodCategory.RICE }
    val itemsBread: List<FoodItem> = allItems.filter { it.category == FoodCategory.BREAD }


}