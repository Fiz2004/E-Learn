package com.fiz.e_learn.ui.screens.home_content.buy

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.home_content.home_main.RatingRow
import com.fiz.e_learn.ui.screens.home_content.home_main.TextBestSeller
import com.fiz.e_learn.ui.theme.*

@Composable
fun HomeBuyBody(
    onClickPayNow: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.backgroundHome)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            backgroundColor = MaterialTheme.colors.surface2
        ) {

            Row(
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colors.surface2),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.card1
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(53.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(
                    modifier = Modifier
                        .weight(0.05f)
                        .defaultMinSize(minWidth = 22.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(0.5f)
                ) {
                    Text(
                        text = "Get Started with Python",
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Text(
                        text = "\$40.95",
                        style = MaterialTheme.typography.subtitle1,
                    )

                }

                Spacer(
                    modifier = Modifier
                        .weight(0.05f)
                        .defaultMinSize(minWidth = 22.dp)
                )

                Column(){
                    Text(
                        text = "+",
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Text(
                        text = "1",
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Text(
                        text = "-",
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
            }

        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 875
)
@Composable
fun HomeBodyPreview() {
    ELearnTheme {
        Surface {
            HomeBuyBody()
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 375,
    heightDp = 875
)
@Composable
fun HomeBodyDarkPreview() {
    ELearnTheme {
        Surface {
            HomeBuyBody()
        }
    }
}