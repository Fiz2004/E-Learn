package com.fiz.e_learn.ui.screens.home_content.home_main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun IconSeeAll(modifier: Modifier = Modifier, color: Color = MaterialTheme.colors.greenText) {
    Image(
        modifier = modifier.padding(start = 6.dp),
        colorFilter = ColorFilter.tint(color = color),
        painter = painterResource(
            id = R.drawable.ic_see_all
        ),
        contentDescription = null,
    )
}