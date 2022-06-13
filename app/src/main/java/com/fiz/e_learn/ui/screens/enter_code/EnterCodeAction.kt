package com.fiz.e_learn.ui.screens.enter_code

sealed class EnterCodeAction {
    object ShowNewResendCodeSend : EnterCodeAction()
    object ShowError : EnterCodeAction()
    data class MoveChangePasswordScreen(val numberPhone: String) : EnterCodeAction()
}