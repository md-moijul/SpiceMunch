package com.example.spice_munch.ui.fragment.option

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.OptionModel

class OptionViewModel : ViewModel() {
    private val _selectedOption = MutableLiveData<OptionModel.Option>()
    val selectedOption: LiveData<OptionModel.Option> get() = _selectedOption

    // Initialize with Chicken as the default selected option
    init {
        _selectedOption.value = OptionModel.Option.CHICKEN
    }

    fun selectOption(option: OptionModel.Option) {
        _selectedOption.value = option
    }
}