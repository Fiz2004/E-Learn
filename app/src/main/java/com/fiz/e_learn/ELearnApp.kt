package com.fiz.e_learn

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun ELearnApp(mainViewModel: MainViewModel) {
    ELearnTheme {
        val navController = rememberNavController()
        ELearnNavHost(
            navController = navController
        )
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun DefaultPreview() {
    val mainViewModel = MainViewModel()
    ELearnTheme {
        Surface {
            ELearnApp(mainViewModel)
        }
    }
}