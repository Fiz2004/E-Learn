package com.fiz.e_learn.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.create_account.CreateAccountViewModel
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.border
import com.fiz.e_learn.ui.theme.editText
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun PasswordFingerPrintTextField(
    modifier: Modifier=Modifier,
    createAccountViewModel: CreateAccountViewModel = viewModel(),
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        BaseOutlinedTextField(
            text=createAccountViewModel.password,
            textChange={password->createAccountViewModel.newPassword(password)},
            placeholderText = stringResource(R.string.password),
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(1f),
            icon = R.drawable.ic_password,
            iconSizeWidth = 20.dp,
            iconSizeHeight = 16.dp
        )

        Spacer(
            modifier
                .padding(top = 8.dp)
        )

        IconButton(
            onClick = {},
            modifier = Modifier
                .size(64.dp, 54.dp)
                .background(MaterialTheme.colors.editText)
                .border(1.dp, MaterialTheme.colors.border, RoundedCornerShape(16.dp)),
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
    widthDp = 375,
    heightDp = 300
)
@Composable
fun OnBoardingBodyPreview() {
    ELearnTheme {
        Surface {
            PasswordFingerPrintTextField()
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 375,
    heightDp = 300
)
@Composable
fun OnBoardingBodyDarkPreview() {
    ELearnTheme {
        Surface {
            PasswordFingerPrintTextField()
        }
    }
}