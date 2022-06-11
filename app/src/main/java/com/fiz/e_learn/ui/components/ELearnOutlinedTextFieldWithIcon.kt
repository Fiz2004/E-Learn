package com.fiz.e_learn.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.theme.border
import com.fiz.e_learn.ui.theme.editText
import com.fiz.e_learn.ui.theme.onSurface2

@Composable
fun ELearnOutlinedTextFieldWithIcon(
    text: String,
    textChange: (String) -> Unit,
    icon: Int,
    iconSizeWidth: Dp,
    iconSizeHeight: Dp,
    modifier: Modifier = Modifier,
    placeholderText: String,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = { textChange(it) },
        shape = RoundedCornerShape(16.dp),
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onSurface2,
            backgroundColor = MaterialTheme.colors.editText,
            focusedBorderColor = MaterialTheme.colors.border,
            unfocusedBorderColor = MaterialTheme.colors.border
        ),
        visualTransformation = visualTransformation,
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
        textStyle = MaterialTheme.typography.subtitle2.copy(
            color = MaterialTheme.colors.onSurface
        ),
        placeholder = {
            Text(
                text = placeholderText,
                color = MaterialTheme.colors.onSurface2
            )
        },
    )
}