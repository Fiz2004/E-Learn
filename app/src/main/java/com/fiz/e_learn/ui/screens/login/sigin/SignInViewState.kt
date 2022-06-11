package com.fiz.e_learn.ui.screens.login.sigin

data class SignInViewState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
)