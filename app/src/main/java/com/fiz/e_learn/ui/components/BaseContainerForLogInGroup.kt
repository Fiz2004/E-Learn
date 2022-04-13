package com.fiz.e_learn.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseContainerForLogInGroup(
    modifier: Modifier = Modifier, content: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 82.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content?.let {
            it()
        }
    }
}