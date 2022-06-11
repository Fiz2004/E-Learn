package com.fiz.e_learn.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun ELearnApp() {
    ELearnTheme {
        val navController = rememberNavController()

        ELearnNavHost(
            navController = navController
        )
    }
}