package com.fiz.e_learn.ui.screens.home_content.home_main

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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.data.Course
import com.fiz.e_learn.ui.theme.Black_900
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun CourseCard(course: Course, modifier:Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().height(183.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(
                    id = course.img
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .height( 120.dp),
                contentScale = ContentScale.Crop
            )
            if (course.bestSeller)
                TextBestSeller(modifier = Modifier.align(Alignment.BottomStart))
        }
        Column(
            modifier = Modifier
        ) {
            RatingRow(course.rating)
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = course.name,
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@Composable
fun TextBestSeller(modifier:Modifier = Modifier) {
    Text(
        modifier = modifier
            .padding(4.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.primary)
            .padding(vertical = 4.dp, horizontal = 6.dp),
        color = Black_900,
        text = stringResource(R.string.best_seller),
        style = MaterialTheme.typography.overline,
        maxLines = 1
    )
}

@Composable
fun RatingRow(rating: Double) {
    Row() {
        Text(
            text = rating.toString(),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(end = 4.dp)
                .alpha(0.5f),
        )
        for (n in 1..5) {
            Image(
                painter = painterResource(
                    id =
                    if (n > rating)
                        R.drawable.ic_empty_star
                    else
                        R.drawable.ic_star
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(10.dp, 10.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 158,
    heightDp = 168
)
@Composable
fun CourseCardPreview() {
    ELearnTheme {
        Surface {
            CourseCard(
                Course(
                    name="""Test
Test""", img = R.drawable.card1, rating = 4.5, bestSeller = true
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 158,
    heightDp = 168
)
@Composable
fun CourseCardDarkPreview() {
    ELearnTheme {
        Surface {
            CourseCard(Course(name="""Test""", img = R.drawable.card1, rating = 2.0, bestSeller = true))
        }
    }
}