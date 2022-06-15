package com.fiz.e_learn.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fiz.e_learn.ui.ELearnScreens
import com.fiz.e_learn.ui.screens.main.courses.CoursesBody
import com.fiz.e_learn.ui.screens.main.favorities.FavoritesBody
import com.fiz.e_learn.ui.screens.main.home.buy.HomeBuyBody
import com.fiz.e_learn.ui.screens.main.home.cart.HomeCartBody
import com.fiz.e_learn.ui.screens.main.home.course_author.HomeCourseAuthorBody
import com.fiz.e_learn.ui.screens.main.home.course_details.HomeCourseDetailsBody
import com.fiz.e_learn.ui.screens.main.home.course_more_info.HomeCourseMoreInfoBody
import com.fiz.e_learn.ui.screens.main.home.home_all.HomeBodyAll
import com.fiz.e_learn.ui.screens.main.home.home_course_base.HomeCourseBaseBody
import com.fiz.e_learn.ui.screens.main.home.home_main.HomeBodyMain
import com.fiz.e_learn.ui.screens.main.settings.SettingsBody

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainScreens.HomeScreen.route,
        modifier = modifier
    ) {
        composable(MainScreens.HomeScreen.route) {
            HomeBodyMain(
                onClickCategoriesSeeAll = {
                    navController.navigate(MainScreens.HomeScreen.route + "/SeeAll")
                },
                onClickCategory = { category ->
                    navController.navigate(MainScreens.HomeScreen.route + "/Category/$category")
                },
                onClickCoursesSeeAll = {
                    navController.navigate(MainScreens.HomeScreen.route + "/SeeAll/TopCourses")
                },
                onClickCourse = { id ->
                    navController.navigate(MainScreens.HomeScreen.route + "/CourseBase/$id")
                })
        }

        val onClickCourse: (Int) -> Unit = { id ->
            navController.navigate(MainScreens.HomeScreen.route + "/CourseBase/$id")
        }

        composable(MainScreens.HomeScreen.route + "/SeeAll") {
            HomeBodyAll(
                filter = "all",
                onClickCourse = onClickCourse
            )
        }

        composable(
            route = MainScreens.HomeScreen.route + "/Category/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = (backStackEntry.arguments?.getString("category")).also {

                HomeBodyAll(
                    filter = it,
                    onClickCourse = onClickCourse
                )
            }
        }

        composable(MainScreens.HomeScreen.route + "/SeeAll/TopCourses") {
            HomeBodyAll(
                filter = "top",
                onClickCourse = onClickCourse
            )
        }

        composable(
            route = MainScreens.HomeScreen.route + "/CourseBase/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseBaseBody(
                id = id,
                onClickReadMore = {
                    navController.navigate(MainScreens.HomeScreen.route + "/CourseDetails/$id")
                })
        }

        composable(
            route = MainScreens.HomeScreen.route + "/CourseDetails/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseDetailsBody(
                id = id,
                onClickSeeAll = {
                    navController.navigate(MainScreens.HomeScreen.route + "/CourseMoreInfo/$id")
                })
        }

        composable(
            route = MainScreens.HomeScreen.route + "/CourseMoreInfo/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseMoreInfoBody(
                id = id,
                onClickAuthor = {
                    navController.navigate(MainScreens.HomeScreen.route + "/Author/$id")
                })
        }

        composable(
            route = MainScreens.HomeScreen.route + "/Author/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseAuthorBody(
                id = id,
                onClickBuyNow = {
                    navController.navigate(MainScreens.HomeScreen.route + "/Buy")
                },
                onClickAddCart = {
                    navController.navigate(MainScreens.HomeScreen.route + "/Cart")
                })
        }

        composable(
            route = MainScreens.HomeScreen.route + "/Buy"
        ) {
            HomeBuyBody(
                moveInfoScreen = {
                    navController.navigate(ELearnScreens.Info.name)
                })
        }

        composable(
            route = MainScreens.HomeScreen.route + "/Cart"
        ) {
            HomeCartBody(
                onClickPayNow = {
                    navController.navigate(ELearnScreens.Info.name)
                })
        }

        composable(MainScreens.FavoritesScreen.route) {
            FavoritesBody()
        }
        composable(MainScreens.CoursesScreen.route) {
            CoursesBody()
        }
        composable(MainScreens.SettingsScreen.route) {
            SettingsBody()
        }
    }
}