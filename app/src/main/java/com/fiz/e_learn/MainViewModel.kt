package com.fiz.e_learn

import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) :
    ViewModel() {
    var firstTimeLaunch by mutableStateOf<Boolean>(true)
        private set

    init {
        firstTimeLaunch = sharedPreferences.getBoolean("firstTimeLaunch", true)
    }

    fun firstTimeLaunchCompleted() {
        firstTimeLaunch = false
        sharedPreferences.edit()
            .putBoolean("firstTimeLaunch", false)
            .apply()
    }
}