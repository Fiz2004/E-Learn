package com.fiz.e_learn.ui.screens.home

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
import com.fiz.e_learn.ui.theme.Black_900
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun CourseCard(course: Course) {
    Column(
        modifier = Modifier
            .size(158.dp, 168.dp)
    ) {
        Box(
            modifier = Modifier.clip(shape = RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(
                    id = course.img
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(158.dp, 104.dp),
                contentScale = ContentScale.Crop
            )
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
            Row() {
                Text(
                    text = course.rating.toString(),
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .alpha(0.5f),
                )
                for (n in 1..5) {
                    Image(
                        painter = painterResource(
                            id =
                            if (n > course.rating)
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
    widthDp = 158,
    heightDp = 168
)
@Composable
fun CourseCardPreview() {
    ELearnTheme {
        Surface {
            CourseCard(
                Course(
                """Test
Test""", R.drawable.card1,4.5, )
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
            CourseCard(Course("""Test""", R.drawable.card1, 2.0))
        }
    }
}