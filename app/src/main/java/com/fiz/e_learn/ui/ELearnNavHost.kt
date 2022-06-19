package com.fiz.e_learn.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fiz.e_learn.ui.screens.login.change_password.ChangePasswordBody
import com.fiz.e_learn.ui.screens.login.change_password.ChangePasswordViewModel
import com.fiz.e_learn.ui.screens.login.create_account.CreateAccountBody
import com.fiz.e_learn.ui.screens.login.create_account.CreateAccountViewModel
import com.fiz.e_learn.ui.screens.login.enter_code.EnterCodeBody
import com.fiz.e_learn.ui.screens.login.enter_code.EnterCodeViewModel
import com.fiz.e_learn.ui.screens.login.forgot_password.ForgotPasswordBody
import com.fiz.e_learn.ui.screens.login.forgot_password.ForgotPasswordViewModel
import com.fiz.e_learn.ui.screens.login.sigin.SignInBody
import com.fiz.e_learn.ui.screens.login.sigin.SignInViewModel
import com.fiz.e_learn.ui.screens.login.info.InfoBody
import com.fiz.e_learn.ui.screens.login.info.InfoViewModel
import com.fiz.e_learn.ui.screens.main.MainScreen
import com.fiz.e_learn.ui.screens.onboarding.OnBoardingBody
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
                moveLogInScreen = { navController.navigate(ELearnScreens.SignIn.name) }
            )
        }

        onBoardingGraph(navController)

        composable(ELearnScreens.SignIn.name) {
            val viewModel = hiltViewModel<SignInViewModel>()

            SignInBody(
                viewModel = viewModel,
                moveSignUp = {
                    navController.navigate(ELearnScreens.CreateAccount.name)
                },
                moveForgotPassword = {
                    navController.navigate(ELearnScreens.ForgotPassword.name)
                },
                moveHomeContent = {userName->
                    navController.navigate(ELearnScreens.HomeContent.name + "/${userName}")
                })
        }

        composable(ELearnScreens.CreateAccount.name) {
            val viewModel = hiltViewModel<CreateAccountViewModel>()

            CreateAccountBody(
                viewModel = viewModel,
                moveTermsOfServicesInfo = {
                    navController.navigate(ELearnScreens.Info.name + "/TermsOfServices")
                },
                movePrivacyPolicyInfo = {
                    navController.navigate(ELearnScreens.Info.name + "/PrivacyPolicy")
                },
                moveInfoScreen = {
                    navController.navigate(ELearnScreens.Info.name + "/CreateAccount")
                },
                moveSignInScreen = {
                    navController.navigate(ELearnScreens.SignIn.name)
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
                    navController.navigate(ELearnScreens.ChangePassword.name + "/${numberPhone}")
                },
                numberPhone = numberPhone
            )
        }

        composable(
            route = ELearnScreens.ChangePassword.name + "/{numberPhone}",
            arguments = listOf(navArgument("numberPhone") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<ChangePasswordViewModel>()

            val numberPhone = backStackEntry.arguments?.getString("numberPhone") ?: ""

            ChangePasswordBody(
                viewModel = viewModel,
                moveInfoScreen = { navController.navigate(ELearnScreens.Info.name + "/ChangePassword") },
                numberPhone = numberPhone
            )
        }

        composable(
            route = ELearnScreens.Info.name + "/{previewScreen}",
            arguments = listOf(navArgument("previewScreen") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<InfoViewModel>()

            val previewScreen = backStackEntry.arguments?.getString("previewScreen") ?: ""

            InfoBody(
                viewModel = viewModel,
                previewScreen = previewScreen,
                moveSignInScreen = { navController.navigate(ELearnScreens.SignIn.name) }
            )
        }

        composable(
            route = ELearnScreens.HomeContent.name + "/{userName}",
            arguments = listOf(navArgument("userName") { type = NavType.StringType })
        ) { backStackEntry ->

            val userName = backStackEntry.arguments?.getString("userName") ?: ""

            MainScreen(userName)
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
                        navController.navigate(ELearnScreens.SignIn.name)
                    }
                }
            }
        }
    }
}