package com.fiz.e_learn.ui.screens.main.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fiz.e_learn.ui.screens.main.MainScreens
import com.fiz.e_learn.ui.theme.Black_Alpha_03
import com.fiz.e_learn.ui.theme.surface2

@Composable
fun MainBottomBar(navController: NavHostController) {

    val backstackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backstackEntry?.destination

    val items = listOf(
        MainScreens.HomeScreen,
        MainScreens.FavoritesScreen,
        MainScreens.CoursesScreen,
        MainScreens.SettingsScreen,
    )

    val selectedItem = items.indexOfFirst { currentDestination?.route?.contains(it.name) ?: false }

    BottomNavigation(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)),
        backgroundColor = MaterialTheme.colors.surface2,
        contentColor = MaterialTheme.colors.primary
    ) {
        items.forEachIndexed { index, screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(items[index].iconId),
                        contentDescription = null,
                        tint = if (selectedItem == index)
                            MaterialTheme.colors.primary
                        else
                            Black_Alpha_03
                    )
                },
                alwaysShowLabel = false,
                selected = currentDestination?.route?.contains(screen.name) ?: false,
                onClick = {
                    if (selectedItem != index) {
                        navController.navigate(screen.name) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selectedContentColor = MaterialTheme.colors.primary,
            )
        }
    }
}
