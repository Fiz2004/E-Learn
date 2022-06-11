package com.fiz.e_learn.ui.screens.login.enter_code

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
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
    moveChangePasswordScreen: () -> Unit = {},
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
                EnterCodeAction.MoveChangePasswordScreen -> {
                    moveChangePasswordScreen()
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
                    append(numberPhone)
                }

            }
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ELearnOutlinedTextField(
                modifier = Modifier.weight(1f),
                text = viewState.codes[0],
                textChange = { viewModel.reduce(EnterCodeEvent.CodeChanged(0, it)) },
                placeholderText = "0",
            )

            Spacer(modifier = Modifier.weight(0.33f))


            ELearnOutlinedTextField(
                modifier = Modifier.weight(1f),

                text = viewState.codes[1],
                textChange = { viewModel.reduce(EnterCodeEvent.CodeChanged(1, it)) },
                placeholderText = "0",
            )

            Spacer(modifier = Modifier.weight(0.33f))


            ELearnOutlinedTextField(
                modifier = Modifier.weight(1f),

                text = viewState.codes[2],
                textChange = { viewModel.reduce(EnterCodeEvent.CodeChanged(2, it)) },
                placeholderText = "0",
            )

            Spacer(modifier = Modifier.weight(0.33f))


            ELearnOutlinedTextField(
                modifier = Modifier.weight(1f),

                text = viewState.codes[3],
                textChange = { viewModel.reduce(EnterCodeEvent.CodeChanged(3, it)) },
                placeholderText = "0",
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
fun ELearnOutlinedTextField(
    text: String,
    textChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholderText: String,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = { textChange(it) },
        shape = RoundedCornerShape(16.dp),
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onSurface2,
            backgroundColor = MaterialTheme.colors.editText,
            focusedBorderColor = MaterialTheme.colors.border,
            unfocusedBorderColor = MaterialTheme.colors.border
        ),
        visualTransformation = visualTransformation,
        textStyle = MaterialTheme.typography.subtitle2.copy(
            textAlign = TextAlign.Center
        ),
        placeholder = {
            Text(
                text = placeholderText,
                modifier = Modifier.padding(start = 12.dp),
                textAlign = TextAlign.Center
            )
        },
    )
}