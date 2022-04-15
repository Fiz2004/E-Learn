package com.fiz.e_learn.ui.screens.create_account

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.log_in.TextSubtitle1
import com.fiz.e_learn.ui.components.*
import com.fiz.e_learn.ui.theme.Black_900
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

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(R.string.create_account)

        Spacer(modifier = Modifier.padding(4.dp))

        TextSubtitle2(R.string.create_account_description)

        Spacer(modifier = Modifier.padding(20.dp))

        UserNameTextField()

        Spacer(modifier = Modifier.padding(12.dp))

        EmailTextField()

        Spacer(modifier = Modifier.padding(12.dp))

        PasswordFingerPrintTextField()

        Spacer(modifier = Modifier.padding(8.dp))

        TextPrivacy(onClickTermsOfServices, onClickPrivacyPolicy)

        Spacer(modifier = Modifier.padding(8.dp))

        CreateAccountButton(
            onClickCreateAccount=onClickCreateAccount
        )

        Spacer(modifier = Modifier.padding(8.dp))

        SignInText(onClickSignIn)

    }
}

@Composable
private fun SignInText(onClickSignIn: () -> Unit) {
    Text(
        modifier = Modifier
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

@Composable
private fun CreateAccountButton(
    modifier: Modifier=Modifier,
    createAccountViewModel: CreateAccountViewModel = viewModel(),
    onClickCreateAccount: () -> Unit) {

    val context= LocalContext.current

    Button(modifier = modifier
        .height(54.dp)
        .fillMaxWidth(),
        enabled = createAccountViewModel.isCreateAccountButtonEnabled(),
        onClick = {
            if (createAccountViewModel.clickCreateAccount())
                onClickCreateAccount()
            else
                Toast.makeText(context,"Error Create Account",Toast.LENGTH_SHORT).show()
        }) {

        TextSubtitle1(
            text = "Create account",
            color = Black_900,
        )
    }
}

@Composable
private fun UserNameTextField(createAccountViewModel: CreateAccountViewModel = viewModel()) {
    BaseOutlinedTextField(
        text=createAccountViewModel.userName,
        textChange={userName->createAccountViewModel.newUserName(userName)},
        icon=R.drawable.ic_username,
        iconSizeWidth = 16.dp,
        iconSizeHeight = 20.dp,
        placeholderText = stringResource(R.string.username),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
private fun TextPrivacy(
    onClickTermsOfServices: () -> Unit,
    onClickPrivacyPolicy: () -> Unit
) {
    Row(modifier = Modifier.padding(end = 48.dp)) {
        val checkedState = remember { mutableStateOf(false) }
        Checkbox(checked = checkedState.value, onCheckedChange = { checkedState.value = it })

        val annotatedText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.onSurface
                )
            ) {
                append("I hereby agree to the")
                append(" ")
            }
            pushStringAnnotation(
                tag = "terms of services",
                annotation = "terms of services"
            )
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.greenText
                )
            ) {
                append("terms of services")
            }
            pop()

            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.onSurface
                )
            ) {
                append(" ")
                append("and")
                append(" ")
            }

            pushStringAnnotation(
                tag = "privacy policy",
                annotation = "privacy policy"
            )
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.greenText
                )
            ) {
                append("privacy policy")
            }
            pop()
        }

        ClickableText(
            modifier = Modifier
                .padding(top = 16.dp),
            onClick = { offset ->

                annotatedText.getStringAnnotations(
                    tag = "terms of services", start = offset,
                    end = offset
                )
                    .firstOrNull()?.let {
                        onClickTermsOfServices();
                    }

                annotatedText.getStringAnnotations(
                    tag = "privacy policy", start = offset,
                    end = offset
                )
                    .firstOrNull()?.let {
                        onClickPrivacyPolicy()
                    }


            },
            text = annotatedText,
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