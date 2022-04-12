package com.fiz.e_learn.ui.theme

import android.graphics.drawable.ShapeDrawable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R

private val LightColorPalette = lightColors(
    surface = White_100,
    onSurface = Black_200,
    primary = Green_200,
    onPrimary = Navy,
)

private val DarkColorPalette = darkColors(
    surface = Black_100,
    onSurface = White_200,
    primary = Green_200,
    onPrimary = Chartreuse,
)

@get:Composable
val Colors.onSurface2: Color
    get() = if (isLight) Black_300 else White_300

@get:Composable
val Colors.surface2: Color
    get() = if (isLight) White_400 else Black_400

@get:Composable
val Colors.border: Color
    get() = if (isLight) White_500 else Black_500

@get:Composable
val Colors.greenText: Color
    get() = if (isLight) White_100 else Black_200


@Composable
fun ELearnTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = ELearnTypography,
        shapes = ELearnShapes,
        content = content
    )
}