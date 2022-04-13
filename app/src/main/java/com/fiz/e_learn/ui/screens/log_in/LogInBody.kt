package com.fiz.e_learn

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiz.e_learn.ui.components.TextDescription
import com.fiz.e_learn.ui.components.TextTitle
import com.fiz.e_learn.ui.components.BaseContainerForLogInGroup
import com.fiz.e_learn.ui.screens.create_account.BaseIconForLogInGroup
import com.fiz.e_learn.ui.screens.create_account.EmailTextField
import com.fiz.e_learn.ui.screens.create_account.PasswordFingerPrintTextField
import com.fiz.e_learn.ui.theme.*

@Composable
fun LogInBody(
    onClickSignUp: () -> Unit = {},
    onClickForgotPassword: () -> Unit = {},
    onClickSignIn: () -> Unit = {},
) {
    BaseContainerForLogInGroup{
        BaseIconForLogInGroup(R.drawable.ic_login_lock,36.dp, 40.dp)

        TextTitle(
            stringResource(R.string.welcome_back),
            Modifier.padding(top = 16.dp)
        )

        TextDescription(
            stringResource(R.string.login_description),
            Modifier.padding(top = 4.dp)
        )

        EmailTextField()

        PasswordFingerPrintTextField()

        Row(modifier = Modifier
            .fillMaxWidth().padding(bottom = 20.dp),horizontalArrangement = Arrangement.End) {
            Text(
                modifier = Modifier
                    .clickable(onClick = { onClickForgotPassword() }),
                text = stringResource(R.string.forgot_password),
                style = TextStyle(
                    color = MaterialTheme.colors.greenText,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            )
        }

        Button(modifier = Modifier
            .fillMaxWidth()
            .size(48.dp),
            onClick = { onClickSignIn() }) {
            Text(
                text = stringResource(R.string.sign_in),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            )
        }

        Text(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp),
            text = stringResource(R.string.or),
            textAlign = TextAlign.End,
        )

        OutlinedButton(modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
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
                modifier=Modifier.padding(start=12.dp),
                text = stringResource(R.string.sign_in_with_google),
                style = TextStyle(
                    color= MaterialTheme.colors.onSurface,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            )
        }

        Text(
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable ( onClick={onClickSignUp() }),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.onSurface
                    )
                ) {
                    append(stringResource(R.string.don_t_have_an_account))
                    append(" ")
                }
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.greenText
                    )
                ) {
                    append(stringResource(R.string.sign_up))
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
fun OnBoardingBodyPreview() {
    ELearnTheme {
        Surface {
            LogInBody()
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
fun OnBoardingBodyDarkPreview() {
    ELearnTheme {
        Surface {
            LogInBody()
        }
    }
}