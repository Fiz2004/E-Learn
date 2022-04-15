package com.fiz.e_learn.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.ui.components.BaseOutlinedTextField
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.create_account.CreateAccountViewModel

@Composable
fun EmailTextField(
    modifier:Modifier=Modifier,
    createAccountViewModel: CreateAccountViewModel = viewModel(),
) {
    BaseOutlinedTextField(
        text=createAccountViewModel.emailId,
        textChange={emailId->createAccountViewModel.newEmailId(emailId)},
        icon=R.drawable.ic_email,
        iconSizeWidth = 20.dp,
        iconSizeHeight = 16.dp,
        placeholderText = stringResource(R.string.email_id),
        modifier = Modifier
            .fillMaxWidth()
    )
}