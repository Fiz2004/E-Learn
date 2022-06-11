package com.fiz.e_learn.ui.screens.login.create_account.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.ELearnOutlinedTextFieldWithIcon

@Composable
fun PhoneTextField(
    modifier: Modifier = Modifier,
    text: String,
    textChange: (String) -> Unit
) {
    ELearnOutlinedTextFieldWithIcon(
        text = text,
        textChange = textChange,
        icon = R.drawable.ic_phone,
        iconSizeWidth = 16.dp,
        iconSizeHeight = 20.dp,
        placeholderText = stringResource(R.string.phone_hint),
        modifier = modifier
            .fillMaxWidth()
    )
}