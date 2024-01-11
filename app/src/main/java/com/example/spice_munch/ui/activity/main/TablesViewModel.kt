package com.example.spice_munch.ui.activity.main

import androidx.lifecycle.ViewModel
import com.example.spice_munch.data.model.TablesModel


class TablesViewModel : ViewModel() {

    private val currentTable = TablesModel()

    val tableOptions: Array<String>
        get() = currentTable.tableOptions

    private var selectedTable: Int = 0

    fun selectOption(option: Int) {
        selectedTable = option
    }
}
