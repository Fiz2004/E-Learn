package com.fiz.e_learn.ui.screens.log_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiz.e_learn.data.repositories.UserRepository
import com.fiz.e_learn.ui.screens.create_account.CreateAccountState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class LogInState{
    object Create:LogInState()
    object Load:LogInState()
    object Access:LogInState()
    object Error:LogInState()
}

@HiltViewModel
class LogInViewModel @Inject constructor(private val userRepository: UserRepository):ViewModel() {
    var emailId by mutableStateOf<String>("")
        private set

    var password by mutableStateOf<String>("")
        private set

    var UIState by mutableStateOf<LogInState>(LogInState.Create)
        private set

    fun newEmailId(emailId: String) {
        this.emailId=emailId
    }

    fun newPassword(password: String) {
        this.password=password
    }

    fun clickSignIn() {
        UIState=LogInState.Load
        viewModelScope.launch {
            userRepository.loadUser().collectLatest {
                if (it.firstOrNull{it.email==emailId && it.password==password}!=null){
                    UIState=LogInState.Access
                }
                else {
                    UIState = LogInState.Error
                }
            }
        }
    }

    fun onErrorShow(){
        UIState = LogInState.Create
    }

    fun onClickSignIn() {
        UIState = LogInState.Load
    }
}
