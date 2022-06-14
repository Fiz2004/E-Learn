package com.fiz.e_learn.ui.screens.main_content.home_content

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
import com.fiz.e_learn.ui.components.ELearnOutlinedTextFieldWithIcon
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun ELearnTopAppBar() {
    TopAppBar(
        modifier = Modifier
            .defaultMinSize(minHeight = 148.dp),
        backgroundColor = MaterialTheme.colors.backgroundHome
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
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
            ELearnOutlinedTextFieldWithIcon(
                text = "",
                textChange = {},
                placeholderText = "Search here...",
                icon = R.drawable.ic_search,
                iconSizeWidth = 16.dp,
                iconSizeHeight = 16.dp,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }

}