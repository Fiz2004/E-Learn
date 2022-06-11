package com.fiz.e_learn.ui.screens.main_content.home_content

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun HomeContentBody(mainNavController: NavController? = null) {
    val navController = rememberNavController()
    val allScreens = items
    val backstackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backstackEntry?.destination
    Scaffold(
        topBar = { ELearnTopAppBar() },
        bottomBar = { ELearnHomeBottomBar(navController) }
    ) { innerPadding ->
        HomeContentNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 875
)
@Composable
fun HomeContentBodyPreview() {
    ELearnTheme {
        Surface {
            HomeContentBody()
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
fun HomeContentBodyDarkPreview() {
    ELearnTheme {
        Surface {
            HomeContentBody()
        }
    }
}