package com.example.spice_munch.ui.fragment.option

import com.example.spice_munch.data.model.OptionModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class OptionModelTest {

    private lateinit var optionModel: OptionModel

    @Before
    fun setUp() {
        optionModel = OptionModel()
    }

    @Test
    fun testDefaultSelectedOption() {
        assertEquals(OptionModel.Option.CHICKEN, optionModel.selectedOption)
    }

    @Test
    fun testSelectOption() {
        optionModel.selectOption(OptionModel.Option.LAMB)
        assertEquals(OptionModel.Option.LAMB, optionModel.selectedOption)

        optionModel.selectOption(OptionModel.Option.PRAWN)
        assertEquals(OptionModel.Option.PRAWN, optionModel.selectedOption)

        optionModel.selectOption(OptionModel.Option.VEGETABLE)
        assertEquals(OptionModel.Option.VEGETABLE, optionModel.selectedOption)
    }
}
