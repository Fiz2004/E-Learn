package com.fiz.e_learn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fiz.e_learn.ui.screens.home.HomeBody

@Composable
fun HomeContentNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeContentScreen.HomeScreen.route,
        modifier = modifier
    ) {
        composable(HomeContentScreen.HomeScreen.route) {
            HomeBody(navController)
        }
        composable(HomeContentScreen.FavoritiesScreen.route) {
            FavoritiesBody(navController)
        }
        composable(HomeContentScreen.CoursesScreen.route) {
            CoursesBody(navController)
        }
        composable(HomeContentScreen.SettingsScreen.route) {
            SettingsBody(navController)
        }
    }
}