package com.fiz.e_learn.ui.screens.home_content.home_all

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.fiz.e_learn.ui.screens.home_content.home_main.Course
import com.fiz.e_learn.ui.screens.home_content.home_main.RatingRow
import com.fiz.e_learn.ui.screens.home_content.home_main.TextBestSeller
import com.fiz.e_learn.ui.theme.*

@Composable
fun FullCourseCard(course: Course, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(130.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.surface2),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(
                id = course.img
            ),
            contentDescription = null,
            modifier = Modifier
                .padding(4.dp)
                .size(136.dp, 122.dp)
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
                .defaultMinSize(minWidth = 22.dp)
        )
        Column() {
            RatingRow(course.rating)
            Text(
                text = course.name,
                style = MaterialTheme.typography.subtitle1,
            )
            Row() {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_username
                    ),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface2),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(10.dp, 13.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = course.author,
                    style = MaterialTheme.typography.caption,
                )
            }
            Row() {
                Text(
                    text = "$" + String.format("%.2f", course.cost),
                    color = MaterialTheme.colors.greenText,
                    style = MaterialTheme.typography.h6,
                )
                Spacer(modifier = Modifier.weight(1f))
                if (course.bestSeller)
                    TextBestSeller()
            }
        }

        Box(
            modifier = Modifier.clip(shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.BottomStart)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colors.primary)
                    .padding(vertical = 4.dp, horizontal = 6.dp),
                color = Black_900,
                text = stringResource(R.string.best_seller),
                style = MaterialTheme.typography.overline
            )
        }
        Column(
            modifier = Modifier
        ) {
            RatingRow(course.rating)
            Text(
                modifier = Modifier
                    .width(158.dp),
                text = course.name,
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 130
)
@Composable
fun CourseCardPreview() {
    ELearnTheme {
        Surface {
            FullCourseCard(
                Course(
                    name = "Coding with Python Interface",
                    author = "Stephen Moris",
                    img = R.drawable.card1,
                    rating = 4.5,
                    cost = 14.50,
                    bestSeller = true
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 375,
    heightDp = 150
)
@Composable
fun CourseCardDarkPreview() {
    ELearnTheme {
        Surface(
            modifier = Modifier.background(MaterialTheme.colors.background)
        ) {
            FullCourseCard(
                Course(
                    name = "Coding with Python Interface",
                    author = "Stephen Moris",
                    img = R.drawable.card1,
                    rating = 2.0,
                    cost = 14.50,
                    bestSeller = true
                )
            )
        }
    }
}