package com.fiz.e_learn

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
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