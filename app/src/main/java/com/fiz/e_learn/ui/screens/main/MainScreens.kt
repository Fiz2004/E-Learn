package com.fiz.e_learn.ui.screens.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.fiz.e_learn.R

sealed class MainScreens(
    val name: String, @StringRes val textId: Int, @DrawableRes val iconId: Int
) {
    object HomeScreen : MainScreens("home", R.string.home, R.drawable.bottom_nav_ic_home)
    object FavoritesScreen :
        MainScreens("favorite", R.string.favorities, R.drawable.bottom_nav_ic_favorities)

    object CoursesScreen :
        MainScreens("courses", R.string.courses, R.drawable.bottom_nav_ic_learning)

    object SettingsScreen :
        MainScreens("settings", R.string.settings, R.drawable.bottom_nav_ic_account)
}