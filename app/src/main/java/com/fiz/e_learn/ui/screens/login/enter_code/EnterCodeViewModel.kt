package com.fiz.e_learn.ui.screens.login.enter_code

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
class EnterCodeViewModel @Inject constructor() : ViewModel() {

    var viewState by mutableStateOf(EnterCodeViewState())
        private set

    var viewAction: MutableSharedFlow<EnterCodeAction> = MutableSharedFlow()
        private set

    fun reduce(event: EnterCodeEvent) {
        when (event) {
            EnterCodeEvent.ChangePasswordClicked -> changePasswordClicked()
            EnterCodeEvent.ResendCodeClicked -> resendCodeClicked()
            is EnterCodeEvent.CodeChanged -> codeChanged(event.number, event.value)
        }
    }

    private fun codeChanged(number: Int, value: String) {
        val newCodes = viewState.codes.toMutableList()
        newCodes[number] = value
        viewState = viewState.copy(codes = newCodes)
    }

    private fun changePasswordClicked() {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            // Отправляем запрос на проверку кода
            val response = run {
                delay(3000)
                val isVerificationCodeSend = true
                isVerificationCodeSend
            }

            val action = if (response)
                EnterCodeAction.MoveChangePasswordScreen
            else
                EnterCodeAction.ShowError
            viewAction.emit(action)

            viewState = viewState.copy(isLoading = false)
        }
    }

    private fun resendCodeClicked() {
        viewModelScope.launch {
            viewAction.emit(EnterCodeAction.ShowNewResendCodeSend)
        }
    }

}