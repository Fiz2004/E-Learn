package com.fiz.e_learn

import org.junit.Assert.*

import org.junit.Test

class MainViewModelTest {

    @Test
    fun removeItem() {
        // before
        val viewModel = MainViewModel()
        val item1 = MainItems(0)
        val item2 = MainItems(0)
        viewModel.addItem(item1)
        viewModel.addItem(item2)

        // during
        viewModel.removeItem(item1)

        // after
        assertEquals(viewModel.mainItems.page,1)
    }
}