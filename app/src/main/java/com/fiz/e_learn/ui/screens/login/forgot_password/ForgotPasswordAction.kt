package com.fiz.e_learn.ui.screens.login.forgot_password

sealed class ForgotPasswordAction {
    data class MoveEnterCode(val numberPhone: String) : ForgotPasswordAction()
    object ShowError : ForgotPasswordAction()
}