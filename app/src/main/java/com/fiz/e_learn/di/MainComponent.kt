package com.fiz.e_learn.di

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.fiz.e_learn.R
import com.fiz.e_learn.data.data_source.UserLocalDataSource
import com.fiz.e_learn.data.database.ELearnDatabase
import com.fiz.e_learn.data.database.dao.UserDao
import com.fiz.e_learn.data.repositories.UserRepositoryImpl
import com.fiz.e_learn.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val NAME_DATABASE = "elearn_database"

@Module
@InstallIn(SingletonComponent::class)
class MainComponent {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            context.getString(R.string.preferences),
            AppCompatActivity.MODE_PRIVATE
        )
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): ELearnDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ELearnDatabase::class.java,
            NAME_DATABASE
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: ELearnDatabase): UserDao = database.userDao()

    @Provides
    @Singleton
    fun provideUserRepository(userLocalDataSource: UserLocalDataSource): UserRepositoryImpl =
        UserRepositoryImpl(userLocalDataSource)

    @Provides
    @Singleton
    fun provideUserLocalDataSource(userDao: UserDao): UserLocalDataSource =
        UserLocalDataSource(userDao)

    @Module
    @InstallIn(SingletonComponent::class)
    interface Bindings {
        @dagger.Binds
        fun provideUserRepository(UserRepositoryImpl: UserRepositoryImpl): UserRepository
    }
}