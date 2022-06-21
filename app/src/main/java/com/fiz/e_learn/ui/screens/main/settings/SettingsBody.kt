package com.fiz.e_learn.ui.screens.main.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.main.MainViewModel
import com.fiz.e_learn.ui.screens.main.components.MainColumn
import com.fiz.e_learn.ui.theme.surface2

@Composable
fun SettingsBody(viewModel: MainViewModel = viewModel()) {

    val state = viewModel.viewState

    MainColumn {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    shape = RoundedCornerShape(26.dp),
                    color = MaterialTheme.colors.surface2
                )
                .padding(horizontal = 16.dp, vertical = 16.dp),
        ) {
            AccountInfo(userName = state.userName, numberPhone = state.numberPhone)

            Spacer(modifier = Modifier.height(32.dp))

            AccountItem(
                icon = R.drawable.settings_ic_payment_hystory,
                text = R.string.settings_payment_hystory
            )

            Divider(modifier = Modifier.fillMaxWidth())

            AccountItem(
                icon = R.drawable.settings_ic_notifications,
                text = R.string.settings_notifications
            )

            Divider(modifier = Modifier.fillMaxWidth())

            AccountItem(
                icon = R.drawable.settings_ic_help_support,
                text = R.string.settings_help_support
            )

            Divider(modifier = Modifier.fillMaxWidth())

            AccountItem(icon = R.drawable.settings_ic_settings, text = R.string.settings_settings)

            Divider(modifier = Modifier.fillMaxWidth())

            AccountItem(icon = R.drawable.settings_ic_logout, text = R.string.settings_logout)

            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

@Composable
private fun AccountInfo(userName: String, numberPhone: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier.size(72.dp),
            painter = painterResource(
                id = R.drawable.settings_pic_user
            ), contentDescription = null
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = userName,
            style = MaterialTheme.typography.subtitle1
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = numberPhone,
            style = MaterialTheme.typography.subtitle2
        )
    }
}

@Composable
private fun AccountItem(icon: Int, text: Int, onClick: () -> Unit = {}) {
    Column(modifier = Modifier.clickable { onClick() }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(
                    id = icon
                ), contentDescription = null
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}