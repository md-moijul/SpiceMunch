package com.example.spice_munch.ui.fragment.spiceLevel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.SpiceLevelModel

class SpiceLevelViewModel : ViewModel() {
    private val _spiceLevelModel = MutableLiveData(SpiceLevelModel())
    val spiceLevel: LiveData<SpiceLevelModel> get() = _spiceLevelModel

    fun setSpiceLevel(progress: Int) {
        val level = when (progress) {
            in 0..25 -> SpiceLevelModel.SpiceLevel.MILD
            in 26..50 -> SpiceLevelModel.SpiceLevel.MEDIUM
            in 51..75 -> SpiceLevelModel.SpiceLevel.HOT
            else -> SpiceLevelModel.SpiceLevel.EXTRA_HOT
        }
        _spiceLevelModel.value?.setSpiceLevel(level)
        _spiceLevelModel.postValue(_spiceLevelModel.value)
    }
}