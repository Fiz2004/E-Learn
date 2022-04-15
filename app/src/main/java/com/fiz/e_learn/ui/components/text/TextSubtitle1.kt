package com.fiz.e_learn.ui.screens.log_in

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun TextSubtitle1(text: Int, modifier: Modifier = Modifier, color: Color = Color.Unspecified) {
    TextSubtitle1(stringResource(text),modifier,color)
}

@Composable
fun TextSubtitle1(text: String,modifier: Modifier = Modifier, color: Color = Color.Unspecified) {
    Text(
        text = text,
        modifier=modifier,
        color = color,
        style = MaterialTheme.typography.subtitle1
    )
}