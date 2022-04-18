package com.fiz.e_learn.data.data_source

import com.fiz.e_learn.data.database.dao.UserDao
import com.fiz.e_learn.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import java.lang.Exception
import javax.inject.Inject

class UserLocalDataSource (private val userDao: UserDao) {
    suspend fun saveUser(user:UserEntity): Boolean {
        return try {
            userDao.insert(user)
            true
        }catch(e:Exception) {
            false
        }
    }

    suspend fun loadUsers(): Flow<List<UserEntity>> {
        return try {
            userDao.getAll()
        }catch(e:Exception) {
            listOf(listOf<UserEntity>()).asFlow()
        }
    }
}