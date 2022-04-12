package com.fiz.e_learn

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.ui.graphics.vector.ImageVector

enum class ELearnScreen(
    val icon: ImageVector
) {
    TitleScreen(
        icon = Icons.Filled.PieChart,
    ),
    OnBoarding(
        icon = Icons.Filled.AttachMoney,
    ),
    LogIn(
        icon = Icons.Filled.MoneyOff,
    ),
    CreateAccount(
        icon = Icons.Filled.MoneyOff,
    ),
    ForgotPassword(
        icon = Icons.Filled.MoneyOff,
    ),
    EnterCode(
        icon = Icons.Filled.MoneyOff,
    ),
    ChangePassword(
        icon = Icons.Filled.MoneyOff,
    ),
    HomeContent(
        icon = Icons.Filled.MoneyOff,
    );


    companion object {
        fun fromRoute(route: String?): ELearnScreen =
            when (route?.substringBefore("/")) {
                TitleScreen.name -> TitleScreen
                OnBoarding.name -> OnBoarding
                LogIn.name -> LogIn
                CreateAccount.name -> CreateAccount
                ForgotPassword.name -> ForgotPassword
                EnterCode.name -> EnterCode
                ChangePassword.name -> ChangePassword
                HomeContent.name -> HomeContent
                null -> HomeContent
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}