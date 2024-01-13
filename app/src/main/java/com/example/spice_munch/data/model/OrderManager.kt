package com.example.spice_munch.data.model

object OrderManager {
    var orderItems: MutableList<OrderItem> = mutableListOf()
    var editingItemIndex: Int? = null

    fun addOrUpdateOrderItem(orderItem: OrderItem) {
        editingItemIndex?.let {
            orderItems[it] = orderItem
        } ?: run {
            orderItems.add(orderItem)
        }
        editingItemIndex = null // Reset after update
    }

    fun startEditingItem(index: Int) {
        editingItemIndex = index
    }
}

