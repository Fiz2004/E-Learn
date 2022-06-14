package com.fiz.e_learn.ui.screens.login.sigin

sealed class SignInAction {
    data class MoveHomeContentScreen (val userName:String) : SignInAction()
    object ShowError : SignInAction()
    object MoveForgotPasswordScreen : SignInAction()
    object MoveSignUpScreen : SignInAction()
}