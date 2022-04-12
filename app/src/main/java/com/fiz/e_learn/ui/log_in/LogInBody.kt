package com.fiz.e_learn

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.ColorFilter
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
import com.fiz.e_learn.ui.theme.*

@Composable
fun LogInBody(
    onClickSignUp: () -> Unit = {},
    onClickForgotPassword: () -> Unit = {},
    onClickSignIn: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 155.dp)
                .size(78.92.dp),
            painter = painterResource(
                id = R.drawable.ic_login_lock
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        TextTitle(
            stringResource(R.string.welcome_back),
            Modifier.padding(top = 16.dp)
        )

        TextDescription(
            stringResource(R.string.login_description),
            Modifier.padding(top = 4.dp)
        )

        LogInOutlinedTextField(
            stringResource(R.string.email_id), Modifier
                .padding(top = 26.dp)
                .fillMaxWidth()
                .height(52.dp), R.drawable.ic_email
        )

        Row(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 12.dp)
                .fillMaxWidth()
        ) {
            LogInOutlinedTextField(
                stringResource(R.string.password), Modifier
                    .height(52.dp)
                    .padding(end = 10.dp)
                    .weight(1f), R.drawable.ic_password  )

            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .height(52.dp)
                    .width(66.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.border),
                colors=ButtonDefaults.outlinedButtonColors(backgroundColor=MaterialTheme.colors.editText,),
                shape = RoundedCornerShape(18.dp)
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_fingerprint
                    ),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface2),
                    contentDescription = null,
                    modifier = Modifier.size(25.06.dp, 28.94.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

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
            .size(52.dp),
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
                .padding(top = 14.dp, bottom = 14.dp),
            text = stringResource(R.string.or),
            textAlign = TextAlign.End,
        )

        OutlinedButton(modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
            border = BorderStroke(1.dp, MaterialTheme.colors.border),
            onClick = { onClickSignIn() }) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_char_g
                ),
                contentDescription = null,
                modifier = Modifier.size(22.dp, 26.dp),
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
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append(stringResource(R.string.sign_up))
                }
            },
            color = MaterialTheme.colors.primary,
        )
    }
}


@Composable
private fun LogInOutlinedTextField(text: String, modifier: Modifier, icon: Int) {
    val message = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = modifier,
        value = message.value,
        onValueChange = { message.value = it },
        shape = RoundedCornerShape(18.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor=MaterialTheme.colors.editText,
            focusedBorderColor = MaterialTheme.colors.border,
            unfocusedBorderColor = MaterialTheme.colors.border),
        leadingIcon = {
            Image(
                painter = painterResource(
                    id = icon
                ),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface2),
                contentDescription = null,
                modifier = Modifier.size(19.28.dp, 17.36.dp),
                contentScale = ContentScale.Crop
            )
        },
        textStyle = TextStyle(
            color = MaterialTheme.colors.onSurface2,
            fontFamily = FontFamily(Font(R.font.inter_light)),
            fontWeight = FontWeight.Light,
            fontSize = 14.sp
        ),
        placeholder = {
            Text(text = text, modifier = Modifier.padding(start = 12.dp))
        },
//            borderStroke=BorderStroke(1.dp,MaterialTheme.colors.border)
    )
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