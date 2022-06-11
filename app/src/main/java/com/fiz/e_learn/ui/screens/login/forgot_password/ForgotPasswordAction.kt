package com.fiz.e_learn.ui.screens.login.forgot_password

sealed class ForgotPasswordAction {
    object MoveEnterCode : ForgotPasswordAction()
    object ShowError : ForgotPasswordAction()
}