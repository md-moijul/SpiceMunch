package com.example.spice_munch.ui.fragment.spiceLevel

import com.example.spice_munch.data.model.SpiceLevelModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SpiceLevelModelTest {

    private lateinit var spiceLevelModel: SpiceLevelModel

    @Before
    fun setUp() {
        spiceLevelModel = SpiceLevelModel()
    }

    @Test
    fun testSetSpiceLevel() {
        spiceLevelModel.setSpiceLevel(SpiceLevelModel.SpiceLevel.MILD)
        assertEquals(SpiceLevelModel.SpiceLevel.MILD, spiceLevelModel.currentSpiceLevel)

        spiceLevelModel.setSpiceLevel(SpiceLevelModel.SpiceLevel.MEDIUM)
        assertEquals(SpiceLevelModel.SpiceLevel.MEDIUM, spiceLevelModel.currentSpiceLevel)

        spiceLevelModel.setSpiceLevel(SpiceLevelModel.SpiceLevel.HOT)
        assertEquals(SpiceLevelModel.SpiceLevel.HOT, spiceLevelModel.currentSpiceLevel)

        spiceLevelModel.setSpiceLevel(SpiceLevelModel.SpiceLevel.EXTRA_HOT)
        assertEquals(SpiceLevelModel.SpiceLevel.EXTRA_HOT, spiceLevelModel.currentSpiceLevel)
    }
}
