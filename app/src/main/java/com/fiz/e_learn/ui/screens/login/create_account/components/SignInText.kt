package com.fiz.e_learn.ui.screens.login.create_account.components

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun SignInText(onClick: () -> Unit) {
    Text(
        modifier = Modifier
            .clickable(onClick = onClick),
        style = MaterialTheme.typography.subtitle2,
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
                    color = MaterialTheme.colors.greenText,
                    textDecoration = TextDecoration.Underline,
                )
            ) {
                append("Sign in")
            }
        },
        color = MaterialTheme.colors.primary,
    )
}