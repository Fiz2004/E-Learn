package com.fiz.e_learn.ui.screens.create_account

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CreateAccountViewModel : ViewModel() {
    var userName by mutableStateOf<String>("")
        private set

    var emailId by mutableStateOf<String>("")
        private set

    var password by mutableStateOf<String>("")
        private set

    fun clickCreateAccount(): Boolean {
        return userName.isNotBlank() && emailId.isNotBlank() && password.isNotBlank()
                &&emailId.contains("@")&&emailId.contains(".")
    }

    fun newUserName(userName: String) {
        this.userName=userName
    }

    fun newEmailId(emailId: String) {
        this.emailId=emailId
    }

    fun newPassword(password: String) {
        this.password=password
    }

    fun isCreateAccountButtonEnabled(): Boolean {
        return userName.isNotBlank() && emailId.isNotBlank() && password.isNotBlank()
    }
}
