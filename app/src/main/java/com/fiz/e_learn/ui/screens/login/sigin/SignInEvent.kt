package com.fiz.e_learn.ui.screens.login.sigin

sealed class SignInEvent {
    object FingerprintClicked : SignInEvent()
    object ForgotPasswordClicked : SignInEvent()
    object SignInClicked : SignInEvent()
    object SignInWithGoogleClicked : SignInEvent()
    object SignUpClicked : SignInEvent()
    data class EmailChanged(val value: String) : SignInEvent()
    data class PasswordChanged(val value: String) : SignInEvent()
}