package com.fiz.e_learn.ui.screens.log_in

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.*
import com.fiz.e_learn.ui.screens.create_account.BaseIconForLogInGroup
import com.fiz.e_learn.ui.screens.create_account.Progress
import com.fiz.e_learn.ui.screens.log_in.components.GoggleButton
import com.fiz.e_learn.ui.screens.log_in.components.TextSignUp
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun LogInBody(
    viewModel: LogInViewModel = viewModel(),
    moveSignUp: () -> Unit = {},
    moveForgotPassword: () -> Unit = {},
    moveHomeContent: () -> Unit = {},
) {
    val context = LocalContext.current
    val viewState = viewModel.viewState
    val viewAction = viewModel.viewAction
    val errorText = stringResource(R.string.error_signin_account)

    LaunchedEffect(Unit) {
        viewAction.collect {
            when (it) {
                LogInAction.MoveForgotPassword -> {
                    moveForgotPassword()
                }
                LogInAction.MoveHomeContent -> {
                    moveHomeContent()
                }
                LogInAction.MoveSignUp -> {
                    moveSignUp()
                }
                LogInAction.ShowError -> {
                    Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    BaseContainerForLogInGroup {
        BaseIconForLogInGroup(R.drawable.ic_login_lock, 36.dp, 40.dp)

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(R.string.welcome_back)

        Spacer(modifier = Modifier.padding(4.dp))

        TextSubtitle2(R.string.login_description)

        Spacer(modifier = Modifier.padding(20.dp))

        ELearnOutlinedTextField(
            text = viewState.email,
            textChange = { it: String -> viewModel.reduce(LogInEvent.EmailChanged(it)) },
            icon = R.drawable.ic_email,
            iconSizeWidth = 20.dp,
            iconSizeHeight = 16.dp,
            placeholderText = stringResource(R.string.email_id),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(12.dp))

        PasswordFingerPrintTextField(
            text = viewState.password,
            textChange = { viewModel.reduce(LogInEvent.FingerprintClicked) }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        TextSubtitle1Green(
            text = R.string.forgot_password_question,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { viewModel.reduce(LogInEvent.ForgotPasswordClicked) }),
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnButton(
            R.string.sign_in,
            onClick = {
                viewModel.reduce(LogInEvent.SignInClicked)
            }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        TextSubtitle1(R.string.or)

        Spacer(modifier = Modifier.padding(8.dp))

        GoggleButton(onClick = { viewModel.reduce(LogInEvent.SignInWithGoogleClicked) })

        Spacer(modifier = Modifier.padding(8.dp))

        TextSignUp(onClick={
            viewModel.reduce(LogInEvent.SignUpClicked)
        })
    }

    if (viewState.isLoading) {
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