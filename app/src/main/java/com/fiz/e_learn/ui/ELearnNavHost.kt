package com.fiz.e_learn.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fiz.e_learn.ui.screens.ELearnScreens
import com.fiz.e_learn.ui.screens.login.change_password.ChangePasswordBody
import com.fiz.e_learn.ui.screens.login.create_account.CreateAccountBody
import com.fiz.e_learn.ui.screens.login.create_account.CreateAccountViewModel
import com.fiz.e_learn.ui.screens.login.enter_code.EnterCodeBody
import com.fiz.e_learn.ui.screens.login.enter_code.EnterCodeViewModel
import com.fiz.e_learn.ui.screens.login.forgot_password.ForgotPasswordBody
import com.fiz.e_learn.ui.screens.login.forgot_password.ForgotPasswordViewModel
import com.fiz.e_learn.ui.screens.login.info.InfoBody
import com.fiz.e_learn.ui.screens.login.on_boarding.OnBoardingBody
import com.fiz.e_learn.ui.screens.login.sigin.SignInBody
import com.fiz.e_learn.ui.screens.login.sigin.SignInViewModel
import com.fiz.e_learn.ui.screens.main_content.home_content.HomeContentBody
import com.fiz.e_learn.ui.screens.title.TitleScreenBody
import com.fiz.e_learn.ui.screens.title.TitleViewModel

@Composable
fun ELearnNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = ELearnScreens.TitleScreens.name,
    ) {
        composable(ELearnScreens.TitleScreens.name) {
            val viewModel = hiltViewModel<TitleViewModel>()

            TitleScreenBody(
                viewModel = viewModel,
                moveOnBoardingScreen = { navController.navigate("onBoarding") },
                moveLogInScreen = { navController.navigate(ELearnScreens.LogIn.name) }
            )
        }

        onBoardingGraph(navController)

        composable(ELearnScreens.LogIn.name) {
            val viewModel = hiltViewModel<SignInViewModel>()

            SignInBody(
                viewModel = viewModel,
                moveSignUp = {
                    navController.navigate(ELearnScreens.CreateAccount.name)
                },
                moveForgotPassword = {
                    navController.navigate(ELearnScreens.ForgotPassword.name)
                },
                moveHomeContent = {
                    navController.navigate(ELearnScreens.HomeContent.name)
                })
        }

        composable(ELearnScreens.CreateAccount.name) {
            val viewModel = hiltViewModel<CreateAccountViewModel>()

            CreateAccountBody(
                viewModel = viewModel,
                moveTermsOfServicesInfo = {
                    navController.navigate(ELearnScreens.Info.name)
                },
                movePrivacyPolicyInfo = {
                    navController.navigate(ELearnScreens.Info.name)
                },
                moveHomeContent = {
                    navController.navigate(ELearnScreens.HomeContent.name)
                },
                moveSignInScreen = {
                    navController.navigate(ELearnScreens.LogIn.name)
                }
            )
        }

        composable(ELearnScreens.ForgotPassword.name) {
            val viewModel = hiltViewModel<ForgotPasswordViewModel>()

            ForgotPasswordBody(
                viewModel = viewModel,
                moveEnterCodeScreen = { numberPhone ->
                    navController.navigate(ELearnScreens.EnterCode.name + "/${numberPhone}")
                })
        }

        composable(
            route = ELearnScreens.EnterCode.name + "/{numberPhone}",
            arguments = listOf(navArgument("numberPhone") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<EnterCodeViewModel>()

            val numberPhone = backStackEntry.arguments?.getString("numberPhone") ?: ""

            EnterCodeBody(
                viewModel = viewModel,
                moveChangePasswordScreen = {
                    navController.navigate(ELearnScreens.ChangePassword.name)
                },
                numberPhone = numberPhone
            )
        }

        composable(ELearnScreens.Info.name) {
            InfoBody {
                navController.navigate(ELearnScreens.HomeContent.name)
            }
        }

        composable(ELearnScreens.ChangePassword.name) {
            ChangePasswordBody {
                navController.navigate(ELearnScreens.HomeContent.name)
            }
        }

        composable(ELearnScreens.HomeContent.name) {
            HomeContentBody(navController)
        }
    }
}

fun NavGraphBuilder.onBoardingGraph(navController: NavController) {
    navigation(startDestination = ELearnScreens.OnBoarding.name + "/1", route = "onBoarding") {
        composable(ELearnScreens.OnBoarding.name + "/1") {
            OnBoardingBody("1") {
                navController.navigate(ELearnScreens.OnBoarding.name + "/2")
            }
        }

        composable(
            route = ELearnScreens.OnBoarding.name + "/{page}",
            arguments = listOf(navArgument("page") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<TitleViewModel>()

            val page = backStackEntry.arguments?.getString("page")?.toInt()

            OnBoardingBody(page = backStackEntry.arguments?.getString("page")) {
                when (page) {
                    2 -> navController.navigate(ELearnScreens.OnBoarding.name + "/3")
                    3 -> navController.navigate(ELearnScreens.OnBoarding.name + "/4")
                    4 -> {
                        viewModel.firstTimeLaunchCompleted()
                        navController.navigate(ELearnScreens.LogIn.name)
                    }
                }
            }
        }
    }
}