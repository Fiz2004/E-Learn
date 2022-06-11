package com.fiz.e_learn.ui.screens.login.forgot_password

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
class ForgotPasswordViewModel @Inject constructor() : ViewModel() {

    var viewState by mutableStateOf(ForgotPasswordViewState())
        private set

    var viewAction: MutableSharedFlow<ForgotPasswordAction> = MutableSharedFlow()
        private set

    fun reduce(event: ForgotPasswordEvent) {
        when (event) {
            ForgotPasswordEvent.ContinueClicked -> continueClicked()
            ForgotPasswordEvent.VerificationCodeClicked -> verificationCodeClicked()
            is ForgotPasswordEvent.PhoneChanged -> phoneChanged(event.value)
        }
    }

    private fun phoneChanged(value: String) {
        viewState = viewState.copy(numberPhone = value)
    }

    private fun verificationCodeClicked() {
        viewModelScope.launch {
            viewAction.emit(ForgotPasswordAction.MoveEnterCode(viewState.numberPhone))
        }
    }

    private fun continueClicked() {
        viewModelScope.launch {
            viewState = viewState.copy(isShowLabelSentVerificationCode = true)
            // Отправляем запрос на получение кода
            val response = run {
                delay(3000)
                val isVerificationCodeSend = true
                isVerificationCodeSend
            }

            val action = if (response)
                ForgotPasswordAction.MoveEnterCode(viewState.numberPhone)
            else
                ForgotPasswordAction.ShowError
            viewAction.emit(action)

            viewState = viewState.copy(isShowLabelSentVerificationCode = false)
        }
    }

}