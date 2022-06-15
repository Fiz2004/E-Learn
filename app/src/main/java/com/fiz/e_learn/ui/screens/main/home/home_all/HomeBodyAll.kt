package com.fiz.e_learn.ui.screens.main.home.home_all

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.domain.models.coursesStore
import com.fiz.e_learn.ui.screens.main.components.FullCourseCard
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun HomeBodyAll(filter: String? = "all", onClickCourse: (Int) -> Unit = { }) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundHome)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(
                R.string.top_courses_in_category, when (filter) {
                    "all" -> stringResource(R.string.all)
                    "top" -> stringResource(R.string.top)
                    else -> ""
                }, when (filter) {
                    "all" -> ""
                    "top" -> ""
                    else -> "in " + filter!!
                }
            ),
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.padding(4.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            coursesStore.filter {
                when (filter) {
                    "all" -> true
                    "top" -> it.bestSeller
                    else -> it.category == filter
                }
            }.forEach {
                item {
                    FullCourseCard(
                        it,
                        modifier = Modifier.clickable { onClickCourse(it.id) }
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
            HomeBodyAll()
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
            HomeBodyAll()
        }
    }
}