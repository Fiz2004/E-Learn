package com.fiz.e_learn.ui.screens.log_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.e_learn.data.repositories.User
import com.fiz.e_learn.data.repositories.UserRepository
import com.fiz.e_learn.ui.screens.create_account.CreateAccountAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    var viewState by mutableStateOf(LogInViewState())
        private set

    var viewAction: MutableSharedFlow<LogInAction> = MutableSharedFlow()
        private set

    fun reduce(event: LogInEvent) {
        when (event) {
            LogInEvent.FingerprintClicked -> {}
            LogInEvent.ForgotPasswordClicked -> forgotPasswordClicked()
            LogInEvent.SignInClicked -> signInClicked()
            LogInEvent.SignInWithGoogleClicked -> signInWithGoogleClicked()
            LogInEvent.SignUpClicked -> signUpClicked()
            is LogInEvent.EmailChanged -> emailChanged(event.value)
            is LogInEvent.PasswordChanged -> passwordChanged(event.value)
        }
    }

    private fun signUpClicked() {
        viewModelScope.launch {
            viewAction.emit(LogInAction.MoveSignUp)
        }
    }

    private fun forgotPasswordClicked() {
        viewModelScope.launch {
            viewAction.emit(LogInAction.MoveForgotPassword)
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
                    viewAction.emit(LogInAction.MoveHomeContent)
                else
                    viewAction.emit(LogInAction.ShowError)

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
            viewAction.emit(LogInAction.MoveHomeContent)
        }
    }
}
