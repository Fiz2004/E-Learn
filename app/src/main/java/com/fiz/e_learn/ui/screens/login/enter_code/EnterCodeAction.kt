package com.fiz.e_learn.ui.screens.login.enter_code

sealed class EnterCodeAction {
    object MoveChangePasswordScreen : EnterCodeAction()
    object ShowNewResendCodeSend : EnterCodeAction()
    object ShowError : EnterCodeAction()
}