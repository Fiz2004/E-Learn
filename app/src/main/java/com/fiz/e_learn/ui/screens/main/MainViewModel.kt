package com.fiz.e_learn.ui.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    var viewState by mutableStateOf(MainViewState())
        private set

    var viewEffects: MutableSharedFlow<MainEffects> = MutableSharedFlow()
        private set

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.SearchChanged -> searchChanged(event.value)
        }
    }

    private fun searchChanged(value: String) {
        viewState = viewState.copy(search = value)
    }
}

data class MainViewState(
    val search: String = ""
)

sealed class MainEvent {
    data class SearchChanged(val value: String) : MainEvent()
}

sealed class MainEffects {

}