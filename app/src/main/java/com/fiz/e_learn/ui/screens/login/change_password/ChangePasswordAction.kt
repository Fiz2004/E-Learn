package com.fiz.e_learn.ui.screens.login.change_password

sealed class ChangePasswordAction {
    object MoveInfoScreen : ChangePasswordAction()
    object ShowError : ChangePasswordAction()
}