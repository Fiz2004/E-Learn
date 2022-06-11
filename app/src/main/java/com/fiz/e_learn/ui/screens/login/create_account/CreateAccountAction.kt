package com.fiz.e_learn.ui.screens.login.create_account

sealed class CreateAccountAction {
    object MoveTermsOfServicesInfoScreen : CreateAccountAction()
    object MovePrivacyPolicyInfoScreen : CreateAccountAction()
    object MoveHomeContentScreen : CreateAccountAction()
    object MoveSignInScreen : CreateAccountAction()
    object ShowError : CreateAccountAction()
}