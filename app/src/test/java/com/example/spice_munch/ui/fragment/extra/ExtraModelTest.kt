package com.example.spice_munch.ui.fragment.extra

import com.example.spice_munch.data.model.ExtraModel
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ExtraModelTest {

    private lateinit var extraModel: ExtraModel

    @Before
    fun setUp() {
        extraModel = ExtraModel()
    }

    @Test
    fun testInitialStates() {
        assertFalse(extraModel.mushroom)
        assertFalse(extraModel.cream)
        assertFalse(extraModel.coriander)
        assertFalse(extraModel.onion)
    }

    @Test
    fun testToggleMushroom() {
        extraModel.mushroom = !extraModel.mushroom
        assertTrue(extraModel.mushroom)
    }

    @Test
    fun testToggleCream() {
        extraModel.cream = !extraModel.cream
        assertTrue(extraModel.cream)
    }

    @Test
    fun testToggleCoriander() {
        extraModel.coriander = !extraModel.coriander
        assertTrue(extraModel.coriander)
    }

    @Test
    fun testToggleOnion() {
        extraModel.onion = !extraModel.onion
        assertTrue(extraModel.onion)
    }
}
