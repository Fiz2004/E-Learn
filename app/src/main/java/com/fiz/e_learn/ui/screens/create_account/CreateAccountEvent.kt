package com.fiz.e_learn.ui.screens.create_account

sealed class CreateAccountEvent {
    object FingerprintClicked : CreateAccountEvent()
    object SignInClicked : CreateAccountEvent()
    object CreateAccountClicked : CreateAccountEvent()
    object TermsOfServicesClicked : CreateAccountEvent()
    object PrivacyPolicyClicked : CreateAccountEvent()
    data class UsernameChanged(val value: String) : CreateAccountEvent()
    data class EmailChanged(val value: String) : CreateAccountEvent()
    data class PasswordChanged(val value: String) : CreateAccountEvent()
    data class PrivacyChanged(val value: Boolean) : CreateAccountEvent()
}