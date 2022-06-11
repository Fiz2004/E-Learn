package com.fiz.e_learn.ui.screens.login.change_password

import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.*
import com.fiz.e_learn.ui.screens.create_account.BaseIconForLogInGroup

@Composable
fun ChangePasswordBody(
    viewModel: ChangePasswordViewModel = viewModel(),
    moveInfoScreen: () -> Unit = {},
) {
    val context = LocalContext.current
    val viewState = viewModel.viewState
    val viewAction = viewModel.viewAction

    val errorText = stringResource(R.string.error_change_password)

    LaunchedEffect(Unit) {
        viewAction.collect {
            when (it) {

                ChangePasswordAction.MoveInfoScreen -> {
                    moveInfoScreen()
                }
                ChangePasswordAction.ShowError -> {
                    Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    BaseContainerForLogInGroup {
        BaseIconForLogInGroup(R.drawable.ic_key, 36.dp, 40.dp)

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(stringResource(R.string.change_password))

        Spacer(modifier = Modifier.padding(4.dp))

        TextSubtitle2(stringResource(id = R.string.change_password_description))

        Spacer(modifier = Modifier.padding(20.dp))

        ELearnOutlinedTextFieldWithIcon(
            text = viewState.newPassword,
            textChange = { viewModel.reduce(ChangePasswordEvent.NewPasswordChanged(it)) },
            placeholderText = stringResource(R.string.new_password_hint),
            modifier = Modifier
                .padding(end = 16.dp)
                .fillMaxWidth(),
            icon = R.drawable.ic_password,
            iconSizeWidth = 20.dp,
            iconSizeHeight = 16.dp,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnOutlinedTextFieldWithIcon(
            text = viewState.confirmPassword,
            textChange = { viewModel.reduce(ChangePasswordEvent.ConfirmPasswordChanged(it)) },
            placeholderText = stringResource(R.string.confirm_password_hint),
            modifier = Modifier
                .padding(end = 16.dp)
                .fillMaxWidth(),
            icon = R.drawable.ic_password,
            iconSizeWidth = 20.dp,
            iconSizeHeight = 16.dp,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnButton(
            stringResource(R.string.save_password),
            enabled = viewState.isSavePasswordButtonEnabled,
            onClick = {
                viewModel.reduce(ChangePasswordEvent.SavePasswordClicked)
            }
        )

    }

    if (viewState.isLoading) {
        Progress()
    }
}