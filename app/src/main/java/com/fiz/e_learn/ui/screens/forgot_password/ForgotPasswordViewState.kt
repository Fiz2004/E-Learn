package com.fiz.e_learn.ui.screens.forgot_password

data class ForgotPasswordViewState(
    val phone: String = "",
    val isShowLabelSentVerificationCode: Boolean = false,
    val isLoading: Boolean = false,
) {
    val isContinueButtonEnabled: Boolean
        get() = phone.isNotBlank()
}