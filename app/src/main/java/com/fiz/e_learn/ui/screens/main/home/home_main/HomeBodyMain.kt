package com.fiz.e_learn.ui.screens.main.home.home_main

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.main.MainViewModel
import com.fiz.e_learn.ui.screens.main.home.home_main.components.Banner
import com.fiz.e_learn.ui.screens.main.home.home_main.components.CategoriesChips
import com.fiz.e_learn.ui.screens.main.home.home_main.components.TextH6WithSeeAll
import com.fiz.e_learn.ui.screens.main.home.home_main.components.TopCourses
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.HEIGHT_SCREEN_BODY_DP
import com.fiz.e_learn.ui.theme.WIDTH_SCREEN_DP
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun HomeBodyMain(
    viewModel: MainViewModel = viewModel(),
    moveSeeAllCategories: () -> Unit = { },
    moveCategory: (String) -> Unit = { },
    moveSeeAllTopCourses: () -> Unit = { },
    moveTopCourse: (Int) -> Unit = { }
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundHome)
            .verticalScroll(rememberScrollState())
            .padding(top = 32.dp),
    ) {

        Banner()

        Spacer(modifier = Modifier.height(16.dp))

        TextH6WithSeeAll(
            R.string.categories,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            moveSeeAllCategories = moveSeeAllCategories
        )

        Spacer(modifier = Modifier.height(14.dp))

        CategoriesChips(moveCategory)

        TopCourses(moveSeeAllTopCourses, moveTopCourse)
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
            HomeBodyMain()
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
            HomeBodyMain()
        }
    }
}