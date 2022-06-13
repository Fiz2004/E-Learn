package com.fiz.e_learn.ui.screens.login.change_password

data class ChangePasswordViewState(
    val newPassword: String = "",
    val confirmPassword: String = "",
    val numberPhone: String = "",
    val isLoading: Boolean = false,
) {
    val isSavePasswordButtonEnabled: Boolean
        get() = newPassword.isNotBlank() && newPassword == confirmPassword
}