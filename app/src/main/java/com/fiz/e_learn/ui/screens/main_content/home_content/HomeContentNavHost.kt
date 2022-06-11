package com.fiz.e_learn.ui.screens.main_content.home_content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fiz.e_learn.CoursesBody
import com.fiz.e_learn.FavoritiesBody
import com.fiz.e_learn.SettingsBody
import com.fiz.e_learn.ui.screens.ELearnScreens
import com.fiz.e_learn.ui.screens.main_content.home_content.buy.HomeBuyBody
import com.fiz.e_learn.ui.screens.main_content.home_content.course_author.HomeCourseAuthorBody
import com.fiz.e_learn.ui.screens.main_content.home_content.course_details.HomeCourseDetailsBody
import com.fiz.e_learn.ui.screens.main_content.home_content.course_more_info.HomeCourseMoreInfoBody
import com.fiz.e_learn.ui.screens.main_content.home_content.home_all.HomeBodyAll
import com.fiz.e_learn.ui.screens.main_content.home_content.home_course_base.HomeCourseBaseBody
import com.fiz.e_learn.ui.screens.main_content.home_content.home_main.HomeBodyMain

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
            HomeBodyMain(
                onClickCategoriesSeeAll = {
                    navController.navigate(HomeContentScreen.HomeScreen.route + "/SeeAll")
                },
                onClickCategory = { category ->
                    navController.navigate(HomeContentScreen.HomeScreen.route + "/Category/$category")
                },
                onClickCoursesSeeAll = {
                    navController.navigate(HomeContentScreen.HomeScreen.route + "/SeeAll/TopCourses")
                },
                onClickCourse = { id ->
                    navController.navigate(HomeContentScreen.HomeScreen.route + "/CourseBase/$id")
                })
        }

        val onClickCourse: (Int) -> Unit = { id ->
            navController.navigate(HomeContentScreen.HomeScreen.route + "/CourseBase/$id")
        }

        composable(HomeContentScreen.HomeScreen.route + "/SeeAll") {
            HomeBodyAll(
                filter = "all",
                onClickCourse = onClickCourse
            )
        }

        composable(
            route = HomeContentScreen.HomeScreen.route + "/Category/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = (backStackEntry.arguments?.getString("category")).also {

                HomeBodyAll(
                    filter = it,
                    onClickCourse = onClickCourse
                )
            }
        }

        composable(HomeContentScreen.HomeScreen.route + "/SeeAll/TopCourses") {
            HomeBodyAll(
                filter = "top",
                onClickCourse = onClickCourse
            )
        }

        composable(
            route = HomeContentScreen.HomeScreen.route + "/CourseBase/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseBaseBody(
                id = id,
                onClickReadMore = {
                    navController.navigate(HomeContentScreen.HomeScreen.route + "/CourseDetails/$id")
                })
        }

        composable(
            route = HomeContentScreen.HomeScreen.route + "/CourseDetails/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseDetailsBody(
                id = id,
                onClickSeeAll = {
                    navController.navigate(HomeContentScreen.HomeScreen.route + "/CourseMoreInfo/$id")
                })
        }

        composable(
            route = HomeContentScreen.HomeScreen.route + "/CourseMoreInfo/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseMoreInfoBody(
                id = id,
                onClickAuthor = {
                    navController.navigate(HomeContentScreen.HomeScreen.route + "/Author/$id")
                })
        }

        composable(
            route = HomeContentScreen.HomeScreen.route + "/Author/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseAuthorBody(
                id = id,
                onClickBuyNow = {
                    navController.navigate(HomeContentScreen.HomeScreen.route + "/Buy")
                },
                onClickAddCart = {
                    navController.navigate(HomeContentScreen.HomeScreen.route)
                })
        }

        composable(
            route = HomeContentScreen.HomeScreen.route + "/Buy"
        ) {
            HomeBuyBody(
                onClickPayNow = {
                    navController.navigate(ELearnScreens.Info.name)
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