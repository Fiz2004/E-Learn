package com.fiz.e_learn.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun TextSubtitle2(text:String, modifier: Modifier=Modifier) {
    Text(
        modifier = modifier,
        textAlign = TextAlign.Center,
        text = text,
        color = MaterialTheme.colors.onSurface2,
        style = MaterialTheme.typography.subtitle2
    )
}