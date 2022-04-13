package com.fiz.e_learn.ui.screens.create_account

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.screens.log_in.BaseOutlinedTextField
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.border
import com.fiz.e_learn.ui.theme.editText
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun PasswordFingerPrintTextField() {
    Row(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 12.dp)
            .defaultMinSize(minHeight = 48.dp)
            .fillMaxWidth()
    ) {
        BaseOutlinedTextField(
            stringResource(R.string.password), Modifier
                .padding(end = 16.dp)
                .weight(1f), R.drawable.ic_password, 20.dp, 16.dp
        )

        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .width(64.dp)
                .defaultMinSize(minHeight = 48.dp),
            border = BorderStroke(1.dp, MaterialTheme.colors.border),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.editText),
            shape = RoundedCornerShape(16.dp)
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_fingerprint
                ),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface2),
                contentDescription = null,
                modifier = Modifier.size(24.dp, 28.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}