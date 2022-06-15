package com.fiz.e_learn.ui.screens.main.home.home_main.components

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun TextSeeAll(onClickSeeAll: () -> Unit) {
    Text(
        color = MaterialTheme.colors.greenText,
        text = stringResource(R.string.see_all),
        style = MaterialTheme.typography.caption,
        modifier = Modifier.clickable { onClickSeeAll() }
    )
}