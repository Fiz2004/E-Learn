package com.fiz.e_learn.ui.screens.login.forgot_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.e_learn.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

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
            viewState = viewState.copy(isLoading = true)
            val numberPhone = viewState.numberPhone
            // Проверяем есть ли такой номер в базе
            val responseValidate = run {
                val response = userRepository.validateNumberPhone(numberPhone)
                delay(3000)
                response
            }
            if (!responseValidate) {
                viewAction.emit(ForgotPasswordAction.ShowError)
                viewState = viewState.copy(isLoading = false)
                viewState = viewState.copy(isShowLabelSentVerificationCode = false)
            }

            viewState = viewState.copy(isShowLabelSentVerificationCode = true)
            // Ждем ответа что сообщение отправлено
            val response = run {
                delay(3000)
                true
            }

            val action = if (response)
                ForgotPasswordAction.MoveEnterCode(viewState.numberPhone)
            else
                ForgotPasswordAction.ShowError
            viewAction.emit(action)
            viewState = viewState.copy(isLoading = false)
            viewState = viewState.copy(isShowLabelSentVerificationCode = false)
        }
    }

}