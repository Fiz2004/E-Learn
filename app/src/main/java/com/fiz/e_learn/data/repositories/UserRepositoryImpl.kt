package com.fiz.e_learn.data.repositories

import com.fiz.e_learn.data.data_source.UserLocalDataSource
import com.fiz.e_learn.data.entity.UserEntity
import com.fiz.e_learn.domain.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class UserRepositoryImpl(private val userLocalDataSource: UserLocalDataSource) : UserRepository {
    override suspend fun saveUser(
        userName: String,
        email: String,
        numberPhone: String,
        password: String
    ): Boolean {
        return try {
            val user = UserEntity(
                id = UUID.randomUUID().toString(),
                userName = userName.trim().lowercase(),
                email = email.trim().lowercase(),
                numberPhone = numberPhone.trim().lowercase().filter { it.isDigit() },
                password = password.trim().lowercase()
            )
            userLocalDataSource.saveUser(user)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun validateEmailPassword(email: String, password: String): Boolean {
        return withContext(Dispatchers.Default) {
            val checkEmail = email.trim().lowercase()
            val checkPassword = password.trim().lowercase()
            val response = userLocalDataSource.isValidate(checkEmail, checkPassword)
            response
        }
    }

    override suspend fun validateNumberPhone(numberPhone: String): Boolean {
        return withContext(Dispatchers.Default) {
            val checkNumberPhone = numberPhone.trim().lowercase().filter { it.isDigit() }
            val response = userLocalDataSource.isValidatePhone(checkNumberPhone)
            response
        }
    }

    override suspend fun changePassword(numberPhone: String, password: String): Boolean {
        return withContext(Dispatchers.Default) {
            val checkPassword = password.trim().lowercase()
            val response = userLocalDataSource.changePassword(numberPhone, checkPassword)
            response
        }
    }

    override suspend fun getUserName(email: String): String {
        return withContext(Dispatchers.Default) {
            val checkEmail = email.trim().lowercase()
            val response = userLocalDataSource.getUserName(email)
            response
        }
    }
}

