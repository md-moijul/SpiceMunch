package com.example.spice_munch.ui.activity.main

class TablesViewModel {
        // private val currentTable = TablesModel()

        private var selectedTable: Int = 0


        fun selectOption(option: Int) {
            selectedTable = option
        }
}
