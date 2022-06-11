package com.fiz.e_learn.ui.screens.login.enter_code

data class EnterCodeViewState(
    val codes: List<String> = listOf("", "", "", ""),
    val isLoading: Boolean = false,
) {
    val isChangePasswordButtonEnabled: Boolean
        get() = codes.all { it.isNotBlank() }
}