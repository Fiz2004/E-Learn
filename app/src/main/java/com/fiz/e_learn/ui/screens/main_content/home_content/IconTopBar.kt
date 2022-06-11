package com.fiz.e_learn.ui.screens.main_content.home_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun IconTopBar(icon: Int) {
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