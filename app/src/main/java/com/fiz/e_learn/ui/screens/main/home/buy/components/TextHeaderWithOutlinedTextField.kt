package com.fiz.e_learn.ui.screens.main.home.buy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.theme.border
import com.fiz.e_learn.ui.theme.editText
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun TextHeaderWithOutlinedTextField(
    modifier: Modifier,
    textHeader: String,
    textHint: String,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = textHeader,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            value = "",
            onValueChange = { },
            shape = RoundedCornerShape(16.dp),
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colors.onSurface,
                backgroundColor = MaterialTheme.colors.editText,
                focusedBorderColor = MaterialTheme.colors.border,
                unfocusedBorderColor = MaterialTheme.colors.border
            ),
            trailingIcon = trailingIcon,
            textStyle = MaterialTheme.typography.subtitle2.copy(
                color = MaterialTheme.colors.onSurface
            ),
            placeholder = {
                Text(
                    text = textHint,
                    color = MaterialTheme.colors.onSurface2
                )
            },
        )
    }
}