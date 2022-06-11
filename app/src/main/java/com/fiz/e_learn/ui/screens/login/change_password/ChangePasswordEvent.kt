package com.fiz.e_learn.ui.screens.login.change_password

sealed class ChangePasswordEvent {
    object SavePasswordClicked : ChangePasswordEvent()
    data class NewPasswordChanged(val value: String) : ChangePasswordEvent()
    data class ConfirmPasswordChanged(val value: String) : ChangePasswordEvent()
}