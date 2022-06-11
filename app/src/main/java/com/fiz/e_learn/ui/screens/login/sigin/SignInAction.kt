package com.fiz.e_learn.ui.screens.login.sigin

sealed class SignInAction {
    object MoveHomeContent : SignInAction()
    object ShowError : SignInAction()
    object MoveForgotPassword : SignInAction()
    object MoveSignUp : SignInAction()
}