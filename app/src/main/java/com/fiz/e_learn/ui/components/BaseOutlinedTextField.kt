package com.fiz.e_learn.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.border
import com.fiz.e_learn.ui.theme.editText
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun BaseOutlinedTextField(
    text:String,
    textChange:(String)->Unit,
    icon: Int,
    iconSizeWidth: Dp,
    iconSizeHeight: Dp,
    modifier: Modifier = Modifier,
    placeholderText: String,
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = { textChange(it) },
        shape = RoundedCornerShape(16.dp),
        maxLines=1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onSurface2,
            backgroundColor = MaterialTheme.colors.editText,
            focusedBorderColor = MaterialTheme.colors.border,
            unfocusedBorderColor = MaterialTheme.colors.border
        ),
        leadingIcon = {
            Image(
                painter = painterResource(
                    id = icon
                ),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface2),
                contentDescription = null,
                modifier = Modifier.size(iconSizeWidth, iconSizeHeight),
                contentScale = ContentScale.Crop
            )
        },
        textStyle = MaterialTheme.typography.subtitle2,
        placeholder = {
            Text(text = placeholderText, modifier = Modifier.padding(start = 12.dp))
        },
    )
}


@Composable
fun BaseOutlinedTextFieldWithState(
    placeholderText: String,
    icon: Int,
    iconSizeWidth: Dp,
    iconSizeHeight: Dp,
    modifier: Modifier = Modifier,
) {
    val message = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier,
        value = message.value,
        onValueChange = { message.value = it },
        shape = RoundedCornerShape(16.dp),
        maxLines=1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onSurface2,
            backgroundColor = MaterialTheme.colors.editText,
            focusedBorderColor = MaterialTheme.colors.border,
            unfocusedBorderColor = MaterialTheme.colors.border
        ),
        leadingIcon = {
            Image(
                painter = painterResource(
                    id = icon
                ),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface2),
                contentDescription = null,
                modifier = Modifier.size(iconSizeWidth, iconSizeHeight),
                contentScale = ContentScale.Crop
            )
        },
        textStyle = MaterialTheme.typography.subtitle2,
        placeholder = {
            Text(text = placeholderText, modifier = Modifier.padding(start = 12.dp))
        },
    )
}