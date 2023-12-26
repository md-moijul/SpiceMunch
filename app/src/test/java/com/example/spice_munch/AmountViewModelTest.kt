package com.example.spice_munch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.spice_munch.ui.fragment.itemAmount.AmountViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

class AmountViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: AmountViewModel

    @Mock
    private lateinit var observer: Observer<Int>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = AmountViewModel()
        viewModel.currentNumber.observeForever(observer)
    }

    @Test
    fun testInitialNumber() {
        Assert.assertEquals(1, viewModel.currentNumber.value)
    }

    @Test
    fun testIncrementNumber() {
        viewModel.increaseNumber()
        verify(observer).onChanged(2)
    }

    @Test
    fun testDecrementNumber() {
        viewModel.increaseNumber() // increment first to 2
        viewModel.decreaseNumber()
        verify(observer).onChanged(2)
    }

}