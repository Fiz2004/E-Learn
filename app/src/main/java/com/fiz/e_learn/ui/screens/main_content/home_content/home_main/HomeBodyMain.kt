package com.fiz.e_learn.ui.screens.main_content.home_content.home_main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.main_content.home_content.home_main.components.Banner
import com.fiz.e_learn.ui.screens.main_content.home_content.home_main.components.CategoriesChips
import com.fiz.e_learn.ui.screens.main_content.home_content.home_main.components.TextH6WithSeeAll
import com.fiz.e_learn.ui.screens.main_content.home_content.home_main.components.TopCourses
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
            .background(MaterialTheme.colors.surface)
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
