package com.fiz.e_learn.ui.screens.login.create_account

data class CreateAccountViewState(
    val userName: String = "",
    val email: String = "",
    val password: String = "",
    val phoneNumber: String = "",
    val privacy: Boolean = false,
    val isLoading: Boolean = false,
) {
    val isCreateAccountButtonEnabled: Boolean
        get() = userName.isNotBlank() &&
                email.isNotBlank() &&
                password.isNotBlank() &&
                phoneNumber.isNotBlank() &&
                privacy
}