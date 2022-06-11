package com.fiz.e_learn.ui.screens.login.create_account

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.e_learn.domain.repositories.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(private val userRepository: UserRepositoryImpl) :
    ViewModel() {

    var viewState by mutableStateOf(CreateAccountViewState())
        private set

    var viewAction: MutableSharedFlow<CreateAccountAction> = MutableSharedFlow()
        private set

    fun reduce(event: CreateAccountEvent) {
        when (event) {
            CreateAccountEvent.CreateAccountClicked -> createAccountClicked()
            CreateAccountEvent.FingerprintClicked -> fingerprintClicked()
            CreateAccountEvent.SignInClicked -> signInClicked()
            is CreateAccountEvent.UsernameChanged -> usernameChanged(event.value)
            is CreateAccountEvent.EmailChanged -> emailChanged(event.value)
            is CreateAccountEvent.PasswordChanged -> passwordChanged(event.value)
            is CreateAccountEvent.PrivacyChanged -> privacyChanged(event.value)
            CreateAccountEvent.PrivacyPolicyClicked -> privacyPolicyClicked()
            CreateAccountEvent.TermsOfServicesClicked -> termsOfServicesClicked()
            is CreateAccountEvent.PhoneNumberChanged -> phoneNumberChanged(event.value)
        }
    }

    private fun phoneNumberChanged(value: String) {
        viewState = viewState.copy(phoneNumber = value)
    }

    private fun termsOfServicesClicked() {
        viewModelScope.launch {
            viewAction.emit(CreateAccountAction.MoveTermsOfServicesInfoScreen)
        }
    }

    private fun privacyPolicyClicked() {
        viewModelScope.launch {
            viewAction.emit(CreateAccountAction.MovePrivacyPolicyInfoScreen)
        }
    }

    private fun signInClicked() {
        viewModelScope.launch {
            viewAction.emit(CreateAccountAction.MoveSignInScreen)
        }
    }

    private fun fingerprintClicked() {

    }

    private fun usernameChanged(value: String) {
        viewState = viewState.copy(userName = value)
    }

    private fun emailChanged(value: String) {
        viewState = viewState.copy(email = value)
    }

    private fun passwordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }

    private fun privacyChanged(value: Boolean) {
        viewState = viewState.copy(privacy = value)
    }

    private fun createAccountClicked() {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            val simpleCheck = viewState.email.contains("@") && viewState.email.contains(".")
            if (!simpleCheck) {
                viewAction.emit(CreateAccountAction.ShowError)
            } else {
                if (userRepository.saveUser(
                        viewState.userName,
                        viewState.email,
                        viewState.phoneNumber,
                        viewState.password
                    )
                )
                    viewAction.emit(CreateAccountAction.MoveHomeContentScreen)
                else
                    viewAction.emit(CreateAccountAction.ShowError)
            }
            viewState = viewState.copy(isLoading = false)
        }
    }
}
