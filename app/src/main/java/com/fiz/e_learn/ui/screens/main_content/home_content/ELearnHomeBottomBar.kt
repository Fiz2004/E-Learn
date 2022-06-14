package com.fiz.e_learn.ui.screens.main_content.home_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.greenText
import com.fiz.e_learn.ui.theme.surface2

@Composable
fun ELearnHomeBottomBar(navController: NavHostController) {
    BottomNavigation(
        modifier = Modifier.clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)),
        backgroundColor = MaterialTheme.colors.surface2,
        contentColor = MaterialTheme.colors.primary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Image(
                        painter = painterResource(
                            when {
                                screen.route.contains("home") -> {

                                    if (currentDestination?.hierarchy?.any { it.route?.contains("home") == true } == true)
                                        R.drawable.ic_home_selected
                                    else
                                        R.drawable.ic_home

                                }
                                screen.route.contains("favorite") -> {
                                    if (currentDestination?.hierarchy?.any { it.route?.contains("favorite") == true } == true)
                                        R.drawable.ic_favorities_selected
                                    else
                                        R.drawable.ic_favorities
                                }
                                screen.route.contains("courses") -> {
                                    if (currentDestination?.hierarchy?.any { it.route?.contains("courses") == true } == true)
                                        R.drawable.ic_learning_selected
                                    else
                                        R.drawable.ic_learning
                                }
                                else -> {
                                    if (currentDestination?.hierarchy?.any { it.route?.contains("settings") == true } == true)
                                        R.drawable.ic_account_selected
                                    else
                                        R.drawable.ic_account
                                }
                            }
                        ),
                        contentDescription = null,
                        colorFilter =
                        if (currentDestination?.hierarchy?.any { it.route == screen.route } == true)
                            ColorFilter.tint(color = MaterialTheme.colors.greenText)
                        else
                            null
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}