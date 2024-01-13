package com.example.spice_munch.data.model

object OrderManager {
    var orderItems: MutableList<OrderItem> = mutableListOf()

    fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
    }


}
