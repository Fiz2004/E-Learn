package com.fiz.e_learn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fiz.e_learn.ui.screens.home_content.homeAll.HomeBodyAll
import com.fiz.e_learn.ui.screens.home_content.homeMain.HomeBodyMain

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
            HomeBodyMain(navController,onClickSeeAll= {
                navController.navigate(HomeContentScreen.HomeScreen.route + "/SeeAll")
            })
        }
        composable(HomeContentScreen.HomeScreen.route + "/SeeAll") {
            HomeBodyAll(navController,onClickSeeAll= {
            })
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