package com.fiz.e_learn.ui.screens.main.home.home_main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.data.listCategories

@Composable
fun CategoriesChips(onClickCategory: (String) -> Unit) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        StaggeredGrid(rows = 2) {
            for (category in listCategories) {
                Chip(
                    modifier = Modifier
                        .padding(end = 8.dp, bottom = 8.dp)
                        .clickable { onClickCategory(category) },
                    text = category
                )
            }
        }
    }
}