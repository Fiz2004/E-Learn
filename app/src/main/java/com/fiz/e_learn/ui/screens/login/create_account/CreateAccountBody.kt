package com.fiz.e_learn.ui.screens.login.create_account

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.*
import com.fiz.e_learn.ui.components.BaseIconForLogInGroup
import com.fiz.e_learn.ui.screens.login.create_account.components.PhoneTextField
import com.fiz.e_learn.ui.screens.login.create_account.components.SignInText
import com.fiz.e_learn.ui.screens.login.create_account.components.TextPrivacy
import com.fiz.e_learn.ui.screens.login.create_account.components.UserNameTextField
import com.fiz.e_learn.ui.screens.login.sigin.SignInBody
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.HEIGHT_SCREEN_DP
import com.fiz.e_learn.ui.theme.WIDTH_SCREEN_DP


@Composable
fun CreateAccountBody(
    viewModel: CreateAccountViewModel = viewModel(),
    moveTermsOfServicesInfo: () -> Unit = {},
    movePrivacyPolicyInfo: () -> Unit = {},
    moveInfoScreen: () -> Unit = {},
    moveSignInScreen: () -> Unit = {},
) {
    val context = LocalContext.current
    val viewState = viewModel.viewState
    val viewAction = viewModel.viewAction
    val errorText = stringResource(R.string.error_create_account)

    LaunchedEffect(Unit) {
        viewAction.collect {
            when (it) {
                CreateAccountAction.MoveHomeContentScreen -> {
                    moveInfoScreen()
                }
                CreateAccountAction.MovePrivacyPolicyInfoScreen -> {
                    movePrivacyPolicyInfo()
                }
                CreateAccountAction.MoveSignInScreen -> {
                    moveSignInScreen()
                }
                CreateAccountAction.MoveTermsOfServicesInfoScreen -> {
                    moveTermsOfServicesInfo()
                }
                CreateAccountAction.ShowError -> {
                    Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    BaseContainerForLogInGroup(top=156) {
        BaseIconForLogInGroup(R.drawable.ic_people, 48.dp, 32.dp)

        Spacer(modifier = Modifier.height(18.dp))

        TextH5(R.string.create_account)

        Spacer(modifier = Modifier.height(4.dp))

        TextSubtitle2(stringResource(id = R.string.create_account_description))

        Spacer(modifier = Modifier.height(28.dp))

        UserNameTextField(
            text = viewState.userName,
            textChange = { viewModel.reduce(CreateAccountEvent.UsernameChanged(it)) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        PhoneTextField(
            text = viewState.phoneNumber,
            textChange = { viewModel.reduce(CreateAccountEvent.PhoneNumberChanged(it)) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ELearnOutlinedTextFieldWithIcon(
            text = viewState.email,
            textChange = { viewModel.reduce(CreateAccountEvent.EmailChanged(it)) },
            icon = R.drawable.ic_email,
            iconSizeWidth = 20.dp,
            iconSizeHeight = 16.dp,
            placeholderText = stringResource(R.string.email_id),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        PasswordFingerPrintTextField(
            text = viewState.password,
            textChange = { viewModel.reduce(CreateAccountEvent.PasswordChanged(it)) },
            fingerPrintOnClick = {})

        Spacer(modifier = Modifier.height(20.dp))

        TextPrivacy(
            checked = viewState.privacy,
            onCheckedChange = { viewModel.reduce(CreateAccountEvent.PrivacyChanged(it)) },
            onClickTermsOfServices = moveTermsOfServicesInfo,
            onClickPrivacyPolicy = movePrivacyPolicyInfo
        )

        Spacer(modifier = Modifier.height(26.dp))

        ELearnButton(
            stringResource(id = R.string.create_account),
            enabled = viewState.isCreateAccountButtonEnabled,
            onClick = {
                viewModel.reduce(CreateAccountEvent.CreateAccountClicked)
            })

        Spacer(modifier = Modifier.height(20.dp))

        SignInText(onClick = moveSignInScreen)

        Spacer(modifier = Modifier.height(40.dp))
    }

    if (viewState.isLoading) {
        Progress()
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
            CreateAccountBody()
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
            CreateAccountBody()
        }
    }
}