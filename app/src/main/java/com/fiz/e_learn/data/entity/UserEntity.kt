package com.fiz.e_learn.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fiz.e_learn.data.repositories.User

@Entity
data class UserEntity(
    @PrimaryKey
    val id: String,
    val userName: String,
    val email: String,
    val password: String,
) {
    fun toUser(): User {
        return User(userName = userName, email = email, password = password)
    }
}