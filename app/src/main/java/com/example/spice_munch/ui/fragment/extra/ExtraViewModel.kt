package com.example.spice_munch.ui.fragment.extra

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.ExtraModel

class ExtraViewModel : ViewModel() {
    private val _extras = MutableLiveData(ExtraModel())
    val extras: LiveData<ExtraModel> get() = _extras

    fun toggleMushroom() {
        _extras.value?.apply {
            mushroom = !mushroom
            _extras.postValue(this)
        }
    }

    fun toggleCream() {
        _extras.value?.apply {
            cream = !cream
            _extras.postValue(this)
        }
    }

    fun toggleCoriander() {
        _extras.value?.apply {
            coriander = !coriander
            _extras.postValue(this)
        }
    }

    fun toggleOnion() {
        _extras.value?.apply {
            onion = !onion
            _extras.postValue(this)
        }
    }
}
