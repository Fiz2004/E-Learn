package com.fiz.e_learn.ui.screens.main_content.home_content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.ELearnOutlinedTextFieldWithIcon
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun ELearnTopAppBar(
    currentScreen: NavDestination?,
    userName: String = "",
    moveBackStack: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier
            .defaultMinSize(minHeight = 148.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 8.dp,
                ),

            ) {
            Row(
                modifier = Modifier
                    .padding(bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                val icon = if (currentScreen?.route == "home")
                    R.drawable.ic_category
                else
                    R.drawable.ic_back

                IconTopBar(
                    icon, onClick = {
                        if (currentScreen?.route != "home") {
                            moveBackStack()
                        }
                    }
                )

                Text(
                    text = "Hi, $userName \uD83D\uDC4B",
                    modifier = Modifier
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface
                )

                IconTopBar(R.drawable.ic_basket)
            }

            ELearnOutlinedTextFieldWithIcon(
                text = "",
                textChange = {},
                placeholderText = stringResource(R.string.search_hint),
                icon = R.drawable.ic_search,
                iconSizeWidth = 16.dp,
                iconSizeHeight = 16.dp,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }

}