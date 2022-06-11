package com.fiz.e_learn.ui.screens.create_account

sealed class CreateAccountAction {
    object Create : CreateAccountAction()
    object Error : CreateAccountAction()
}