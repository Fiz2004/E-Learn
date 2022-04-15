package com.fiz.e_learn.ui.screens.home_content.home_main

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.White
import com.fiz.e_learn.ui.theme.backgroundHome
import com.fiz.e_learn.ui.theme.greenText

@Composable
fun HomeBodyMain(onClickCategoriesSeeAll: () -> Unit = { },
                 onClickCategory: (String) -> Unit = { },
                 onClickCoursesSeeAll: () -> Unit = { },
                 onClickCourse: (Int) -> Unit = { }) {
    Column(
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundHome),
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
        ) {
            Box(
                modifier = Modifier
                    .height(158.dp)
                    .fillMaxWidth()
                    .align(CenterHorizontally),
                contentAlignment = CenterEnd
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.banner
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(28.dp)),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .widthIn(max = 126.dp)
                ) {
                    Text(
                        text = "A Real-World\n" + "Experience!!!",
                        style = MaterialTheme.typography.h6,
                        color = White
                    )

                    Spacer(modifier = Modifier.padding(12.dp))

                    Row(
                        modifier = Modifier.clickable { },
                        verticalAlignment = CenterVertically
                    ) {
                        Text(
                            text = "Explore",
                            color = MaterialTheme.colors.greenText,
                            textDecoration = TextDecoration.Underline
                        )
                        IconSeeAll()
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        TextH6WithSeeAll(
            R.string.categories,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            onClickSeeAll = onClickCategoriesSeeAll
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            modifier = Modifier
                .padding(start = 16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            StaggeredGrid(rows = 2) {
                for (category in listCategories) {
                    Chip(
                        modifier = Modifier.padding(end = 8.dp, bottom = 8.dp).clickable { onClickCategory(category) },
                        text = category
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(4.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
        ) {

            TextH6WithSeeAll(R.string.top_courses, onClickSeeAll = onClickCoursesSeeAll)

            Spacer(modifier = Modifier.padding(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(courses.filter{it.bestSeller}.windowed(2, 2, true)) { item ->
                    Row {
                        CourseCard(item[0],modifier = Modifier.weight(0.475f).clickable { onClickCourse(item[0].id) })
                        Spacer(Modifier.weight(0.05f))
                        item.getOrNull(1)?.let {
                            CourseCard(it,modifier = Modifier.weight(0.475f).clickable { onClickCourse(item[0].id) })
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TextH6WithSeeAll(text: Int, modifier: Modifier = Modifier, onClickSeeAll: () -> Unit) {
    Row(
        modifier = modifier,
        verticalAlignment = CenterVertically
    ) {
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
fun IconSeeAll(modifier:Modifier=Modifier) {
    Image(
        modifier = modifier.padding(start=6.dp),
        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.greenText),
        painter = painterResource(
            id = R.drawable.ic_see_all
        ),
        contentDescription = null,
    )
}

@Composable
fun TextSeeAll(onClickSeeAll: () -> Unit) {
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