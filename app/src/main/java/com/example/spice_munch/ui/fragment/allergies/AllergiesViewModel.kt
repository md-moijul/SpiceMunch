package com.example.spice_munch.ui.fragment.allergies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.AllergiesModel


class AllergiesViewModel : ViewModel() {
    private val _allergies = MutableLiveData(AllergiesModel())
    val allergies: LiveData<AllergiesModel> get() = _allergies

    fun toggleNutsAllergy() {
        _allergies.value?.apply {
            nuts = !nuts
            _allergies.postValue(this)
        }
    }

    fun toggleDairyAllergy() {
        _allergies.value?.apply {
            dairy = !dairy
            _allergies.postValue(this)
        }
    }

    fun toggleSeaFoodsAllergy() {
        _allergies.value?.apply {
            seaFoods = !seaFoods
            _allergies.postValue(this)
        }
    }

    fun toggleWheatAllergy() {
        _allergies.value?.apply {
            wheat = !wheat
            _allergies.postValue(this)
        }
    }
}