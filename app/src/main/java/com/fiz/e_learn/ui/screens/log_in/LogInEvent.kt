package com.fiz.e_learn.ui.screens.log_in

sealed class LogInEvent {
    object FingerprintClicked : LogInEvent()
    object ForgotPasswordClicked : LogInEvent()
    object SignInClicked : LogInEvent()
    object SignInWithGoogleClicked : LogInEvent()
    object SignUpClicked : LogInEvent()
    data class EmailChanged(val value: String) : LogInEvent()
    data class PasswordChanged(val value: String) : LogInEvent()
}