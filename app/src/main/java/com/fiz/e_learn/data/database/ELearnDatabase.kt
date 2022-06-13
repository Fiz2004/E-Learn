package com.fiz.e_learn.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fiz.e_learn.data.database.dao.UserDao
import com.fiz.e_learn.data.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ELearnDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}