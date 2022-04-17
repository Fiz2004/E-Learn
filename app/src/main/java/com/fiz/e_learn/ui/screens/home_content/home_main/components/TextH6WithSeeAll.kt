package com.fiz.e_learn.ui.screens.home_content.home_main.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun TextH6WithSeeAll(text: Int, modifier: Modifier = Modifier, onClickSeeAll: () -> Unit) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.weight(1f))

        TextSeeAll(onClickSeeAll)

        IconSeeAll()
    }
}