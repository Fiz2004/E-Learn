package com.fiz.e_learn.ui.screens.login.forgot_password

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

@Composable
fun ForgotPasswordBody(
    viewModel: ForgotPasswordViewModel = viewModel(),
    moveEnterCodeScreen: (String) -> Unit = {},
) {
    val context = LocalContext.current
    val viewState = viewModel.viewState
    val viewAction = viewModel.viewAction

    val errorText = stringResource(R.string.error_sent_verification_code)

    LaunchedEffect(Unit) {
        viewAction.collect {
            when (it) {
                is ForgotPasswordAction.MoveEnterCode -> {
                    moveEnterCodeScreen(it.numberPhone)
                }
                ForgotPasswordAction.ShowError -> {
                    Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    BaseContainerForLogInGroup {
        BaseIconForLogInGroup(R.drawable.ic_key, 36.dp, 40.dp)

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(R.string.forgot_password)

        Spacer(modifier = Modifier.padding(4.dp))

        TextSubtitle2(stringResource(id = R.string.forgot_description))

        Spacer(modifier = Modifier.padding(20.dp))

        ELearnOutlinedTextFieldWithIcon(
            text = viewState.numberPhone,
            textChange = { viewModel.reduce(ForgotPasswordEvent.PhoneChanged(it)) },
            icon = R.drawable.ic_phone,
            iconSizeWidth = 20.dp,
            iconSizeHeight = 16.dp,
            placeholderText = stringResource(R.string.phone_hint),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnButton(
            stringResource(id = R.string.continue_text),
            enabled = viewState.isContinueButtonEnabled,
            onClick = {
                viewModel.reduce(ForgotPasswordEvent.ContinueClicked)
            }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        if (viewState.isShowLabelSentVerificationCode)
            TextSentVerificationCode(
                onClick = {
                    viewModel.reduce(ForgotPasswordEvent.VerificationCodeClicked)
                })
    }

    if (viewState.isLoading) {
        Progress()
    }
}
