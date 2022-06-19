package com.fiz.e_learn.ui.screens.login.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.ELearnButton
import com.fiz.e_learn.ui.components.TextH5
import com.fiz.e_learn.ui.components.TextSubtitle2

@Composable
fun InfoBody(
    viewModel: InfoViewModel = viewModel(),
    previewScreen: String,
    moveSignInScreen: () -> Unit = {},
) {
    val title: String = when (previewScreen) {
        "CreateAccount" -> stringResource(R.string.account_created_title)
        "ChangePassword" -> stringResource(R.string.password_changed_title)
        "PrivacyPolicy" -> stringResource(R.string.privacy_police)
        "TermsOfServices" -> stringResource(R.string.terms_of_services)
        else -> throw java.lang.Error("No this Screen")
    }

    val description: String = when (previewScreen) {
        "CreateAccount" -> stringResource(R.string.account_created_description)
        "ChangePassword" -> stringResource(R.string.password_changed_description)
        "PrivacyPolicy" -> stringResource(R.string.privacy_police)
        "TermsOfServices" -> stringResource(R.string.terms_of_services)
        else -> throw java.lang.Error("No this Screen")
    }

    val picture = when (previewScreen) {
        "CreateAccount" -> {
            painterResource(
                id = R.drawable.pic_account_created
            )
        }
        "ChangePassword" -> {
            painterResource(
                id = R.drawable.pic_password_changed
            )
        }
        "PrivacyPolicy" -> {
            painterResource(
                id = R.drawable.pic_account_created
            )
        }
        "TermsOfServices" -> {
            painterResource(
                id = R.drawable.pic_account_created
            )
        }
        else -> {
            throw java.lang.Error("No this Screen")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))

        Image(
            modifier = Modifier
                .size(140.dp, 106.dp),
            painter = picture,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(70.dp))

        TextH5(title)

        Spacer(modifier = Modifier.height(8.dp))

        TextSubtitle2(description)

        Spacer(modifier = Modifier.height(36.dp))

        ELearnButton(
            stringResource(R.string.sign_in),
            onClick = {
                moveSignInScreen()
            }
        )
    }
}