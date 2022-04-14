package com.fiz.e_learn.ui.screens.home_content.home_course

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.home_content.home_all.FullCourseCard
import com.fiz.e_learn.ui.screens.home_content.home_main.RatingRow
import com.fiz.e_learn.ui.screens.home_content.home_main.TextBestSeller
import com.fiz.e_learn.ui.screens.home_content.home_main.courses
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun HomeBodyCourse(
    id: Int?,
    navController: NavController? = null,
    onClickCourse: (Int) -> Unit = { }
) {
    val course = courses.find { it.id == id } ?: return
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundHome)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
    ) {
        Row() {
            Text(
                text = course.name,
                style = MaterialTheme.typography.h6
            )
            if (course.bestSeller)
                TextBestSeller(modifier=Modifier.width(80.dp))
        }
        Row() {
            RatingRow(course.rating)
            Text(
                text = "(${course.countVoted}) ratings ${course.allVoted} Students",
                style = MaterialTheme.typography.caption
            )
        }
        Text(
            text = course.description,
            style = MaterialTheme.typography.body2,
            maxLines = 3, overflow = TextOverflow.Ellipsis
        )

//        Text(
//            modifier = Modifier.fillMaxWidth(),
//            text = stringResource(R.string.top_courses_in_design),
//            style = MaterialTheme.typography.h6
//        )
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            courses.forEach {
//                item {
//                    FullCourseCard(
//                        it,
//                        modifier = Modifier.clickable { onClickCourse(it.id) }
//                    )
//                }
//            }
//        }
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
            HomeBodyCourse(1)
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
            HomeBodyCourse(1)
        }
    }
}