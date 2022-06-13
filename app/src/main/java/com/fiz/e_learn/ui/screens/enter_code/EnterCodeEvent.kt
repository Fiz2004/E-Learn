package com.fiz.e_learn.ui.screens.enter_code

sealed class EnterCodeEvent {
    object ChangePasswordClicked : EnterCodeEvent()
    object ResendCodeClicked : EnterCodeEvent()
    data class LoadScreen(val numberPhone: String) : EnterCodeEvent()
    data class CodeChanged(val number: Int, val value: String) : EnterCodeEvent()
}