package com.fiz.e_learn.ui.screens.home_content

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.BaseOutlinedTextFieldWithState
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome
import com.fiz.e_learn.ui.theme.greenText
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
                modifier = Modifier.defaultMinSize(minHeight = 138.dp),
                backgroundColor = MaterialTheme.colors.backgroundHome
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 4.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        IconTopBar(R.drawable.ic_category)
//                        if (currentScreen != null) {
                        Text(
                            text = "Hi, Alex Joe",
                            modifier = Modifier
                                .weight(1f),
                            textAlign= TextAlign.Center,
                            style=MaterialTheme.typography.h6
                        )
//                        }

                        IconTopBar(R.drawable.ic_basket)
                    }
                    BaseOutlinedTextFieldWithState(
                        "Search here...",
                        R.drawable.ic_search,
                        16.dp,
                        16.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }

        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)),
                backgroundColor = MaterialTheme.colors.background,
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
                                            if (currentDestination?.hierarchy?.any { it.route?.contains("settings") == true  } == true)
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
            .padding(top = 8.dp, bottom = 8.dp)
            .size(48.dp)
            .background(
                color = MaterialTheme.colors.background,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            modifier = Modifier
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