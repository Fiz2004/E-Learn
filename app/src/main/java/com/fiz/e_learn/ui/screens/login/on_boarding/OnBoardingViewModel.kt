package com.fiz.e_learn.ui.screens.login.on_boarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fiz.e_learn.R

data class OnBoardingState(val page: Int)

class OnBoardingViewModel : ViewModel() {
    var uiState by mutableStateOf(OnBoardingState(1))
        private set

    fun getMainImage(): Int {
        return when (uiState.page) {
            1 -> R.drawable.on_boarding1
            2 -> R.drawable.on_boarding2
            3 -> R.drawable.on_boarding3
            else -> R.drawable.on_boarding4
        }
    }

    fun getImageFloatingButton(): Int {
        return when (uiState.page) {
            1 -> R.drawable.ic_stade1
            2 -> R.drawable.ic_stade2
            3 -> R.drawable.ic_stade3
            else -> R.drawable.ic_stade4
        }

    }

    fun setPage(page: String?) {
        when (page?.toInt()) {
            1 -> uiState = OnBoardingState(1)
            2 -> uiState = OnBoardingState(2)
            3 -> uiState = OnBoardingState(3)
            4 -> uiState = OnBoardingState(4)
        }
    }
}
