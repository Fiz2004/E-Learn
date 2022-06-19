package com.fiz.e_learn.ui.screens.main.components.top_app_bar

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.ELearnOutlinedTextFieldWithIcon
import com.fiz.e_learn.ui.screens.main.MainEvent
import com.fiz.e_learn.ui.screens.main.MainViewModel
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun MainTopAppBar(
    viewModel: MainViewModel = viewModel(),
    currentScreen: NavDestination?,
    userName: String = "",
    moveBackStack: () -> Unit = {},
    moveCart: () -> Unit = {}
) {
    val state=viewModel.viewState

    TopAppBar(
        modifier = Modifier
            .defaultMinSize(minHeight = 164.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.backgroundHome)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 32.dp,
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

                IconTopBar(R.drawable.ic_basket,moveCart)
            }

            ELearnOutlinedTextFieldWithIcon(
                text = state.search,
                textChange = {viewModel.onEvent(MainEvent.SearchChanged(it))},
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