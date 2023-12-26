package com.example.spice_munch.ui.fragment.allergies

import com.example.spice_munch.data.model.AllergiesModel
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class AllergiesModelTest {

    private lateinit var allergiesModel: AllergiesModel

    @Before
    fun setUp() {
        allergiesModel = AllergiesModel()
    }

    @Test
    fun toggleNutsAllergy_changesStateCorrectly() {
        allergiesModel.toggleNutsAllergy()
        assertTrue(allergiesModel.nuts)

        allergiesModel.toggleNutsAllergy()
        assertFalse(allergiesModel.nuts)
    }

    @Test
    fun toggleDairyAllergy_changesStateCorrectly() {
        allergiesModel.toggleDairyAllergy()
        assertTrue(allergiesModel.dairy)

        allergiesModel.toggleDairyAllergy()
        assertFalse(allergiesModel.dairy)
    }

    @Test
    fun toggleSeaFoodsAllergy_changesStateCorrectly() {
        allergiesModel.toggleSeaFoodsAllergy()
        assertTrue(allergiesModel.seaFoods)

        allergiesModel.toggleSeaFoodsAllergy()
        assertFalse(allergiesModel.seaFoods)
    }

    @Test
    fun toggleWheatAllergy_changesStateCorrectly() {
        allergiesModel.toggleWheatAllergy()
        assertTrue(allergiesModel.wheat)

        allergiesModel.toggleWheatAllergy()
        assertFalse(allergiesModel.wheat)
    }
}

