package com.example.spice_munch.data.model

class SpiceLevelModel {
    enum class SpiceLevel {
        MILD, MEDIUM, HOT, EXTRA_HOT
    }

    var currentSpiceLevel: SpiceLevel = SpiceLevel.MILD

    fun setSpiceLevel(level: SpiceLevel) {
        currentSpiceLevel = level
    }
}