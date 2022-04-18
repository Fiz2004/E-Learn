package com.fiz.e_learn

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.components.*
import com.fiz.e_learn.ui.screens.create_account.BaseIconForLogInGroup
import com.fiz.e_learn.ui.screens.create_account.Progress
import com.fiz.e_learn.ui.screens.log_in.*
import com.fiz.e_learn.ui.screens.log_in.components.TextSignUp
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun LogInBody(
    viewModel: LogInViewModel,
    onClickSignUp: () -> Unit = {},
    onClickForgotPassword: () -> Unit = {},
    onClickSignIn: () -> Unit = {},
) {
    val context = LocalContext.current
    val viewState = viewModel.UIState

    BaseContainerForLogInGroup {
        BaseIconForLogInGroup(R.drawable.ic_login_lock, 36.dp, 40.dp)

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(R.string.welcome_back)

        Spacer(modifier = Modifier.padding(4.dp))

        TextSubtitle2(R.string.login_description)

        Spacer(modifier = Modifier.padding(20.dp))

        EmailTextField(
            text = viewModel.emailId,
            textChange = { emailId -> viewModel.newEmailId(emailId) })

        Spacer(modifier = Modifier.padding(12.dp))

        PasswordFingerPrintTextField(
            text = viewModel.password,
            textChange = { password -> viewModel.newPassword(password) })

        Spacer(modifier = Modifier.padding(8.dp))

        TextSubtitle1Green(
            text = R.string.forgot_password,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onClickForgotPassword() }),
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnButton(
            R.string.sign_in,
            onClick = {
                viewModel.clickSignIn()
            }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        TextSubtitle1(R.string.or)

        Spacer(modifier = Modifier.padding(8.dp))

        GoggleButton(onClickSignIn)

        Spacer(modifier = Modifier.padding(8.dp))

        TextSignUp(onClickSignUp)
    }

    if (viewState == LogInState.Error) {
        Toast.makeText(context, "Error SignIn Account", Toast.LENGTH_SHORT).show()
        viewModel.onErrorShow()
    }

    if (viewState == LogInState.Access) {
        onClickSignIn()
        viewModel.onClickSignIn()
    }

    if (viewState == LogInState.Load) {
        Progress()
    }
}


@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 812
)
@Composable
fun OnBoardingBodyPreview() {
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
    heightDp = 812
)
@Composable
fun OnBoardingBodyDarkPreview() {
    ELearnTheme {
        Surface {
            Progress()
        }
    }
}