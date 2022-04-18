package com.fiz.e_learn.ui.screens.create_account

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.*
import com.fiz.e_learn.ui.screens.create_account.components.SignInText
import com.fiz.e_learn.ui.screens.create_account.components.TextPrivacy
import com.fiz.e_learn.ui.screens.create_account.components.UserNameTextField
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.greenText


@Composable
fun CreateAccountBody(
    viewModel: CreateAccountViewModel,
    onClickTermsOfServices: () -> Unit = {},
    onClickPrivacyPolicy: () -> Unit = {},
    onClickCreateAccount: () -> Unit = {},
    onClickSignIn: () -> Unit = {},
) {
    val context = LocalContext.current
    val viewState = viewModel.UIState

    BaseContainerForLogInGroup {
        BaseIconForLogInGroup(R.drawable.ic_people, 48.dp, 32.dp)

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(R.string.create_account)

        Spacer(modifier = Modifier.padding(4.dp))

        TextSubtitle2(R.string.create_account_description)

        Spacer(modifier = Modifier.padding(20.dp))

        UserNameTextField()

        Spacer(modifier = Modifier.padding(12.dp))

        EmailTextField(
            text = viewModel.emailId,
            textChange = { emailId -> viewModel.newEmailId(emailId) })

        Spacer(modifier = Modifier.padding(12.dp))

        PasswordFingerPrintTextField(
            text = viewModel.password,
            textChange = { password -> viewModel.newPassword(password) })

        Spacer(modifier = Modifier.padding(8.dp))

        TextPrivacy(
            onClickTermsOfServices = onClickTermsOfServices,
            onClickPrivacyPolicy = onClickPrivacyPolicy
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnButton(
            R.string.create_account,
            enabled = viewModel.isCreateAccountButtonEnabled(),
            onClick = {
                viewModel.clickCreateAccount()
            })

        Spacer(modifier = Modifier.padding(8.dp))

        SignInText(onClickSignIn)
    }

    if (viewState == CreateAccountState.Error) {
        Toast.makeText(context, "Error Create Account", Toast.LENGTH_SHORT).show()
        viewModel.onErrorShow()
    }

    if (viewState == CreateAccountState.Save) {
        Progress()
    }
    if (viewState == CreateAccountState.LogIn) {
        onClickCreateAccount()
        viewModel.onClickCreateAccount()
    }

}

@Composable
fun Progress() {
    val progressValue = 1f
    val infiniteTransition = rememberInfiniteTransition()

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue, animationSpec = infiniteRepeatable(animation = tween(900))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .size(50.dp),
            strokeWidth = 8.dp,
            progress = progressAnimationValue,
            color = MaterialTheme.colors.greenText
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 875
)
@Composable
fun CreateAccountBodyPreview() {
    ELearnTheme {
        Surface {
            Progress()
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 375,
    heightDp = 875
)
@Composable
fun CreateAccountBodyDarkPreview() {
    ELearnTheme {
        Surface {
            Progress()
        }
    }
}