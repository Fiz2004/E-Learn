package com.fiz.e_learn.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    surface = White_800,
    onSurface = Black_900,
    primary = Green_200,
    onPrimary = Navy,
)

private val DarkColorPalette = darkColors(
    surface = Black_800,
    onSurface = White,
    primary = Green_200,
    onPrimary = Chartreuse,
)

@get:Composable
val Colors.onSurface2: Color
    get() = if (isLight) Black_600 else White_600

@get:Composable
val Colors.surface2: Color
    get() = if (isLight) White else Black_700

@get:Composable
val Colors.border: Color
    get() = if (isLight) Black_500 else White_500

@get:Composable
val Colors.borderIconLogIn: Color
    get() = White_400



@get:Composable
val Colors.greenText: Color
    get() = if (isLight) Green_100 else Green_200

@get:Composable
val Colors.editText: Color
    get() = if (isLight) White else Black_800


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