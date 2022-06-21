package com.fiz.e_learn.ui.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.e_learn.domain.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

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

    fun initUser(email: String) {
        viewModelScope.launch {
            val userName = userRepository.getUserName(email)
            val numberPhone = userRepository.getPhoneNumber(email)
            viewState = viewState.copy(
                userName = userName,
                numberPhone = numberPhone
            )
        }
    }

}

data class MainViewState(
    val search: String = "",
    val userName: String = "",
    val numberPhone: String = ""
)

sealed class MainEvent {
    data class SearchChanged(val value: String) : MainEvent()
}

sealed class MainEffects