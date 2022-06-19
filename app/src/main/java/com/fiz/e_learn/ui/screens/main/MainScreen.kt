package com.fiz.e_learn.ui.screens.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fiz.e_learn.ui.screens.main.components.MainBottomBar
import com.fiz.e_learn.ui.screens.main.components.top_app_bar.MainTopAppBar
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
    userName: String
) {
    val navController = rememberNavController()
    val backstackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backstackEntry?.destination
    Scaffold(
        topBar = {
            MainTopAppBar(viewModel, currentScreen, userName, moveBackStack = {
                navController.popBackStack()
            },
                moveCart = {
                    navController.navigate(MainScreens.HomeScreen.route + "/Cart")
                })
        },
        bottomBar = { MainBottomBar(navController) },
        backgroundColor = MaterialTheme.colors.backgroundHome
    ) { innerPadding ->
        MainNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            viewModel
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 875
)
@Composable
fun MainScreenPreview() {
    ELearnTheme {
        Surface {
            MainScreen(userName = "test")
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 375,
    heightDp = 875
)
@Composable
fun MainScreenDarkPreview() {
    ELearnTheme {
        Surface {
            MainScreen(userName = "test")
        }
    }
}