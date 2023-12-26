package com.example.spice_munch.ui.fragment.spiceLevel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.spice_munch.data.model.SpiceLevelModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.junit.Assert.assertEquals

import org.mockito.kotlin.verify

class SpiceLevelViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: SpiceLevelViewModel

    // Use a captor to capture the argument passed to onChanged
    @Captor
    private lateinit var argumentCaptor: ArgumentCaptor<SpiceLevelModel>

    @Before
    fun setUp() {
        viewModel = SpiceLevelViewModel()
        MockitoAnnotations.openMocks(this) // Initialize captor
    }

    @Test
    fun testSetSpiceLevel() {
        val observer: Observer<SpiceLevelModel> = mock(Observer::class.java) as Observer<SpiceLevelModel>
        viewModel.spiceLevel.observeForever(observer)

        viewModel.setSpiceLevel(10) // Should be MILD
        verify(observer).onChanged(argumentCaptor.capture())
        assertEquals(SpiceLevelModel.SpiceLevel.MILD, argumentCaptor.value.currentSpiceLevel)

        viewModel.setSpiceLevel(35) // Should be MEDIUM
        verify(observer).onChanged(argumentCaptor.capture())
        assertEquals(SpiceLevelModel.SpiceLevel.MEDIUM, argumentCaptor.value.currentSpiceLevel)

        viewModel.setSpiceLevel(60) // Should be HOT
        verify(observer).onChanged(argumentCaptor.capture())
        assertEquals(SpiceLevelModel.SpiceLevel.HOT, argumentCaptor.value.currentSpiceLevel)

        viewModel.setSpiceLevel(85) // Should be EXTRA_HOT
        verify(observer).onChanged(argumentCaptor.capture())
        assertEquals(SpiceLevelModel.SpiceLevel.EXTRA_HOT, argumentCaptor.value.currentSpiceLevel)
    }
}
