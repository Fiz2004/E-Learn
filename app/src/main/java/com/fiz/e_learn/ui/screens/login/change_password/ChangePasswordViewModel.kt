package com.fiz.e_learn.ui.screens.login.change_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChangePasswordViewModel @Inject constructor() : ViewModel() {

    var viewState by mutableStateOf(ChangePasswordViewState())
        private set

    var viewAction: MutableSharedFlow<ChangePasswordAction> = MutableSharedFlow()
        private set

    fun reduce(event: ChangePasswordEvent) {
        when (event) {
            is ChangePasswordEvent.ConfirmPasswordChanged -> confirmPasswordChanged(event.value)
            is ChangePasswordEvent.NewPasswordChanged -> newPasswordChanged(event.value)
            ChangePasswordEvent.SavePasswordClicked -> savePasswordClicked()
        }
    }

    private fun savePasswordClicked() {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            // Отправляем запрос на изменение пароля
            val response = run {
                delay(3000)
                val isChangePasswordTrue = true
                isChangePasswordTrue
            }

            val action = if (response)
                ChangePasswordAction.MoveInfoScreen
            else
                ChangePasswordAction.ShowError
            viewAction.emit(action)

            viewState = viewState.copy(isLoading = false)
        }
    }

    private fun newPasswordChanged(value: String) {
        viewState = viewState.copy(newPassword = value)
    }

    private fun confirmPasswordChanged(value: String) {
        viewState = viewState.copy(confirmPassword = value)

    }


}