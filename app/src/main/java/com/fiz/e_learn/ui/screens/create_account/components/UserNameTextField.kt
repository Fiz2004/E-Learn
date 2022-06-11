package com.fiz.e_learn.ui.screens.create_account.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.ELearnOutlinedTextField

@Composable
fun UserNameTextField(
    modifier: Modifier = Modifier,
    text: String,
    textChange: (String) -> Unit
) {
    ELearnOutlinedTextField(
        text = text,
        textChange = textChange,
        icon = R.drawable.ic_username,
        iconSizeWidth = 16.dp,
        iconSizeHeight = 20.dp,
        placeholderText = stringResource(R.string.username),
        modifier = modifier
            .fillMaxWidth()
    )
}