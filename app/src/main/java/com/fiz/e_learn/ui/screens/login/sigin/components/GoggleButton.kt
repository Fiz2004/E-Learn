package com.fiz.e_learn.ui.screens.login.sigin.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.border
import com.fiz.e_learn.ui.theme.subtitle1OnSurface

@Composable
fun GoggleButton(onClick: () -> Unit) {
    OutlinedButton(modifier = Modifier
        .fillMaxWidth()
        .height(54.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.border),
        onClick = { onClick() }) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_char_g
            ),
            contentDescription = null,
            modifier = Modifier.size(20.dp, 24.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = stringResource(R.string.sign_in_with_google),
            style = MaterialTheme.typography.subtitle1OnSurface
        )
    }
}