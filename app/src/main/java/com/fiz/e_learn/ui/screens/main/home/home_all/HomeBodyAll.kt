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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.domain.models.coursesStore
import com.fiz.e_learn.ui.screens.main.MainViewModel
import com.fiz.e_learn.ui.screens.main.components.FullCourseCard
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.HEIGHT_SCREEN_BODY_DP
import com.fiz.e_learn.ui.theme.WIDTH_SCREEN_DP
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun HomeBodyAll(
    viewModel: MainViewModel = viewModel(),
    filter: String? = "all",
    moveCourse: (Int) -> Unit = { }
) {
    val state = viewModel.viewState

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
                    "all" -> stringResource(R.string.all_all)
                    "top" -> stringResource(R.string.all_top)
                    else -> ""
                }, when (filter) {
                    "all" -> ""
                    "top" -> ""
                    else -> stringResource(R.string.all_in_category,filter!!)
                }
            ),
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.height(12.dp))

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
            }.filter { it.name.lowercase().contains(state.search.lowercase()) }.forEach {
                item {
                    FullCourseCard(
                        it,
                        modifier = Modifier.clickable { moveCourse(it.id) }
                    )
                }
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
            HomeBodyAll()
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
            HomeBodyAll()
        }
    }
}