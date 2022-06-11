package com.fiz.e_learn.ui.screens.forgot_password

sealed class ForgotPasswordAction {
    object MoveEnterCode : ForgotPasswordAction()
    object ShowError : ForgotPasswordAction()
}