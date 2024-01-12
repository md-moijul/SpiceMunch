package com.example.spice_munch.ui.activity.modification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.Allergy
import com.example.spice_munch.data.model.Extra
import com.example.spice_munch.data.model.Option
import com.example.spice_munch.data.model.OrderItem

class OrderSharedViewModel : ViewModel() {

    private val _orderItem = MutableLiveData<OrderItem>()
    val orderItem: LiveData<OrderItem> = _orderItem
//
//    private val _selectedOption = MutableLiveData<Option>()
//    val selectedOption: LiveData<Option> = _selectedOption

//    private val _extras = MutableLiveData<List<Extra>>(emptyList())
//    val extras: LiveData<List<Extra>> = _extras

//
//    init {
//        _selectedOption.value = Option.CHICKEN // Default option
//    }

    // Initialize with default values
    init {
        _orderItem.value = OrderItem(
            name = "Default Item",
            option = Option.CHICKEN,
            extras = listOf(),
            allergies = listOf(),
            spiceLevel = "Mild",
            amount = 1.0
        )
    }

    fun selectOption(option: Option) {
        _orderItem.value = _orderItem.value?.copy(option = option)
    }
    fun setSpiceLevel(spiceLevel: String) {
        _orderItem.value = _orderItem.value?.copy(spiceLevel = spiceLevel)
    }

    fun toggleExtra(extra: Extra) {
        _orderItem.value?.let { currentItem ->
            val currentExtras = currentItem.extras.toMutableList()

            if (currentExtras.contains(extra)) {
                currentExtras.remove(extra)
            } else {
                currentExtras.add(extra)
            }

            _orderItem.value = currentItem.copy(extras = currentExtras)
        }
    }


    fun toggleAllergy(allergy: Allergy) {
        _orderItem.value = _orderItem.value?.let {
            val updatedAllergies = it.allergies.toMutableList().apply {
                if (contains(allergy)) remove(allergy) else add(allergy)
            }
            it.copy(allergies = updatedAllergies)
        }
    }

    fun increaseAmount() {
        _orderItem.value = _orderItem.value?.let {
            it.copy(amount = it.amount + 1)
        }
    }

    fun decreaseAmount() {
        _orderItem.value = _orderItem.value?.let {
            if (it.amount > 1) {
                it.copy(amount = it.amount - 1)
            } else it
        }
    }


}