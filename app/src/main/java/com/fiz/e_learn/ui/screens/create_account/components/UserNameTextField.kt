package com.fiz.e_learn.ui.screens.create_account.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.BaseOutlinedTextField
import com.fiz.e_learn.ui.screens.create_account.CreateAccountViewModel

@Composable
fun UserNameTextField(createAccountViewModel: CreateAccountViewModel = viewModel()) {
    BaseOutlinedTextField(
        text = createAccountViewModel.userName,
        textChange = { userName -> createAccountViewModel.newUserName(userName) },
        icon = R.drawable.ic_username,
        iconSizeWidth = 16.dp,
        iconSizeHeight = 20.dp,
        placeholderText = stringResource(R.string.username),
        modifier = Modifier
            .fillMaxWidth()
    )
}