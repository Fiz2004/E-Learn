package com.fiz.e_learn.data.repositories

import com.fiz.e_learn.data.data_source.UserLocalDataSource
import com.fiz.e_learn.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import java.util.*

class UserRepository(private val userLocalDataSource: UserLocalDataSource) {
    suspend fun saveUser(userName: String, emailId: String, password: String): Boolean {
        return try {
            val user = UserEntity(
                id = UUID.randomUUID().toString(),
                userName = userName,
                email = emailId,
                password = password
            )
            userLocalDataSource.saveUser(user)
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun loadUser(): Flow<List<User>> {
        val users = userLocalDataSource.loadUsers().map { it.map { it.toUser() } }
        return try {
            users
        } catch (e: Exception) {
            listOf(listOf<User>()).asFlow()
        }
    }
}

data class User(
    val userName: String,
    val email: String,
    val password: String,
) {
}