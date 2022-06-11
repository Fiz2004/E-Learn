package com.fiz.e_learn.ui.screens.login.forgot_password

data class ForgotPasswordViewState(
    val numberPhone: String = "",
    val isShowLabelSentVerificationCode: Boolean = false,
) {
    val isContinueButtonEnabled: Boolean
        get() = numberPhone.isNotBlank() && !isShowLabelSentVerificationCode
}