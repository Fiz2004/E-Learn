package com.fiz.e_learn.ui.screens.main.courses

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.domain.models.Course
import com.fiz.e_learn.domain.models.coursesStore
import com.fiz.e_learn.ui.screens.main.components.FullCourseCard
import com.fiz.e_learn.ui.screens.main.components.MainColumn
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.HEIGHT_SCREEN_BODY_DP
import com.fiz.e_learn.ui.theme.WIDTH_SCREEN_DP

@Composable
fun CoursesBody(
    courses: List<Course> = coursesStore
) {
    MainColumn {
        for (course in courses) {
            FullCourseCard(course = course, progress = 0.15, isPrice = false)
            Spacer(modifier = Modifier.padding(bottom = 16.dp))
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
            CoursesBody()
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
            CoursesBody()
        }
    }
}