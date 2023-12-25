package com.example.spice_munch.ui.fragment.menu


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.DishOption

class MenuViewModel : ViewModel() {
    private val _dishOptions = MutableLiveData<List<DishOption>>()
    val dishOptions: LiveData<List<DishOption>> = _dishOptions

    init {
        loadDishOptions()
    }

    private fun loadDishOptions() {
        // Static list of options for demonstration purposes
        val options = listOf(
            DishOption("Chicken", false),
            DishOption("Lamb", false),
            DishOption("Prawn", false),
            DishOption("Vegetable", false)
        )

        // Post the options to the LiveData object
        _dishOptions.postValue(options)
    }

    fun onDishOptionSelected(option: DishOption, isSelected: Boolean) {
        // Update the dish option selection state
        option.isSelected = isSelected
        _dishOptions.value = _dishOptions.value
    }
}
