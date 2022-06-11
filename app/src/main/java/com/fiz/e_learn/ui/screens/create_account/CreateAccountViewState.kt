package com.fiz.e_learn.ui.screens.create_account

data class CreateAccountViewState(
    val userName: String = "",
    val email: String = "",
    val password: String = "",
    val privacy: Boolean = false,
    val isLoading: Boolean = false,
) {
    val isCreateAccountButtonEnabled: Boolean
        get() = userName.isNotBlank() && email.isNotBlank() && password.isNotBlank() && privacy
}