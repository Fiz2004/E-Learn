package com.fiz.e_learn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fiz.e_learn.ui.home_content.HomeContentBody
import com.fiz.e_learn.ui.on_boarding.OnBoardingBody

@Composable
fun ELearnNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ELearnScreen.TitleScreen.name,
        modifier = modifier
    ) {
        composable(ELearnScreen.TitleScreen.name) {
            TitleScreenBody {
                navController.navigate(ELearnScreen.OnBoarding.name + "/1")
            }
        }
        composable(route = ELearnScreen.OnBoarding.name + "/{page}",
            arguments = listOf(navArgument("page") {
                type = NavType.StringType
            })
        ) {backStackEntry ->
            val page=backStackEntry.arguments?.getString("page")?.toInt()

            OnBoardingBody (backStackEntry.arguments?.getString("page")){
                when (page) {
                   1-> navController.navigate(ELearnScreen.OnBoarding.name + "/2")
                   2-> navController.navigate(ELearnScreen.OnBoarding.name + "/3")
                   3-> navController.navigate(ELearnScreen.OnBoarding.name + "/4")
                   4-> navController.navigate(ELearnScreen.LogIn.name)
                }
            }
        }
        composable(ELearnScreen.LogIn.name) {
            LogInBody {
                navController.navigate(ELearnScreen.CreateAccount.name)
            }
        }
        composable(ELearnScreen.CreateAccount.name) {
            CreateAccountBody {
                navController.navigate(ELearnScreen.ForgotPassword.name)
            }
        }
        composable(ELearnScreen.ForgotPassword.name) {
            ForgotPasswordBody {
                navController.navigate(ELearnScreen.EnterCode.name)
            }
        }
        composable(ELearnScreen.EnterCode.name) {
            EnterCodeBody {
                navController.navigate(ELearnScreen.ChangePassword.name)
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