package com.fiz.e_learn.ui.screens.login.create_account

import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.*
import com.fiz.e_learn.ui.screens.create_account.BaseIconForLogInGroup
import com.fiz.e_learn.ui.screens.login.create_account.components.SignInText
import com.fiz.e_learn.ui.screens.login.create_account.components.TextPrivacy
import com.fiz.e_learn.ui.screens.login.create_account.components.UserNameTextField


@Composable
fun CreateAccountBody(
    viewModel: CreateAccountViewModel = viewModel(),
    moveTermsOfServicesInfo: () -> Unit = {},
    movePrivacyPolicyInfo: () -> Unit = {},
    moveHomeContent: () -> Unit = {},
    moveSignInScreen: () -> Unit = {},
) {
    val context = LocalContext.current
    val viewState = viewModel.viewState
    val viewAction = viewModel.viewAction
    val errorText = stringResource(R.string.error_create_account)

    LaunchedEffect(Unit) {
        viewAction.collect {
            when (it) {
                CreateAccountAction.Create -> {
                    moveHomeContent()
                }
                CreateAccountAction.Error -> {
                    Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    BaseContainerForLogInGroup {
        BaseIconForLogInGroup(R.drawable.ic_people, 48.dp, 32.dp)

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(R.string.create_account)

        Spacer(modifier = Modifier.padding(4.dp))

        TextSubtitle2(R.string.create_account_description)

        Spacer(modifier = Modifier.padding(20.dp))

        UserNameTextField(
            text = viewState.userName,
            textChange = { viewModel.reduce(CreateAccountEvent.UsernameChanged(it)) }
        )

        Spacer(modifier = Modifier.padding(12.dp))

        ELearnOutlinedTextField(
            text = viewState.email,
            textChange = { it: String -> viewModel.reduce(CreateAccountEvent.EmailChanged(it)) },
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
            textChange = { viewModel.reduce(CreateAccountEvent.PasswordChanged(it)) })

        Spacer(modifier = Modifier.padding(8.dp))

        TextPrivacy(
            checked = viewState.privacy,
            onCheckedChange = { viewModel.reduce(CreateAccountEvent.PrivacyChanged(it)) },
            onClickTermsOfServices = moveTermsOfServicesInfo,
            onClickPrivacyPolicy = movePrivacyPolicyInfo
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnButton(
            R.string.create_account,
            enabled = viewState.isCreateAccountButtonEnabled,
            onClick = {
                viewModel.reduce(CreateAccountEvent.CreateAccountClicked)
            })

        Spacer(modifier = Modifier.padding(8.dp))

        SignInText(onClick = moveSignInScreen)
    }

    if (viewState.isLoading) {
        Progress()
    }
}

