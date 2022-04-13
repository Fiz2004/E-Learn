package com.fiz.e_learn.ui.screens.create_account

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.TextDescription
import com.fiz.e_learn.ui.components.TextTitle
import com.fiz.e_learn.ui.components.BaseContainerForLogInGroup
import com.fiz.e_learn.ui.screens.log_in.BaseOutlinedTextField
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun CreateAccountBody(
    onClickTermsOfServices: () -> Unit = {},
    onClickPrivacyPolicy: () -> Unit = {},
    onClickCreateAccount: () -> Unit = {},
    onClickSignIn: () -> Unit = {},
) {
    BaseContainerForLogInGroup {
        BaseIconForLogInGroup(R.drawable.ic_people, 48.dp, 32.dp)

        TextTitle(
            stringResource(R.string.create_account),
            Modifier.padding(top = 16.dp)
        )

        TextDescription(
            stringResource(R.string.create_account_description),
            Modifier.padding(top = 4.dp)
        )

        BaseOutlinedTextField(
            stringResource(R.string.username), Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(), R.drawable.ic_username,
            16.dp, 20.dp
        )

        EmailTextField()

        PasswordFingerPrintTextField()

        Row(modifier = Modifier.padding(end = 48.dp)) {
            val checkedState = remember { mutableStateOf(false) }
            Checkbox(checked = checkedState.value, onCheckedChange = { checkedState.value = it })


            Text(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .clickable(onClick = { onClickTermsOfServices(); onClickPrivacyPolicy() }),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colors.onSurface
                        )
                    ) {
                        append("I hereby agree to the")
                        append(" ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colors.greenText
                        )
                    ) {
                        append("terms of services")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colors.onSurface
                        )
                    ) {
                        append(" ")
                        append("and")
                        append(" ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colors.greenText
                        )
                    ) {
                        append("privacy policy")
                    }
                },
                color = MaterialTheme.colors.primary,
            )
        }

        Button(modifier = Modifier
            .padding(top = 24.dp)
            .height(48.dp)
            .fillMaxWidth(),
            onClick = { onClickCreateAccount() }) {
            Text(
                text = "Create account",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            )
        }

        Text(
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable(onClick = { onClickSignIn() }),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.onSurface
                    )
                ) {
                    append("Already have an account?")
                    append(" ")
                }
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.greenText
                    )
                ) {
                    append("Sign in")
                }
            },
            color = MaterialTheme.colors.primary,
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
            CreateAccountBody()
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
            CreateAccountBody()
        }
    }
}