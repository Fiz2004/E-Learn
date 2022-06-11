package com.fiz.e_learn.ui.screens.main_content.home_content.home_main.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.data.courses
import com.fiz.e_learn.ui.screens.home_content.home_main.CourseCard
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun TopCourses(
    onClickCoursesSeeAll: () -> Unit = {},
    onClickCourse: (Int) -> Unit = {}
) {
    val firstBestCourse by remember {
        mutableStateOf(courses.sortedByDescending { it.rating }.getOrNull(0))
    }
    val secondBestCourse by remember {
        mutableStateOf(courses.sortedByDescending { it.rating }.getOrNull(1))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
    ) {

        Spacer(modifier = Modifier.padding(4.dp))

        TextH6WithSeeAll(R.string.top_courses, onClickSeeAll = onClickCoursesSeeAll)

        Spacer(modifier = Modifier.padding(8.dp))

        Row {
            firstBestCourse?.let {
                CourseCard(it, modifier = Modifier
                    .weight(0.475f)
                    .clickable { onClickCourse(it.id) })
            }

            Spacer(Modifier.weight(0.05f))

            secondBestCourse?.let {
                CourseCard(it, modifier = Modifier
                    .weight(0.475f)
                    .clickable { onClickCourse(it.id) })
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
fun TopCoursesPreview() {
    ELearnTheme {
        Surface {
            TopCourses()
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
fun TopCoursesDarkPreview() {
    ELearnTheme {
        Surface {
            TopCourses()
        }
    }
}