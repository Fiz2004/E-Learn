package com.fiz.e_learn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
                navController.navigate(ELearnScreen.OnBoarding.name)
            }
        }
        composable(ELearnScreen.OnBoarding.name) {
            OnBoardingBody {
                navController.navigate(ELearnScreen.LogIn.name)
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
            HomeContentBody {
                navController.navigate(ELearnScreen.Favorities.name)
            }
        }
        composable(ELearnScreen.Favorities.name) {
            FavoritiesBody {
                navController.navigate(ELearnScreen.Courses.name)
            }
        }
        composable(ELearnScreen.Courses.name) {
            CoursesBody {
                navController.navigate(ELearnScreen.Settings.name)
            }
        }
        composable(ELearnScreen.Settings.name) {
            SettingsBody {
                navController.navigate(ELearnScreen.TitleScreen.name)
            }
        }
    }
}