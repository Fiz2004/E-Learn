package com.fiz.e_learn.ui.screens.create_account.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.create_account.CreateAccountViewModel
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun TextPrivacy(
    createAccountViewModel: CreateAccountViewModel = viewModel(),
    onClickTermsOfServices: () -> Unit={},
    onClickPrivacyPolicy: () -> Unit={}
) {
    Row(modifier = Modifier.padding(end = 48.dp)) {
        Checkbox(checked = createAccountViewModel.isPrivacy, onCheckedChange = { createAccountViewModel.clickPrivacyCheckBox(it) })

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