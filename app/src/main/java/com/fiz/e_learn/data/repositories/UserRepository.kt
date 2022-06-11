package com.fiz.e_learn.data.repositories

interface UserRepository {
    suspend fun saveUser(
        userName: String,
        email: String,
        numberPhone: String,
        password: String
    ): Boolean

    suspend fun validateEmailPassword(email: String, password: String): Boolean

    suspend fun validateNumberPhone(numberPhone: String): Boolean
}