package com.example.spice_munch.ui.fragment.allergies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.spice_munch.data.model.AllergiesModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.kotlin.any

class AllergiesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: AllergiesViewModel
    private lateinit var allergiesObserver: Observer<AllergiesModel>

    @Before
    fun setUp() {
        viewModel = AllergiesViewModel()
        allergiesObserver = mock(Observer::class.java) as Observer<AllergiesModel>
        viewModel.allergies.observeForever(allergiesObserver)
    }

    @Test
    fun toggleNutsAllergy_updatesLiveData() {
        viewModel.toggleNutsAllergy()
        verify(allergiesObserver, times(1)).onChanged(any())
    }

    @Test
    fun toggleDairyAllergy_updatesLiveData() {
        viewModel.toggleDairyAllergy()
        verify(allergiesObserver, times(1)).onChanged(any())
    }

    @Test
    fun toggleSeaFoodsAllergy_updatesLiveData() {
        viewModel.toggleSeaFoodsAllergy()
        verify(allergiesObserver, times(1)).onChanged(any())
    }

    @Test
    fun toggleWheatAllergy_updatesLiveData() {
        viewModel.toggleWheatAllergy()
        verify(allergiesObserver, times(1)).onChanged(any())
    }
}