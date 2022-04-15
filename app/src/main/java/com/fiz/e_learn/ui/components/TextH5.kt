package com.fiz.e_learn.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.fiz.e_learn.R

@Composable
fun TextH5(text:Int, modifier: Modifier=Modifier) {
    TextH5(stringResource(text),modifier)
}

@Composable
fun TextH5(text:String, modifier: Modifier=Modifier) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.onSurface,
        style= MaterialTheme.typography.h5
    )
}