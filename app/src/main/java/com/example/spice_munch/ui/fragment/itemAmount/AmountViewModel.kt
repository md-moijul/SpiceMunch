package com.example.spice_munch.ui.fragment.itemAmount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.AmountModel

class AmountViewModel : ViewModel() {
    private val model = AmountModel()
    private val _currentAmount = MutableLiveData<Int>()
    val currentNumber: LiveData<Int> get() = _currentAmount

    init {
        _currentAmount.value = model.getNumber()
    }

    fun increaseNumber() {
        model.increaseNumber()
        _currentAmount.value = model.getNumber()
    }

    fun decreaseNumber() {
        model.decreaseNumber()
        _currentAmount.value = model.getNumber()
    }
}