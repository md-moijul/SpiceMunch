package com.example.spice_munch

import com.example.spice_munch.data.model.AmountModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AmountModelTest {

    private lateinit var AmountModel: AmountModel

    @Before
    fun setUp() {
        AmountModel = AmountModel()
    }

    @Test
    fun testIncrementNumber() {
        AmountModel.increaseNumber()
        Assert.assertEquals(2, AmountModel.getNumber())
    }

    @Test
    fun testDecrementNumber() {
        AmountModel.increaseNumber() // increasing first to 2
        AmountModel.decreaseNumber()
        Assert.assertEquals(1, AmountModel.getNumber())
    }

    @Test
    fun testDecrementNumberNotBelowOne() {
        AmountModel.decreaseNumber()
        Assert.assertEquals(1, AmountModel.getNumber()) // should not go below 1
    }
}