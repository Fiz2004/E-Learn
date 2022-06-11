package com.fiz.e_learn.ui.screens.forgot_password

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun TextSentVerificationCode(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append(stringResource(R.string.verification_code_part1))
            append(" ")
        }
        pushStringAnnotation(
            tag = "verification code",
            annotation = "verification code"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.greenText
            )
        ) {
            append(stringResource(R.string.verification_code_part2))
        }
        pop()

        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append(" ")
            append(stringResource(R.string.verification_code_part3))
            append(" ")
        }
    }

    Row(
        modifier = modifier
            .width(232.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        ClickableText(
            modifier = Modifier.align(CenterVertically),
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
            onClick = { offset ->

                annotatedText.getStringAnnotations(
                    tag = "verification code", start = offset,
                    end = offset
                )
                    .firstOrNull()?.let {
                        onClick()
                    }
            },
            text = annotatedText,
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 812
)
@Composable
fun OnBoardingBodyPreview() {
    ELearnTheme {
        Surface {
            TextSentVerificationCode()
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 375,
    heightDp = 812
)
@Composable
fun OnBoardingBodyDarkPreview() {
    ELearnTheme {
        Surface {
            TextSentVerificationCode()
        }
    }
}