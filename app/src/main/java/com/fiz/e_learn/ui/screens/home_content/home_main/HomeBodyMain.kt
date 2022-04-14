package com.fiz.e_learn.ui.screens.home_content.home_main

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun HomeBodyMain(navController: NavController? = null, onClickSeeAll: () -> Unit = { }) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundHome)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.banner
            ),
            contentDescription = null,
            modifier = Modifier
                .height(158.dp)
                .fillMaxWidth()
                .align(CenterHorizontally),
            contentScale = ContentScale.Crop
        )

        Column() {
            TextH6WithSeeAll(R.string.categories,onClickSeeAll)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                StaggeredGrid(rows = 2) {
                    for (category in listCategories) {
                        Chip(
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 16.dp),
                            text = category
                        )
                    }
                }
            }
        }

        Column() {
            TextH6WithSeeAll(R.string.top_courses,onClickSeeAll)
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(courses.windowed(2, 2, true)) { item ->
                    Row() {
                        CourseCard(item[0])
                        Spacer(Modifier.weight(1f))
                        item.getOrNull(1)?.let {
                            CourseCard(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TextH6WithSeeAll(text:Int,onClickSeeAll: () -> Unit) {
    Row(verticalAlignment = CenterVertically) {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.weight(1f))
        TextSeeAll(onClickSeeAll)
        IconSeeAll()
    }
}

@Composable
private fun IconSeeAll(modifier:Modifier=Modifier) {
    Image(
        modifier = modifier,
        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.greenText),
        painter = painterResource(
            id = R.drawable.ic_see_all
        ),
        contentDescription = null,
    )
}

@Composable
private fun TextSeeAll(onClickSeeAll: () -> Unit) {
    Text(
        color = MaterialTheme.colors.greenText,
        text = stringResource(R.string.see_all),
        style = MaterialTheme.typography.caption,
        modifier = Modifier.clickable { onClickSeeAll() }
    )
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