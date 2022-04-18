package com.fiz.e_learn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fiz.e_learn.ui.screens.change_password.ChangePasswordBody
import com.fiz.e_learn.ui.screens.create_account.CreateAccountBody
import com.fiz.e_learn.ui.screens.create_account.CreateAccountViewModel
import com.fiz.e_learn.ui.screens.home_content.HomeContentBody
import com.fiz.e_learn.ui.screens.info.InfoBody
import com.fiz.e_learn.ui.screens.log_in.LogInViewModel
import com.fiz.e_learn.ui.screens.on_boarding.OnBoardingBody

@Composable
fun ELearnNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = viewModel()
) {
    val startScreen = if (mainViewModel.firstTimeLaunch)
        ELearnScreen.TitleScreen.name
    else
        ELearnScreen.LogIn.name

    NavHost(
        navController = navController,
        startDestination = startScreen,
        modifier = modifier
    ) {
        composable(ELearnScreen.TitleScreen.name) {
            TitleScreenBody {
                navController.navigate("onBoarding")
            }
        }

        onBoardingGraph(mainViewModel,navController)

        composable(ELearnScreen.LogIn.name) {
            val viewModel = hiltViewModel<LogInViewModel>()

            LogInBody(
                viewModel = viewModel,
                onClickSignUp = {
                    navController.navigate(ELearnScreen.CreateAccount.name)
                },
                onClickForgotPassword = {
                    navController.navigate(ELearnScreen.ForgotPassword.name)
                },
                onClickSignIn = {
                    navController.navigate(ELearnScreen.HomeContent.name)
                })
        }

        composable(ELearnScreen.CreateAccount.name) {
            val viewModel = hiltViewModel<CreateAccountViewModel>()

            CreateAccountBody(
                viewModel = viewModel,
                onClickTermsOfServices = {
                    navController.navigate(ELearnScreen.Info.name)
                },
                onClickPrivacyPolicy = {
                    navController.navigate(ELearnScreen.Info.name)
                },
                onClickCreateAccount = {
                    navController.navigate(ELearnScreen.HomeContent.name)
                },
                onClickSignIn = {
                    navController.navigate(ELearnScreen.LogIn.name)
                }
            )
        }

        composable(ELearnScreen.ForgotPassword.name) {
            ChangePasswordBody {
                navController.navigate(ELearnScreen.HomeContent.name)
            }
        }

        composable(ELearnScreen.Info.name) {
            InfoBody {
                navController.navigate(ELearnScreen.HomeContent.name)
            }
        }

        composable(ELearnScreen.ChangePassword.name) {
            ChangePasswordBody {
                navController.navigate(ELearnScreen.HomeContent.name)
            }
        }

        composable(ELearnScreen.HomeContent.name) {
            HomeContentBody(navController)
        }
    }
}

fun NavGraphBuilder.onBoardingGraph(mainViewModel: MainViewModel,navController: NavController) {
    navigation(startDestination = ELearnScreen.OnBoarding.name + "/1", route = "onBoarding") {
        composable(ELearnScreen.OnBoarding.name + "/1") {
            OnBoardingBody("1") {
                navController.navigate(ELearnScreen.OnBoarding.name + "/2")
            }
        }

        composable(
            route = ELearnScreen.OnBoarding.name + "/{page}",
            arguments = listOf(navArgument("page") { type = NavType.StringType })
        ) { backStackEntry ->
            val page = backStackEntry.arguments?.getString("page")?.toInt()

            OnBoardingBody(backStackEntry.arguments?.getString("page")) {
                when (page) {
                    2 -> navController.navigate(ELearnScreen.OnBoarding.name + "/3")
                    3 -> navController.navigate(ELearnScreen.OnBoarding.name + "/4")
                    4 -> {
                        mainViewModel.firstTimeLaunchCompleted()
                        navController.navigate(ELearnScreen.LogIn.name)
                    }
                }
            }
        }
    }
}