package com.fiz.e_learn.data.data_source

import com.fiz.e_learn.data.database.dao.UserDao
import com.fiz.e_learn.data.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserLocalDataSource(private val userDao: UserDao) {
    suspend fun saveUser(user: UserEntity): Boolean {
        return try {
            userDao.insert(user)
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun isValidate(checkEmail: String, checkPassword: String): Boolean {
        return withContext(Dispatchers.Default) {
            userDao.isValidateEmailPassword(checkEmail, checkPassword)
        }
    }

    suspend fun isValidatePhone(checkNumberPhone: String): Boolean {
        return withContext(Dispatchers.Default) {
            userDao.isValidatePhone(checkNumberPhone)
        }
    }

    suspend fun changePassword(numberPhone: String, checkPassword: String): Boolean {
        return withContext(Dispatchers.Default) {
            try {
                userDao.changePassword(numberPhone, checkPassword)
                true
            } catch (e: Exception) {
                false
            }
        }
    }
}