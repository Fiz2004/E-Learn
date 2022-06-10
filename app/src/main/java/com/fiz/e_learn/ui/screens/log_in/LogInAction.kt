package com.fiz.e_learn.ui.screens.log_in

sealed class LogInAction {
    object MoveHomeContent : LogInAction()
    object ShowError : LogInAction()
    object MoveForgotPassword : LogInAction()
    object MoveSignUp : LogInAction()
}