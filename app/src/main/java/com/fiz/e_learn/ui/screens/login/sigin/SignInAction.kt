package com.fiz.e_learn.ui.screens.login.sigin

sealed class SignInAction {
    object MoveHomeContentScreen : SignInAction()
    object ShowError : SignInAction()
    object MoveForgotPasswordScreen : SignInAction()
    object MoveSignUpScreen : SignInAction()
}