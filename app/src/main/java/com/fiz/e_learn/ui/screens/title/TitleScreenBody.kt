package com.fiz.e_learn.ui.screens.title

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.ELearnTheme
import kotlinx.coroutines.delay

@Composable
fun TitleScreenBody(
    onClickButton: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "E-Learn",
            fontSize = 43.84.sp,
            fontFamily = FontFamily(Font(R.font.comfortaa_light))
        )

        val currentOnTimeout by rememberUpdatedState(onClickButton)

        LaunchedEffect(true) {
            delay(2000)
            currentOnTimeout()
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun TitleScreenBodyPreview() {
    ELearnTheme {
        Surface {
            TitleScreenBody()
        }
    }
}