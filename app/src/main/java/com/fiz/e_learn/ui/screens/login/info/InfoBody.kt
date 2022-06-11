package com.fiz.e_learn.ui.screens.login.info

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun InfoBody(
    onClickButton: () -> Unit = {}
) {
    Button(onClick = { onClickButton() }) {
        Text(text = "Go HomeContent")
    }
}