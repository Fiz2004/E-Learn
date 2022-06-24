package com.fiz.e_learn.ui.screens.main

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.NamesELearnScreens
import com.fiz.e_learn.ui.screens.info.InfoBody
import com.fiz.e_learn.ui.screens.info.InfoViewModel
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
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {
    val onClickCourse: (Int) -> Unit = { id ->
        navController.navigate(MainScreens.HomeScreen.name + "/CourseBase/$id")
    }

    NavHost(
        navController = navController,
        startDestination = MainScreens.HomeScreen.name,
        modifier = modifier
    ) {
        composable(MainScreens.HomeScreen.name) {

            HomeBodyMain(
                viewModel,
                moveSeeAllCategories = {
                    navController.navigate(MainScreens.HomeScreen.name + "/SeeAll")
                },
                moveCategory = { category ->
                    navController.navigate(MainScreens.HomeScreen.name + "/Category/$category")
                },
                moveSeeAllTopCourses = {
                    navController.navigate(MainScreens.HomeScreen.name + "/SeeAll/TopCourses")
                },
                moveTopCourse = { id ->
                    navController.navigate(MainScreens.HomeScreen.name + "/CourseBase/$id")
                })
        }

        composable(MainScreens.HomeScreen.name + "/SeeAll") {
            HomeBodyAll(
                viewModel,
                filter = "all",
                moveCourse = onClickCourse
            )
        }

        composable(
            route = MainScreens.HomeScreen.name + "/Category/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = (backStackEntry.arguments?.getString("category"))

            category.also {
                HomeBodyAll(
                    viewModel,
                    filter = it,
                    moveCourse = onClickCourse
                )
            }
        }

        composable(MainScreens.HomeScreen.name + "/SeeAll/TopCourses") {
            HomeBodyAll(
                viewModel,
                filter = "top",
                moveCourse = onClickCourse
            )
        }

        composable(
            route = MainScreens.HomeScreen.name + "/CourseBase/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseBaseBody(
                id = id,
                moveCourseDetails = {
                    navController.navigate(MainScreens.HomeScreen.name + "/CourseDetails/$id")
                })
        }

        composable(
            route = MainScreens.HomeScreen.name + "/CourseDetails/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseDetailsBody(
                id = id,
                moveCourseMoreInfo = {
                    navController.navigate(MainScreens.HomeScreen.name + "/CourseMoreInfo/$id")
                })
        }

        composable(
            route = MainScreens.HomeScreen.name + "/CourseMoreInfo/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseMoreInfoBody(
                id = id,
                moveCourseAuthor = {
                    navController.navigate(MainScreens.HomeScreen.name + "/Author/$id")
                })
        }

        composable(
            route = MainScreens.HomeScreen.name + "/Author/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")

            HomeCourseAuthorBody(
                id = id,
                moveBuyScreen = {
                    navController.navigate(MainScreens.HomeScreen.name + "/Buy")
                },
                moveCartScreen = {
                    navController.navigate(MainScreens.HomeScreen.name + "/Cart")
                })
        }

        composable(
            route = MainScreens.HomeScreen.name + "/Buy"
        ) {
            HomeBuyBody(
                moveInfoScreen = {
                    navController.navigate(NamesELearnScreens.Info.name + "/Buy")
                })
        }

        composable(
            route = MainScreens.HomeScreen.name + "/Cart"
        ) {
            HomeCartBody(
                moveBuyScreen = {
                    navController.navigate(MainScreens.HomeScreen.name + "/Buy")
                })
        }

        composable(
            route = NamesELearnScreens.Info.name + "/{previewScreen}",
            arguments = listOf(navArgument("previewScreen") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<InfoViewModel>()

            val previewScreen = backStackEntry.arguments?.getString("previewScreen") ?: ""

            InfoBody(
                viewModel = viewModel,
                background= MaterialTheme.colors.backgroundHome,
                textButton= stringResource(R.string.info_view_course),
                previewScreen = previewScreen,
                moveSignInScreen = { navController.navigate(MainScreens.HomeScreen.name) }
            )
        }

        composable(MainScreens.FavoritesScreen.name) {
            FavoritesBody()
        }
        composable(MainScreens.CoursesScreen.name) {
            CoursesBody()
        }
        composable(MainScreens.SettingsScreen.name) {
            SettingsBody(viewModel)
        }
    }
}