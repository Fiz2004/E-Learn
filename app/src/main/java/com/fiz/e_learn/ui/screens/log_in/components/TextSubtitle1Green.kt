package com.fiz.e_learn.ui.screens.log_in

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.fiz.e_learn.ui.theme.subtitle1Green

@Composable
fun TextSubtitle1Green(text:Int,
                       modifier: Modifier = Modifier,
                       textAlign: TextAlign? = null
                               ) {
    Text(
        modifier = modifier,
        textAlign = textAlign,
        text = stringResource(text),
        style = MaterialTheme.typography.subtitle1Green
    )
}