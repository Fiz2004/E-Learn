package com.fiz.e_learn.ui.screens.main_content.home_content

import androidx.annotation.StringRes
import com.fiz.e_learn.R

sealed class HomeContentScreen(
    val route: String, @StringRes val resourceId: Int
) {
    object HomeScreen : HomeContentScreen("home", R.string.home)
    object FavoritesScreen : HomeContentScreen("favorite", R.string.favorities)
    object CoursesScreen : HomeContentScreen("courses", R.string.courses)
    object SettingsScreen : HomeContentScreen("settings", R.string.settings)
}

val items = listOf(
    HomeContentScreen.HomeScreen,
    HomeContentScreen.FavoritesScreen,
    HomeContentScreen.CoursesScreen,
    HomeContentScreen.SettingsScreen,
)