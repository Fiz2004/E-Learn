package com.fiz.e_learn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fiz.e_learn.ui.screens.home_content.home_all.HomeBodyAll
import com.fiz.e_learn.ui.screens.home_content.home_course.HomeBodyCourse
import com.fiz.e_learn.ui.screens.home_content.home_main.HomeBodyMain

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
            HomeBodyAll(navController,onClickCourse=  {id->
                HomeContentScreen.HomeScreen.route + "/Course/$id"
            })
        }
        composable(
            route = HomeContentScreen.HomeScreen.route + "/Course/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeBodyCourse(backStackEntry.arguments?.getInt("id")) {
                when (id) {
                    2 -> navController.navigate(ELearnScreen.OnBoarding.name + "/3")
                    3 -> navController.navigate(ELearnScreen.OnBoarding.name + "/4")
                    4 -> {
                        navController.navigate(ELearnScreen.LogIn.name)
                    }
                }
            }
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