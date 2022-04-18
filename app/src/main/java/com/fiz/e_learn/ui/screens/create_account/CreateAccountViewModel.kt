package com.fiz.e_learn.ui.screens.create_account

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.e_learn.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class CreateAccountState{
    object Create:CreateAccountState()
    object Save:CreateAccountState()
    object LogIn:CreateAccountState()
    object Error:CreateAccountState()
}



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

    var UIState by mutableStateOf<CreateAccountState>(CreateAccountState.Create)
    private set

    fun clickCreateAccount() {
        val simpleCheck=emailId.contains("@")&&emailId.contains(".")
        if (!simpleCheck) {
            UIState = CreateAccountState.Error
            return
        }

        viewModelScope.launch {
            UIState=CreateAccountState.Save
            UIState = if (userRepository.saveUser(userName, emailId, password))
                CreateAccountState.LogIn
            else
                CreateAccountState.Error
        }
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

    fun onErrorShow() {
        UIState=CreateAccountState.Create
    }

    fun onClickCreateAccount() {
        UIState=CreateAccountState.Save
    }
}
