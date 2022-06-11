package com.fiz.e_learn.ui.screens.login.change_password

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ChangePasswordBody(
    onClickButton: () -> Unit = {}
) {
    Button(onClick = { onClickButton() }) {
        Text(text = "Go HomeContent")
    }
}