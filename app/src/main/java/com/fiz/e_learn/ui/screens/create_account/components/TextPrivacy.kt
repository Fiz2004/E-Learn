package com.fiz.e_learn.ui.screens.create_account.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun TextPrivacy(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit = {},
    onClickTermsOfServices: () -> Unit = {},
    onClickPrivacyPolicy: () -> Unit = {}
) {
    Row(modifier = Modifier.padding(end = 48.dp)) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)

        val annotatedText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.onSurface
                )
            ) {
                append(stringResource(R.string.i_hereby_agree_to_the))
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
                append(stringResource(R.string.terms_of_services))
            }
            pop()

            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.onSurface
                )
            ) {
                append(" ")
                append(stringResource(R.string.and))
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
                append(stringResource(R.string.privacy_police))
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
                        onClickTermsOfServices()
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
    heightDp = 812
)
@Composable
fun OnBoardingBodyPreview() {
    ELearnTheme {
        Surface {
            TextPrivacy(true)
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
            TextPrivacy(false)
        }
    }
}