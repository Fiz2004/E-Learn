package com.fiz.e_learn.ui.screens.create_account

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.theme.borderIconLogIn

@Composable
fun BaseIconForLogInGroup(
    icon: Int,
    iconSizeWidth: Dp,
    iconSizeHeight: Dp,
) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .border(1.dp, MaterialTheme.colors.borderIconLogIn, RoundedCornerShape(28.dp)),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            modifier = Modifier
                .size(iconSizeWidth, iconSizeHeight),
            painter = painterResource(
                id = icon
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}