package com.fiz.e_learn.app

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){

    override fun onCreate() {
        super.onCreate()

        // For LocalDate
        AndroidThreeTen.init(this)
    }
}