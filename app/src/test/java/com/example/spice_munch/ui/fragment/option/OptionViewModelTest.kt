package com.example.spice_munch.ui.fragment.option

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.spice_munch.data.model.OptionModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.verify

class OptionViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: OptionViewModel
    private lateinit var optionObserver: Observer<OptionModel.Option>

    @Before
    fun setUp() {
        viewModel = OptionViewModel()
        optionObserver = Mockito.mock(Observer::class.java) as Observer<OptionModel.Option>
        viewModel.selectedOption.observeForever(optionObserver)
    }

    @Test
    fun testSelectOption() {
        viewModel.selectOption(OptionModel.Option.LAMB)
        verify(optionObserver).onChanged(OptionModel.Option.LAMB)

        viewModel.selectOption(OptionModel.Option.PRAWN)
        verify(optionObserver).onChanged(OptionModel.Option.PRAWN)

        viewModel.selectOption(OptionModel.Option.VEGETABLE)
        verify(optionObserver).onChanged(OptionModel.Option.VEGETABLE)
    }
}
