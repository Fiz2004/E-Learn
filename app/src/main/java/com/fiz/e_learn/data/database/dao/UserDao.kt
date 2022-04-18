package com.fiz.e_learn.data.database.dao

import androidx.room.*
import com.fiz.e_learn.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAll(): Flow<List<UserEntity>>

    @Query("SELECT * FROM UserEntity WHERE id =:id")
    fun getById(id: String): Flow<UserEntity>

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