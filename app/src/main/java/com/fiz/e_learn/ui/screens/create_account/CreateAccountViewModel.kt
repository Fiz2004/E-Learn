package com.fiz.e_learn.ui.screens.create_account

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fiz.e_learn.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor (private val userRepository: UserRepository) : ViewModel() {
    var userName by mutableStateOf<String>("")
        private set

    var emailId by mutableStateOf<String>("")
        private set

    var password by mutableStateOf<String>("")
        private set

    var isPrivacy by mutableStateOf<Boolean>(false)
        private set

    fun clickCreateAccount(): Boolean {
        val simpleCheck=emailId.contains("@")&&emailId.contains(".")
        if (!simpleCheck) return false

        return userRepository.saveUser(userName,emailId,password)
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
        return userName.isNotBlank() && emailId.isNotBlank() && password.isNotBlank() && isPrivacy
    }

    fun clickPrivacyCheckBox(isPrivacy: Boolean) {
        this.isPrivacy=isPrivacy
    }
}
