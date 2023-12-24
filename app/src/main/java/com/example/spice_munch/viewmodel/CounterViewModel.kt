package com.example.spice_munch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.model.CounterModel

class CounterViewModel : ViewModel() {
    private val model = CounterModel()

    // LiveData to expose the count
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    init {
        // Initialize the count value
        _count.value = model.count
    }

    // Function to increment count
    fun incrementCount() {
        model.count++
        _count.value = model.count
    }
}
