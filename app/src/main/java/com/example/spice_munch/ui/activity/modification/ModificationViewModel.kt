package com.example.spice_munch.ui.activity.modification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.Allergy
import com.example.spice_munch.data.model.Extra
import com.example.spice_munch.data.model.FoodItem
import com.example.spice_munch.data.model.Option
import com.example.spice_munch.data.model.OrderItem

class OrderViewModel : ViewModel() {

    private val _orderItem = MutableLiveData<OrderItem>()
    val orderItem: LiveData<OrderItem> = _orderItem

    init {
        // Initialize with default values
        _orderItem.value = OrderItem(
            name = "Default Item",
            option = Option.CHICKEN,
            extras = listOf(),
            allergies = listOf(),
            spiceLevel = "Mild",
            amount = 1.0
        )
    }

    fun setOption(option: Option) {
        val currentOrder = _orderItem.value ?: return
        _orderItem.value = currentOrder.copy(option = option)
    }

    fun addExtra(extra: Extra) {
        val currentOrder = _orderItem.value ?: return
        val updatedExtras = currentOrder.extras.toMutableList().apply {
            if (!contains(extra)) add(extra)
        }
        _orderItem.value = currentOrder.copy(extras = updatedExtras)
    }

    fun removeExtra(extra: Extra) {
        val currentOrder = _orderItem.value ?: return
        val updatedExtras = currentOrder.extras.filter { it != extra }
        _orderItem.value = currentOrder.copy(extras = updatedExtras)
    }

    fun addAllergy(allergy: Allergy) {
        val currentOrder = _orderItem.value ?: return
        val updatedAllergies = currentOrder.allergies.toMutableList().apply {
            if (!contains(allergy)) add(allergy)
        }
        _orderItem.value = currentOrder.copy(allergies = updatedAllergies)
    }

    fun removeAllergy(allergy: Allergy) {
        val currentOrder = _orderItem.value ?: return
        val updatedAllergies = currentOrder.allergies.filter { it != allergy }
        _orderItem.value = currentOrder.copy(allergies = updatedAllergies)
    }

    fun setSpiceLevel(spiceLevel: String) {
        val currentOrder = _orderItem.value ?: return
        _orderItem.value = currentOrder.copy(spiceLevel = spiceLevel)
    }

    fun setAmount(amount: Double) {
        val currentOrder = _orderItem.value ?: return
        _orderItem.value = currentOrder.copy(amount = amount)
    }

    // Add other methods to modify the OrderItem as needed
}
