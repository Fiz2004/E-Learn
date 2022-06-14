package com.fiz.e_learn.domain.repositories

interface UserRepository {
    suspend fun saveUser(
        userName: String,
        email: String,
        numberPhone: String,
        password: String
    ): Boolean

    suspend fun validateEmailPassword(email: String, password: String): Boolean

    suspend fun validateNumberPhone(numberPhone: String): Boolean

    suspend fun changePassword(numberPhone: String, password: String): Boolean
    suspend fun getUserName(email: String): String
}