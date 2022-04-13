package com.fiz.e_learn.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun TextDescription(text:String,modifier: Modifier=Modifier) {
    Text(
        modifier = modifier,
        textAlign = TextAlign.Center,
        text = text,
        color = MaterialTheme.colors.onSurface2,
        style = MaterialTheme.typography.subtitle2
    )
}