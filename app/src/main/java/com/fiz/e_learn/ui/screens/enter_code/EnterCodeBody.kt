package com.fiz.e_learn.ui.screens.enter_code

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.BaseContainerForLogInGroup
import com.fiz.e_learn.ui.components.ELearnButton
import com.fiz.e_learn.ui.components.Progress
import com.fiz.e_learn.ui.components.TextH5
import com.fiz.e_learn.ui.screens.create_account.BaseIconForLogInGroup
import com.fiz.e_learn.ui.theme.border
import com.fiz.e_learn.ui.theme.editText
import com.fiz.e_learn.ui.theme.greenText
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun EnterCodeBody(
    viewModel: EnterCodeViewModel = viewModel(),
    moveChangePasswordScreen: (String) -> Unit = {},
    numberPhone: String
) {
    val context = LocalContext.current
    val viewState = viewModel.viewState
    val viewAction = viewModel.viewAction

    val errorText = stringResource(R.string.error_resend_code)
    val newResendCodeSendText = stringResource(R.string.resend_code_send)

    LaunchedEffect(Unit) {
        viewAction.collect {
            when (it) {
                is EnterCodeAction.MoveChangePasswordScreen -> {
                    moveChangePasswordScreen(it.numberPhone)
                }
                EnterCodeAction.ShowError -> {
                    Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()
                }
                EnterCodeAction.ShowNewResendCodeSend -> {
                    Toast.makeText(context, newResendCodeSendText, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    LaunchedEffect(numberPhone) {
        viewModel.reduce(EnterCodeEvent.LoadScreen(numberPhone))
    }

    BaseContainerForLogInGroup {
        BaseIconForLogInGroup(R.drawable.ic_key, 36.dp, 40.dp)

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(stringResource(R.string.enter_code))

        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            modifier = Modifier.width(250.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onSurface2,
            style = MaterialTheme.typography.subtitle2,
            text = buildAnnotatedString {

                append(stringResource(R.string.enter_code_description))

                withStyle(style = SpanStyle(color = MaterialTheme.colors.greenText)) {
                    append(" $numberPhone")
                }

            }
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            VerificationCodeTextField(
                modifier = Modifier.weight(1f),
                value = viewState.codes[0],
                onValueChange = {
                    viewModel.reduce(EnterCodeEvent.CodeChanged(0, it))
                }
            )

            Spacer(modifier = Modifier.weight(0.33f))


            VerificationCodeTextField(
                modifier = Modifier.weight(1f),
                value = viewState.codes[1],
                onValueChange = {
                    viewModel.reduce(EnterCodeEvent.CodeChanged(1, it))
                }
            )

            Spacer(modifier = Modifier.weight(0.33f))


            VerificationCodeTextField(
                modifier = Modifier.weight(1f),
                value = viewState.codes[2],
                onValueChange = {
                    viewModel.reduce(EnterCodeEvent.CodeChanged(2, it))
                }
            )

            Spacer(modifier = Modifier.weight(0.33f))


            VerificationCodeTextField(
                modifier = Modifier.weight(1f),
                value = viewState.codes[3],
                onValueChange = {
                    viewModel.reduce(EnterCodeEvent.CodeChanged(3, it))
                }
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnButton(
            stringResource(R.string.change_password),
            enabled = viewState.isChangePasswordButtonEnabled,
            onClick = {
                viewModel.reduce(EnterCodeEvent.ChangePasswordClicked)
            }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ClickableText(
            modifier = Modifier.width(250.dp),
            style = MaterialTheme.typography.subtitle2.copy(
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.greenText,
                textDecoration = TextDecoration.Underline
            ),
            text = buildAnnotatedString {
                append(stringResource(id = R.string.resend_code))
            },
            onClick = { viewModel.reduce(EnterCodeEvent.ResendCodeClicked) }
        )
    }

    if (viewState.isLoading) {
        Progress()
    }
}

@Composable
private fun VerificationCodeTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onSurface,
            backgroundColor = MaterialTheme.colors.editText,
            focusedBorderColor = MaterialTheme.colors.border,
            unfocusedBorderColor = MaterialTheme.colors.border
        ),
        textStyle = MaterialTheme.typography.subtitle2.copy(
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onSurface
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        placeholder = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "0",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSurface2,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        },
    )


}

@Preview
@Composable
fun ComposablePreview() {
    VerificationCodeTextField(value = "0")
}

