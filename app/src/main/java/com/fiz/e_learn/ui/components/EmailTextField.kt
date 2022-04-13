package com.fiz.e_learn.ui.screens.create_account

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.screens.log_in.BaseOutlinedTextField
import com.fiz.e_learn.R

@Composable
fun EmailTextField() {
    BaseOutlinedTextField(
        stringResource(R.string.email_id), Modifier
            .padding(top = 24.dp)
            .fillMaxWidth(), R.drawable.ic_email,
        20.dp, 16.dp
    )
}