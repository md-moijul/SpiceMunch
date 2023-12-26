package com.example.spice_munch.data.model

class OptionModel {
    enum class Option {
        CHICKEN, LAMB, PRAWN, VEGETABLE
    }

    var selectedOption: Option = Option.CHICKEN // Chicken is selected by default

    fun selectOption(option: Option) {
        selectedOption = option
    }
}
