package com.fiz.e_learn.ui.on_boarding

import androidx.lifecycle.ViewModel
import com.fiz.e_learn.R
import kotlinx.coroutines.flow.MutableStateFlow

enum class OnBoardingState {
    Page1,
    Page2,
    Page3,
    Page4,
}

class OnBoardingViewModel : ViewModel() {
    var uiState = MutableStateFlow(OnBoardingState.Page1)
        private set

    fun getMainImage(): Int {
        return when (uiState.value) {

            OnBoardingState.Page1 -> {
                R.drawable.on_boarding1
            }

            OnBoardingState.Page2 -> {
                R.drawable.on_boarding2
            }

            OnBoardingState.Page3 -> {
                R.drawable.on_boarding3
            }
            OnBoardingState.Page4 -> {
                R.drawable.on_boarding4
            }
        }
    }

    fun getImageFloatingButton(): Int {
        return when (uiState.value) {
            OnBoardingState.Page1 -> R.drawable.ic_stade1
            OnBoardingState.Page2 -> R.drawable.ic_stade2
            OnBoardingState.Page3 -> R.drawable.ic_stade3
            OnBoardingState.Page4 -> R.drawable.ic_stade4
        }

    }

    fun setPage(page: String?) {
        when (page?.toInt()) {
            1 -> uiState.value = OnBoardingState.Page1
            2 -> uiState.value = OnBoardingState.Page2
            3 -> uiState.value = OnBoardingState.Page3
            4 -> uiState.value = OnBoardingState.Page4
        }
    }
}
