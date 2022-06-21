package com.fiz.e_learn.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fiz.e_learn.ui.screens.info.InfoBody
import com.fiz.e_learn.ui.screens.info.InfoViewModel
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
import com.fiz.e_learn.ui.screens.main.MainScreen
import com.fiz.e_learn.ui.screens.main.MainViewModel
import com.fiz.e_learn.ui.screens.onboarding.OnBoardingBody
import com.fiz.e_learn.ui.screens.title.TitleScreenBody
import com.fiz.e_learn.ui.screens.title.TitleViewModel

@Composable
fun ELearnNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NamesELearnScreens.Title.name,
    ) {
        composable(NamesELearnScreens.Title.name) {
            val viewModel = hiltViewModel<TitleViewModel>()

            TitleScreenBody(
                viewModel = viewModel,
                moveOnBoardingScreen = { navController.navigate("onBoarding") },
                moveLogInScreen = { navController.navigate(NamesELearnScreens.SignIn.name) }
            )
        }

        onBoardingGraph(navController)

        composable(NamesELearnScreens.SignIn.name) {
            val viewModel = hiltViewModel<SignInViewModel>()

            SignInBody(
                viewModel = viewModel,
                moveSignUp = {
                    navController.navigate(NamesELearnScreens.CreateAccount.name)
                },
                moveForgotPassword = {
                    navController.navigate(NamesELearnScreens.ForgotPassword.name)
                },
                moveHomeContent = { userEmail ->
                    navController.navigate(NamesELearnScreens.HomeContent.name + "/${userEmail}")
                })
        }

        composable(NamesELearnScreens.CreateAccount.name) {
            val viewModel = hiltViewModel<CreateAccountViewModel>()

            CreateAccountBody(
                viewModel = viewModel,
                moveTermsOfServicesInfo = {
                    navController.navigate(NamesELearnScreens.Info.name + "/TermsOfServices")
                },
                movePrivacyPolicyInfo = {
                    navController.navigate(NamesELearnScreens.Info.name + "/PrivacyPolicy")
                },
                moveInfoScreen = {
                    navController.navigate(NamesELearnScreens.Info.name + "/CreateAccount")
                },
                moveSignInScreen = {
                    navController.navigate(NamesELearnScreens.SignIn.name)
                }
            )
        }

        composable(NamesELearnScreens.ForgotPassword.name) {
            val viewModel = hiltViewModel<ForgotPasswordViewModel>()

            ForgotPasswordBody(
                viewModel = viewModel,
                moveEnterCodeScreen = { numberPhone ->
                    navController.navigate(NamesELearnScreens.EnterCode.name + "/${numberPhone}")
                })
        }

        composable(
            route = NamesELearnScreens.EnterCode.name + "/{numberPhone}",
            arguments = listOf(navArgument("numberPhone") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<EnterCodeViewModel>()

            val numberPhone = backStackEntry.arguments?.getString("numberPhone") ?: ""

            EnterCodeBody(
                viewModel = viewModel,
                moveChangePasswordScreen = {
                    navController.navigate(NamesELearnScreens.ChangePassword.name + "/${numberPhone}")
                },
                numberPhone = numberPhone
            )
        }

        composable(
            route = NamesELearnScreens.ChangePassword.name + "/{numberPhone}",
            arguments = listOf(navArgument("numberPhone") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<ChangePasswordViewModel>()

            val numberPhone = backStackEntry.arguments?.getString("numberPhone") ?: ""

            ChangePasswordBody(
                viewModel = viewModel,
                moveInfoScreen = { navController.navigate(NamesELearnScreens.Info.name + "/ChangePassword") },
                numberPhone = numberPhone
            )
        }

        composable(
            route = NamesELearnScreens.Info.name + "/{previewScreen}",
            arguments = listOf(navArgument("previewScreen") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<InfoViewModel>()

            val previewScreen = backStackEntry.arguments?.getString("previewScreen") ?: ""

            InfoBody(
                viewModel = viewModel,
                previewScreen = previewScreen,
                moveSignInScreen = { navController.navigate(NamesELearnScreens.SignIn.name) }
            )
        }

        composable(
            route = NamesELearnScreens.HomeContent.name + "/{userEmail}",
            arguments = listOf(navArgument("userEmail") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<MainViewModel>()

            val userEmail = backStackEntry.arguments?.getString("userEmail") ?: ""
            viewModel.initUser(userEmail)

            MainScreen(viewModel)
        }
    }
}

fun NavGraphBuilder.onBoardingGraph(navController: NavController) {
    navigation(startDestination = NamesELearnScreens.OnBoarding.name + "/1", route = "onBoarding") {
        composable(NamesELearnScreens.OnBoarding.name + "/1") {
            OnBoardingBody("1") {
                navController.navigate(NamesELearnScreens.OnBoarding.name + "/2")
            }
        }

        composable(
            route = NamesELearnScreens.OnBoarding.name + "/{page}",
            arguments = listOf(navArgument("page") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<TitleViewModel>()

            val page = backStackEntry.arguments?.getString("page")?.toInt()

            OnBoardingBody(page = backStackEntry.arguments?.getString("page")) {
                when (page) {
                    2 -> navController.navigate(NamesELearnScreens.OnBoarding.name + "/3")
                    3 -> navController.navigate(NamesELearnScreens.OnBoarding.name + "/4")
                    4 -> {
                        viewModel.firstTimeLaunchCompleted()
                        navController.navigate(NamesELearnScreens.SignIn.name)
                    }
                }
            }
        }
    }
}