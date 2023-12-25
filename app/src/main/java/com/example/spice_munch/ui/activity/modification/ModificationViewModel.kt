package com.example.spice_munch.ui.activity.modification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class ModificationViewModel : ViewModel() {
    private val _selectedOptionId = MutableLiveData<Int>()
    val selectedOptionId: LiveData<Int> = _selectedOptionId

    fun selectOption(optionId: Int) {
        _selectedOptionId.value = optionId
    }
}
