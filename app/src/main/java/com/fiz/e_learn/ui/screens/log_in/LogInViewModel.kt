package com.fiz.e_learn.ui.screens.log_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor():ViewModel() {
    var emailId by mutableStateOf<String>("")
        private set

    var password by mutableStateOf<String>("")
        private set

    fun newEmailId(emailId: String) {
        this.emailId=emailId
    }

    fun newPassword(password: String) {
        this.password=password
    }
}
