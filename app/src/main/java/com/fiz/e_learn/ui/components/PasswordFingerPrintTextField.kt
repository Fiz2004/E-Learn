package com.fiz.e_learn.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.login.sigin.SignInBody
import com.fiz.e_learn.ui.theme.*

@Composable
fun PasswordFingerPrintTextField(
    text: String,
    modifier: Modifier = Modifier,
    textChange: (String) -> Unit={},
    fingerPrintOnClick: () -> Unit={}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        ELearnOutlinedTextFieldWithIcon(
            text = text,
            textChange = textChange,
            placeholderText = stringResource(R.string.password),
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(1f),
            icon = R.drawable.ic_password,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            iconSizeWidth = 20.dp,
            iconSizeHeight = 16.dp,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(
            modifier
                .padding(top = 8.dp)
        )

        Box(
            modifier = Modifier
                .size(64.dp, 56.dp)
                .background(MaterialTheme.colors.editText)
                .border(1.dp, MaterialTheme.colors.border, RoundedCornerShape(16.dp))
                .clickable { fingerPrintOnClick() },
            contentAlignment= Alignment.Center
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


@Preview(
    showBackground = true,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_DP
)
@Composable
private fun Preview() {
    ELearnTheme {
        Surface {
            PasswordFingerPrintTextField(text="password")
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_DP
)
@Composable
private fun DarkPreview() {
    ELearnTheme {
        Surface {
            PasswordFingerPrintTextField(text="password")
        }
    }
}