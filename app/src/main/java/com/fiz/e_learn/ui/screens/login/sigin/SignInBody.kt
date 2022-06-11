package com.fiz.e_learn.ui.screens.login.sigin

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.*
import com.fiz.e_learn.ui.screens.create_account.BaseIconForLogInGroup
import com.fiz.e_learn.ui.screens.login.sigin.components.GoggleButton
import com.fiz.e_learn.ui.screens.login.sigin.components.TextSignUp
import com.fiz.e_learn.ui.screens.sigin.TextSubtitle1
import com.fiz.e_learn.ui.screens.sigin.TextSubtitle1Green

@Composable
fun SignInBody(
    viewModel: SignInViewModel = viewModel(),
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
                SignInAction.MoveForgotPassword -> {
                    moveForgotPassword()
                }
                SignInAction.MoveHomeContent -> {
                    moveHomeContent()
                }
                SignInAction.MoveSignUp -> {
                    moveSignUp()
                }
                SignInAction.ShowError -> {
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
            textChange = { it: String -> viewModel.reduce(SignInEvent.EmailChanged(it)) },
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
            textChange = { viewModel.reduce(SignInEvent.FingerprintClicked) }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        TextSubtitle1Green(
            text = R.string.forgot_password_question,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { viewModel.reduce(SignInEvent.ForgotPasswordClicked) }),
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnButton(
            R.string.sign_in,
            onClick = {
                viewModel.reduce(SignInEvent.SignInClicked)
            }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        TextSubtitle1(R.string.or)

        Spacer(modifier = Modifier.padding(8.dp))

        GoggleButton(onClick = { viewModel.reduce(SignInEvent.SignInWithGoogleClicked) })

        Spacer(modifier = Modifier.padding(8.dp))

        TextSignUp(onClick = {
            viewModel.reduce(SignInEvent.SignUpClicked)
        })
    }

    if (viewState.isLoading) {
        Progress()
    }
}