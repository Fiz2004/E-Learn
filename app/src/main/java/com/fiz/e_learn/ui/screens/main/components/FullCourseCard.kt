package com.fiz.e_learn.ui.screens.main.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.domain.models.Course
import com.fiz.e_learn.ui.screens.main.home.home_main.components.RatingRow
import com.fiz.e_learn.ui.screens.main.home.home_main.components.TextBestSeller
import com.fiz.e_learn.ui.theme.*

const val HEIGHT_CARD_DP = 150

@Composable
fun FullCourseCard(
    course: Course,
    modifier: Modifier = Modifier,
    progress: Double = 0.15,
    isPrice: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colors.surface2
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(4.dp)
                .size(width = 144.dp, height = 124.dp)
                .clip(shape = RoundedCornerShape(8.dp)),
            painter = painterResource(
                id = course.pictureResourceMap
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .padding(16.dp)
        )

        Column(
            modifier = Modifier
                .padding(end = 8.dp)
                .weight(1f)
        ) {
            RatingRow(course.rating)
            Text(
                text = course.name,
                style = MaterialTheme.typography.subtitle1,
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_username
                    ),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(10.dp, 13.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = course.author,
                    style = MaterialTheme.typography.caption,
                )
            }

            if (isPrice) {
                Row {
                    Text(
                        text = "$" + String.format("%.2f", course.cost),
                        color = MaterialTheme.colors.greenText,
                        style = MaterialTheme.typography.h6,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    if (course.bestSeller)
                        TextBestSeller()
                }
            } else {
                Column {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        progress = progress.toFloat()
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = stringResource(
                            R.string.courses_percent_completed,
                            (progress * 100).toInt().toString()
                        ),
                        style = MaterialTheme.typography.caption,
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_CARD_DP
)
@Composable
private fun Preview() {
    ELearnTheme {
        Surface {
            FullCourseCard(
                Course(
                    name = "Coding with Python Interface",
                    author = "Stephen Moris",
                    pictureResourceMap = R.drawable.card1,
                    rating = 4.5,
                    cost = 14.50,
                    bestSeller = true,
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_CARD_DP
)
@Composable
private fun DarkPreviewPrice() {
    ELearnTheme {
        Surface {
            FullCourseCard(
                Course(
                    name = "Coding with Python Interface",
                    author = "Stephen Moris",
                    pictureResourceMap = R.drawable.card1,
                    rating = 2.0,
                    cost = 14.50,
                    bestSeller = true
                ),
                isPrice = false
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_CARD_DP
)
@Composable
private fun DarkPreviewNoPrice() {
    ELearnTheme {
        Surface {
            FullCourseCard(
                Course(
                    name = "Coding with Python Interface",
                    author = "Stephen Moris",
                    pictureResourceMap = R.drawable.card1,
                    rating = 2.0,
                    cost = 14.50,
                    bestSeller = true
                ),
                isPrice = true
            )
        }
    }
}