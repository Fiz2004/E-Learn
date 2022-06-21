package com.fiz.e_learn.ui.screens.main

import androidx.annotation.StringRes
import com.fiz.e_learn.R

sealed class NamesMainScreens(
    val route: String, @StringRes val resourceId: Int
) {
    object HomeScreen : NamesMainScreens("home", R.string.home)
    object FavoritesScreen : NamesMainScreens("favorite", R.string.favorities)
    object CoursesScreen : NamesMainScreens("courses", R.string.courses)
    object SettingsScreen : NamesMainScreens("settings", R.string.settings)
}

val items = listOf(
    NamesMainScreens.HomeScreen,
    NamesMainScreens.FavoritesScreen,
    NamesMainScreens.CoursesScreen,
    NamesMainScreens.SettingsScreen,
)