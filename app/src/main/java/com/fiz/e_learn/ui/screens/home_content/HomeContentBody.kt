package com.fiz.e_learn.ui.screens.home_content

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fiz.e_learn.HomeContentNavHost
import com.fiz.e_learn.R
import com.fiz.e_learn.items
import com.fiz.e_learn.ui.screens.log_in.BaseOutlinedTextField
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun HomeContentBody(mainNavController: NavController? = null) {
    val navController = rememberNavController()
    val allScreens = items
    val backstackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backstackEntry?.destination
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.defaultMinSize(minHeight = 120.dp),
                backgroundColor = MaterialTheme.colors.background
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                ) {
                    Row(modifier = Modifier
                        .padding(bottom = 16.dp)

                    ) {
                        IconTopBar(R.drawable.ic_category)

//                        if (currentScreen != null) {
                            Text(text = "Hi, Alex Joe",
                                modifier = Modifier
                                    .weight(1f)
                                    .align(Alignment.CenterVertically))
//                        }


                        IconTopBar(R.drawable.ic_basket)
                    }
                    BaseOutlinedTextField(
                        "Search here...",
                        Modifier.fillMaxWidth().requiredHeight(48.dp),
                        R.drawable.ic_search,
                        16.dp,
                        16.dp
                    )
                }
            }

        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
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
    ) { innerPadding ->
        HomeContentNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun IconTopBar(icon: Int) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(
                color = MaterialTheme.colors.surface,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                .size(20.dp, 20.dp),
            painter = painterResource(
                id = icon
            ),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface2),
            contentDescription = null,
            contentScale = ContentScale.Crop
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