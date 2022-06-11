package com.fiz.e_learn.ui.screens.login.create_account

sealed class CreateAccountAction {
    object Create : CreateAccountAction()
    object Error : CreateAccountAction()
}