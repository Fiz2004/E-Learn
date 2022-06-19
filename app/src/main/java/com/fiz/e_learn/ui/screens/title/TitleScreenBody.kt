package com.fiz.e_learn.ui.screens.title

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import kotlinx.coroutines.delay

@Composable
fun TitleScreenBody(
    viewModel: TitleViewModel = viewModel(),
    moveOnBoardingScreen: () -> Unit = {},
    moveLogInScreen: () -> Unit = {},
) {
    val firstTimeLaunch = viewModel.firstTimeLaunch

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "E-Learn",
            fontSize = 44.sp,
            fontFamily = FontFamily(Font(R.font.comfortaa_light))
        )

        LaunchedEffect(true) {
            delay(2000)
            if (firstTimeLaunch) {
                moveOnBoardingScreen()
            } else {
                moveLogInScreen()
            }
        }
    }
}