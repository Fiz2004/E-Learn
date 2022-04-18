package com.fiz.e_learn.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor() {
    fun saveUser(userName: String, emailId: String, password: String): Boolean {
        return true
    }
}