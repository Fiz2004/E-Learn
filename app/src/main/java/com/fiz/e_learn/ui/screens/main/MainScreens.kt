package com.fiz.e_learn.ui.screens.main

import androidx.annotation.StringRes
import com.fiz.e_learn.R

sealed class MainScreens(
    val route: String, @StringRes val resourceId: Int
) {
    object HomeScreen : MainScreens("home", R.string.home)
    object FavoritesScreen : MainScreens("favorite", R.string.favorities)
    object CoursesScreen : MainScreens("courses", R.string.courses)
    object SettingsScreen : MainScreens("settings", R.string.settings)
}

val items = listOf(
    MainScreens.HomeScreen,
    MainScreens.FavoritesScreen,
    MainScreens.CoursesScreen,
    MainScreens.SettingsScreen,
)