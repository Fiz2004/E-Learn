package com.fiz.e_learn.ui.screens.home_content.home_main

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.home_content.home_main.components.Banner
import com.fiz.e_learn.ui.screens.home_content.home_main.components.CategoriesChips
import com.fiz.e_learn.ui.screens.home_content.home_main.components.TextH6WithSeeAll
import com.fiz.e_learn.ui.screens.home_content.home_main.components.TopCourses
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome

@Composable
fun HomeBodyMain(
    onClickCategoriesSeeAll: () -> Unit = { },
    onClickCategory: (String) -> Unit = { },
    onClickCoursesSeeAll: () -> Unit = { },
    onClickCourse: (Int) -> Unit = { }
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundHome)
            .verticalScroll(rememberScrollState())
            .padding(top = 32.dp),
    ) {

        Banner()

        Spacer(modifier = Modifier.padding(8.dp))

        TextH6WithSeeAll(
            R.string.categories,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            onClickSeeAll = onClickCategoriesSeeAll
        )

        Spacer(modifier = Modifier.padding(8.dp))

        CategoriesChips(onClickCategory)

        TopCourses(onClickCoursesSeeAll, onClickCourse)
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
            HomeBodyMain()
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
            HomeBodyMain()
        }
    }
}