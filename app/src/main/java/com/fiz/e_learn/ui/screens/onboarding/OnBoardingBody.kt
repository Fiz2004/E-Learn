package com.fiz.e_learn.ui.screens.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.TextH5
import com.fiz.e_learn.ui.components.TextSubtitle2
import com.fiz.e_learn.ui.theme.*

@Composable
fun OnBoardingBody(
    page: String?,
    onBoardingViewModel: OnBoardingViewModel = viewModel(),
    onClickButton: () -> Unit = {}
) {
    onBoardingViewModel.setPage(page)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface),
    ) {
        Image(
            painter = painterResource(
                id = onBoardingViewModel.getMainImage()
            ),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 42.dp)
                .size(331.dp, 408.dp)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Fit
        )

        Box(
            modifier = Modifier
                .requiredSize(608.dp, 464.dp)
                .offset(y = 128.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    color = MaterialTheme.colors.surface2,
                    shape = RoundedCornerShape(topStartPercent = 100, topEndPercent = 100)
                )
        )
        Column(
            modifier = Modifier
                .padding(top = 44.dp, bottom = 44.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MainText(onClickButton = onClickButton)
        }
    }
}

@Composable
fun MainText(
    onBoardingViewModel: OnBoardingViewModel = viewModel(),
    onClickButton: () -> Unit = {}
) {

    TextH5(
        stringArrayResource(R.array.on_boarding_title)[onBoardingViewModel.uiState.page - 1],
        Modifier
            .padding(bottom = 14.dp)
            .width(280.dp)
    )
    TextSubtitle2(
        stringArrayResource(R.array.on_boarding_description)[onBoardingViewModel.uiState.page - 1],
        Modifier.padding(start = 50.dp, end = 50.dp, bottom =68.dp)
    )
    FloatingButton(onBoardingViewModel, onClickButton)
}

@Composable
private fun FloatingButton(
    onBoardingViewModel: OnBoardingViewModel = viewModel(),
    onClickButton: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(70.dp, 70.dp)
            .clip(CircleShape)
            .clickable { onClickButton() },
    ) {
        Image(
            painter = painterResource(
                id = onBoardingViewModel.getImageFloatingButton()
            ),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp, 70.dp)
                .align(Alignment.Center),
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(
                id = R.drawable.ic_next
            ),
            contentDescription = null,
            modifier = Modifier
                .size(44.dp, 44.dp)
                .align(Alignment.Center),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_DP
)
@Composable
private fun Preview() {
    ELearnTheme {
        Surface {
            OnBoardingBody("3")
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_DP
)
@Composable
private fun DarkPreview() {
    ELearnTheme {
        Surface {
            OnBoardingBody("3")
        }
    }
}