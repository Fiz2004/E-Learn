package com.fiz.e_learn.data.database.dao

import androidx.room.*
import com.fiz.e_learn.data.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE id =:id")
    fun getById(id: String): UserEntity

    @Query("SELECT EXISTS (SELECT* FROM UserEntity WHERE (email =:email AND password =:password))")
    suspend fun isValidateEmailPassword(email: String, password: String): Boolean

    @Query("SELECT EXISTS (SELECT* FROM UserEntity WHERE numberPhone =:numberPhone)")
    suspend fun isValidatePhone(numberPhone: String): Boolean

    @Query("UPDATE UserEntity SET password=:password WHERE numberPhone =:numberPhone")
    suspend fun changePassword(numberPhone: String, password: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(categoryEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(categoryEntities: List<UserEntity>)

    @Update
    suspend fun update(categoryEntity: UserEntity)

    @Update
    suspend fun updateAll(categoryEntities: List<UserEntity>)

    @Delete
    suspend fun delete(categoryEntity: UserEntity)

    @Query("DELETE FROM UserEntity")
    suspend fun deleteAll()
}