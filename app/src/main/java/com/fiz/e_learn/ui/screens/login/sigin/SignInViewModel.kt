package com.fiz.e_learn.ui.screens.login.sigin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.e_learn.data.repositories.User
import com.fiz.e_learn.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val userRepository: UserRepository) :
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
            viewAction.emit(SignInAction.MoveSignUp)
        }
    }

    private fun forgotPasswordClicked() {
        viewModelScope.launch {
            viewAction.emit(SignInAction.MoveForgotPassword)
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
            userRepository.loadUser().collectLatest {
                if (validate(it))
                    viewAction.emit(SignInAction.MoveHomeContent)
                else
                    viewAction.emit(SignInAction.ShowError)

                viewState = viewState.copy(
                    isLoading = false
                )
            }
        }
    }

    private fun validate(allUsers: List<User>) =
        allUsers.firstOrNull { it.email == viewState.email && it.password == viewState.password } != null

    private fun signInWithGoogleClicked() {
        viewModelScope.launch {
            viewAction.emit(SignInAction.MoveHomeContent)
        }
    }
}
