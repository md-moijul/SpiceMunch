package com.example.spice_munch.ui.fragment.extra

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class ExtraViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ExtraViewModel
    private lateinit var extrasObserver: Observer<ExtraModel>

    @Before
    fun setUp() {
        viewModel = ExtraViewModel()
        extrasObserver = Mockito.mock(Observer::class.java) as Observer<ExtraModel>
        viewModel.extras.observeForever(extrasObserver)
    }

    @Test
    fun toggleMushroom_updatesLiveData() {
        viewModel.toggleMushroom()
        verify(extrasObserver, times(1)).onChanged(any())
    }

    @Test
    fun toggleCream_updatesLiveData() {
        viewModel.toggleCream()
        verify(extrasObserver, times(1)).onChanged(any())
    }

    @Test
    fun toggleCoriander_updatesLiveData() {
        viewModel.toggleCoriander()
        verify(extrasObserver, times(1)).onChanged(any())
    }

    @Test
    fun toggleOnion_updatesLiveData() {
        viewModel.toggleOnion()
        verify(extrasObserver, times(1)).onChanged(any())
    }
}
