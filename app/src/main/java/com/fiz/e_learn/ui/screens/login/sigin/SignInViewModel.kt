package com.fiz.e_learn.ui.screens.login.sigin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.e_learn.data.repositories.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val userRepository: UserRepositoryImpl) :
    ViewModel() {

    var viewState by mutableStateOf(SignInViewState())
        private set

    var viewAction: MutableSharedFlow<SignInAction> = MutableSharedFlow()
        private set

    fun reduce(event: SignInEvent) {
        when (event) {
            SignInEvent.FingerprintClicked -> {}
            SignInEvent.ForgotPasswordClicked -> forgotPasswordClicked()
            SignInEvent.SignInClicked -> signInClicked()
            SignInEvent.SignInWithGoogleClicked -> signInWithGoogleClicked()
            SignInEvent.SignUpClicked -> signUpClicked()
            is SignInEvent.EmailChanged -> emailChanged(event.value)
            is SignInEvent.PasswordChanged -> passwordChanged(event.value)
        }
    }

    private fun signUpClicked() {
        viewModelScope.launch {
            viewAction.emit(SignInAction.MoveSignUpScreen)
        }
    }

    private fun forgotPasswordClicked() {
        viewModelScope.launch {
            viewAction.emit(SignInAction.MoveForgotPasswordScreen)
        }
    }

    private fun emailChanged(value: String) {
        viewState = viewState.copy(email = value)
    }

    private fun passwordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }

    private fun signInClicked() {
        viewState = viewState.copy(isLoading = true)
        viewModelScope.launch {
            val email = viewState.email
            val password = viewState.password
            val response = userRepository.validateEmailPassword(email, password)
            if (response) {
                viewAction.emit(SignInAction.MoveHomeContentScreen(email))
            } else {
                viewAction.emit(SignInAction.ShowError)
            }

            viewState = viewState.copy(
                isLoading = false
            )
        }
    }

    private fun signInWithGoogleClicked() {
        viewModelScope.launch {
            viewAction.emit(SignInAction.MoveHomeContentScreen("Alex Joe"))
        }
    }
}
