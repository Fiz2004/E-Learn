package com.fiz.e_learn.ui.screens.main_content.home_content.home_main.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.Green_200
import com.fiz.e_learn.ui.theme.White

@Composable
fun Banner(onClickExplore: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp),
    ) {
        Box(
            modifier = Modifier
                .height(158.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.CenterEnd
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.banner
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(28.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .widthIn(max = 126.dp)
            ) {
                Text(
                    text = stringResource(R.string.real_world) + "\n" + stringResource(R.string.expirience),
                    style = MaterialTheme.typography.h6,
                    color = White
                )

                Spacer(modifier = Modifier.padding(12.dp))

                Row(
                    modifier = Modifier.clickable { onClickExplore() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.explore),
                        color = Green_200,
                        textDecoration = TextDecoration.Underline
                    )
                    IconSeeAll(color = Green_200)
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 144
)
@Composable
fun BannerPreview() {
    ELearnTheme {
        Surface {
            Banner()
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 375,
    heightDp = 144
)
@Composable
fun BannerDarkPreview() {
    ELearnTheme {
        Surface {
            Banner()
        }
    }
}