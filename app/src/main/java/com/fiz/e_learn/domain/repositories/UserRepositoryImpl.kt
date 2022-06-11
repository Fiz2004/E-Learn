package com.fiz.e_learn.domain.repositories

import com.fiz.e_learn.data.data_source.UserLocalDataSource
import com.fiz.e_learn.data.entity.UserEntity
import com.fiz.e_learn.data.repositories.UserRepository
import com.fiz.e_learn.domain.User
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

    private fun loadUsers(): List<User> {
        val users = userLocalDataSource.loadUsers().map { it.toUser() }
        return try {
            users
        } catch (e: Exception) {
            listOf()
        }
    }

    override suspend fun validateEmailPassword(email: String, password: String): Boolean {
        return withContext(Dispatchers.Default) {
            val checkEmail = email.trim().lowercase()
            val checkPassword = password.trim().lowercase()
            val allUsers = loadUsers()
            val result =
                allUsers.firstOrNull { it.email == checkEmail && it.password == checkPassword } != null
            result
        }
    }

    override suspend fun validateNumberPhone(numberPhone: String): Boolean {
        return withContext(Dispatchers.Default) {
            val checkNumberPhone = numberPhone.trim().lowercase().filter { it.isDigit() }
            val allUsers = loadUsers()
            val result =
                allUsers.firstOrNull { it.numberPhone == checkNumberPhone } != null
            result
        }
    }
}

