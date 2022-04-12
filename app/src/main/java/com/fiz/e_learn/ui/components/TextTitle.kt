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

@Composable
fun TextTitle(text:String,modifier: Modifier=Modifier) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.onSurface,
        style= TextStyle(
            fontFamily = FontFamily(Font(R.font.inter_semibold)),
            fontWeight = FontWeight.W600,
            fontSize = 25.5.sp
        )
    )
}