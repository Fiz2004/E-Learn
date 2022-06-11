package com.fiz.e_learn.ui.screens.login.forgot_password

sealed class ForgotPasswordEvent {
    object ContinueClicked : ForgotPasswordEvent()
    object VerificationCodeClicked : ForgotPasswordEvent()
    data class PhoneChanged(val value: String) : ForgotPasswordEvent()
}