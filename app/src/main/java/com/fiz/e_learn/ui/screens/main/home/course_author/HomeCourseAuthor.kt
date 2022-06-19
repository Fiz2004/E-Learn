package com.fiz.e_learn.ui.screens.main.home.course_author

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.fiz.e_learn.domain.models.coursesStore
import com.fiz.e_learn.ui.screens.main.components.MainColumn
import com.fiz.e_learn.ui.screens.main.home.course_more_info.CourseInfoItem
import com.fiz.e_learn.ui.screens.main.home.home_main.components.RatingRow
import com.fiz.e_learn.ui.screens.main.home.home_main.components.TextBestSeller
import com.fiz.e_learn.ui.screens.sigin.TextSubtitle1
import com.fiz.e_learn.ui.theme.*

@Composable
fun HomeCourseAuthorBody(
    id: Int?,
    moveBuyScreen: () -> Unit = { },
    moveCartScreen: () -> Unit = { },
) {
    val course = coursesStore.find { it.id == id } ?: return
    MainColumn {
        Text(
            text = stringResource(id = R.string.author_about),
            style = MaterialTheme.typography.h6,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Image(
                modifier = Modifier.size(62.dp),
                painter = painterResource(R.drawable.ic_author),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column {
                Row {
                    Text(
                        text = course.author,
                        style = MaterialTheme.typography.subtitle1,
                    )
                    TextBestSeller()
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(id = R.string.author_top_rated),
                    style = MaterialTheme.typography.subtitle1,
                )
                Spacer(modifier = Modifier.height(4.dp))
                RatingRow(rating = 4.5)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "The Lorem Ipsum generators on the Internets tend to repeat predefined chunks asks many till necessary,  of over 200 Latin offer words, It is a long combined established fact that a reader will be distracted by the readable content...",
            style = MaterialTheme.typography.subtitle1,
        )

        Spacer(modifier = Modifier.height(16.dp))

        CourseInfoItem(
            R.drawable.author_ic_file_minus,
            stringResource(id = R.string.author_courses_uploaded, 250)
        )

        Spacer(modifier = Modifier.height(12.dp))

        CourseInfoItem(R.drawable.author_ic_award, stringResource(id = R.string.author_award))

        Spacer(modifier = Modifier.height(12.dp))

        CourseInfoItem(
            R.drawable.author_ic_thumbs_up,
            stringResource(id = R.string.author_followed)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(26.dp),
            backgroundColor = MaterialTheme.colors.surface2
        ) {
            Row(
                modifier = Modifier.padding(vertical = 24.dp, horizontal = 34.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = stringResource(id = R.string.author_offer_price).uppercase(),
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = " \$30.50 ",
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.greenText
                )
                Text(
                    text = "\$40.50",
                    style = MaterialTheme.typography.subtitle1,
                    textDecoration = TextDecoration.LineThrough
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Row {

            Button(modifier = Modifier
                .height(52.dp)
                .weight(0.5f),
                onClick = { moveBuyScreen() },
                shape = RoundedCornerShape(18.dp)
            ) {
                TextSubtitle1(
                    text = stringResource(R.string.author_buy_now),
                    color = Black_900,
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            OutlinedButton(
                modifier = Modifier
                    .height(52.dp)
                    .weight(0.5f)
                    .border(width = 2.dp, color = MaterialTheme.colors.greenText,
                    shape= RoundedCornerShape(18.dp))
                    .clip(shape= RoundedCornerShape(18.dp))
                    .background(color=MaterialTheme.colors.backgroundHome),
                onClick = { moveCartScreen() }) {
                TextSubtitle1(
                    text = stringResource(R.string.author_add_cart),
                    color = MaterialTheme.colors.onSurface,
                )
            }
        }

    }
}


@Preview(
    showBackground = true,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_BODY_DP
)
@Composable
private fun Preview() {
    ELearnTheme {
        Surface {
            HomeCourseAuthorBody(1)
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_BODY_DP
)
@Composable
private fun DarkPreview() {
    ELearnTheme {
        Surface {
            HomeCourseAuthorBody(1)
        }
    }
}