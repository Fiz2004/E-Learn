package com.fiz.e_learn.ui.screens.home_content

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.BaseOutlinedTextFieldWithState
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun ELearnTopAppBar() {
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
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6
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

}