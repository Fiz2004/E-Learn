package com.fiz.e_learn.ui.screens.log_in

data class LogInViewState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
)