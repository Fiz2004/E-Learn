package com.fiz.e_learn

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.components.BaseContainerForLogInGroup
import com.fiz.e_learn.ui.components.EmailTextField
import com.fiz.e_learn.ui.components.TextH5
import com.fiz.e_learn.ui.components.TextSubtitle2
import com.fiz.e_learn.ui.screens.create_account.BaseIconForLogInGroup
import com.fiz.e_learn.ui.components.PasswordFingerPrintTextField
import com.fiz.e_learn.ui.screens.log_in.LogInViewModel
import com.fiz.e_learn.ui.screens.log_in.TextSubtitle1
import com.fiz.e_learn.ui.theme.*

@Composable
fun LogInBody(
    viewModel: LogInViewModel,
    onClickSignUp: () -> Unit = {},
    onClickForgotPassword: () -> Unit = {},
    onClickSignIn: () -> Unit = {},
) {

    BaseContainerForLogInGroup{
        BaseIconForLogInGroup(R.drawable.ic_login_lock, 36.dp, 40.dp)

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(R.string.welcome_back)

        Spacer(modifier = Modifier.padding(4.dp))

        TextSubtitle2(R.string.login_description)

        Spacer(modifier = Modifier.padding(20.dp))

        EmailTextField(text=viewModel.emailId, textChange = {emailId->viewModel.newEmailId(emailId)})

        Spacer(modifier = Modifier.padding(12.dp))

        PasswordFingerPrintTextField(text=viewModel.password, textChange = {password->viewModel.newPassword(password)})

        Spacer(modifier = Modifier.padding(8.dp))

        TextSubtitle1Green(
            text=R.string.forgot_password,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onClickForgotPassword() }),
            textAlign = TextAlign.End)

        Spacer(modifier = Modifier.padding(8.dp))

        Button(
            R.string.sign_in,
            onClickSignIn=onClickSignIn
        )

        Spacer(modifier = Modifier.padding(8.dp))

        TextSubtitle1(R.string.or)

        Spacer(modifier = Modifier.padding(8.dp))

        GoggleButton(onClickSignIn)

        Spacer(modifier = Modifier.padding(8.dp))

        TextSignUp( onClickSignUp)
    }
}

@Composable
private fun Button(text:Int,modifier:Modifier = Modifier,onClickSignIn: () -> Unit) {
    Button(modifier = modifier
        .height(54.dp)
        .fillMaxWidth(),
        onClick = { onClickSignIn() }) {
        TextSubtitle1(
            text = text,
            color = Black_900,
        )
    }
}

@Composable
private fun TextSubtitle1Green(text:Int,
                               modifier:Modifier = Modifier,
                               textAlign:TextAlign? = null
                               ) {
    Text(
        modifier = modifier,
        textAlign = textAlign,
        text = stringResource(text),
        style = MaterialTheme.typography.subtitle1Green
    )
}

@Composable
private fun TextSignUp(
    onClickSignUp: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append(stringResource(R.string.don_t_have_an_account))
            append(" ")
        }
        pushStringAnnotation(
            tag = "sign up",
            annotation = "sign up"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.greenText
            )
        ) {
            append(stringResource(R.string.sign_up))
        }
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->

            annotatedText.getStringAnnotations(
                tag = "sign up", start = offset,
                end = offset
            )
                .firstOrNull()?.let {
                    onClickSignUp()
                }
        },
    )
}

@Composable
private fun GoggleButton(onClickSignIn: () -> Unit) {
    OutlinedButton(modifier = Modifier
        .fillMaxWidth()
        .height(54.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.border),
        onClick = { onClickSignIn() }) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_char_g
            ),
            contentDescription = null,
            modifier = Modifier.size(20.dp, 24.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = stringResource(R.string.sign_in_with_google),
            style = MaterialTheme.typography.subtitle1OnSurface
        )
    }
}


//@Preview(
//    showBackground = true,
//    widthDp = 375,
//    heightDp = 812
//)
//@Composable
//fun OnBoardingBodyPreview() {
//    ELearnTheme {
//        Surface {
//            LogInBody()
//        }
//    }
//}
//
//@Preview(
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    widthDp = 375,
//    heightDp = 812
//)
//@Composable
//fun OnBoardingBodyDarkPreview() {
//    ELearnTheme {
//        Surface {
//            LogInBody()
//        }
//    }
//}