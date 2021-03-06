package com.fiz.e_learn.ui.screens.login.sigin.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun TextSignUp(
    onClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onSurface,
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
                color = MaterialTheme.colors.greenText,
                textDecoration = TextDecoration.Underline,
            )
        ) {
            append(stringResource(R.string.sign_up))
        }
    }

    ClickableText(
        text = annotatedText,
        style = MaterialTheme.typography.subtitle2,
        onClick = { offset ->

            annotatedText.getStringAnnotations(
                tag = "sign up", start = offset,
                end = offset
            )
                .firstOrNull()?.let {
                    onClick()
                }
        },
    )
}