package com.fiz.e_learn.ui.screens.login.forgot_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
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
        viewState = viewState.copy(phone = value)
    }

    private fun verificationCodeClicked() {
        viewModelScope.launch {
            viewAction.emit(ForgotPasswordAction.MoveEnterCode)
        }
    }

    private fun continueClicked() {
        viewModelScope.launch {
            viewAction.emit(ForgotPasswordAction.MoveEnterCode)
        }
    }

}