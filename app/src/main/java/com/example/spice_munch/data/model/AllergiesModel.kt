package com.example.spice_munch.data.model

class AllergiesModel {
    var nuts: Boolean = false
    var dairy: Boolean = false
    var seaFoods: Boolean = false
    var wheat: Boolean = false

    fun toggleNutsAllergy() {
        nuts = !nuts
    }

    fun toggleDairyAllergy() {
        dairy = !dairy
    }

    fun toggleSeaFoodsAllergy() {
        seaFoods = !seaFoods
    }

    fun toggleWheatAllergy() {
        wheat = !wheat
    }
}

