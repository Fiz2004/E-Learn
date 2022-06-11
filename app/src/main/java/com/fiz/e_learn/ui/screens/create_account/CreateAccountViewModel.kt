package com.fiz.e_learn.ui.screens.create_account

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.e_learn.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    var viewState by mutableStateOf(CreateAccountViewState())
        private set

    var viewAction: MutableSharedFlow<CreateAccountAction> = MutableSharedFlow()
        private set

    fun reduce(event: CreateAccountEvent) {
        when (event) {
            CreateAccountEvent.CreateAccountClicked -> createAccountClicked()
            CreateAccountEvent.FingerprintClicked -> TODO()
            CreateAccountEvent.SignInClicked -> TODO()
            is CreateAccountEvent.UsernameChanged -> usernameChanged(event.value)
            is CreateAccountEvent.EmailChanged -> emailChanged(event.value)
            is CreateAccountEvent.PasswordChanged -> passwordChanged(event.value)
            is CreateAccountEvent.PrivacyChanged -> privacyChanged(event.value)
            CreateAccountEvent.PrivacyPolicyClicked -> TODO()
            CreateAccountEvent.TermsOfServicesClicked -> TODO()
        }
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
                viewAction.emit(CreateAccountAction.Error)
            } else {
                if (userRepository.saveUser(
                        viewState.userName,
                        viewState.email,
                        viewState.password
                    )
                )
                    viewAction.emit(CreateAccountAction.Create)
                else
                    viewAction.emit(CreateAccountAction.Error)
            }
            viewState = viewState.copy(isLoading = false)
        }
    }
}
