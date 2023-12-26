package com.example.spice_munch.data.model

class AmountModel {
    private var number: Int = 1

    fun getNumber(): Int {
        return number
    }

    fun increaseNumber() {
        number++
    }

    fun decreaseNumber() {
        if (number > 1) {
            number--
        }
    }
}