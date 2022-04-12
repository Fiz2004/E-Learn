package com.fiz.e_learn

import androidx.annotation.StringRes

sealed class HomeContentScreen(
    val route: String, @StringRes val resourceId: Int
) {
    object HomeScreen : HomeContentScreen("home", R.string.home)
    object FavoritiesScreen : HomeContentScreen("favorite", R.string.favorities)
    object CoursesScreen : HomeContentScreen("courses", R.string.courses)
    object SettingsScreen : HomeContentScreen("settings", R.string.settings)
}

val items = listOf(
    HomeContentScreen.HomeScreen,
    HomeContentScreen.FavoritiesScreen,
    HomeContentScreen.CoursesScreen,
    HomeContentScreen.SettingsScreen,
)