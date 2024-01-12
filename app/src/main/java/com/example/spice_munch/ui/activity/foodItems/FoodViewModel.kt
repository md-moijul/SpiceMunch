package com.example.spice_munch.ui.activity.foodItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.FoodItem
import com.example.spice_munch.data.model.OrderItem

class FoodViewModel : ViewModel() {

    private val _orderItems = MutableLiveData<List<OrderItem>>(emptyList())
    val orderItems: LiveData<List<OrderItem>> = _orderItems


    val items = listOf(
        FoodItem("Masala", "Curry", 9.99),
        FoodItem("Korma", "Curry", 10.99),
        FoodItem("Sag Alu", "Side", 5.99),
        FoodItem("Rice", "Side", 3.99),
        FoodItem("Nan", "Bread", 2.99)
    )

    fun addOrderItem(orderItem: OrderItem) {
        val updatedOrderItems = _orderItems.value.orEmpty() + orderItem
        _orderItems.value = updatedOrderItems

    }
}