package com.fiz.e_learn.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.ELearnTheme

data class Course(val name:String, val img:Int, val rating:Double)

@Composable
fun HomeBody(navController: NavController? = null) {
    val listCategories = listOf(
        "Design",
        "Development",
        "Business",
        "Music",
        "It & Software",
        "Health@Fitness",
        "Business",
        "Design",
        "Development",
        "Business",
        "Music",
        "It & Software",
        "Health@Fitness",
        "Business",
    )
    val courses = listOf(
        Course("Generator on there Internet tend", R.drawable.card1,4.5),
        Course("Generator on there Internet tend", R.drawable.card2,2.5),
        Course("Generator on there Internet tend", R.drawable.card1,3.5),
        Course("Generator on there Internet tend", R.drawable.card2,1.5),
        Course("Generator on there Internet tend", R.drawable.card1,2.0),
        Course("Generator on there Internet tend", R.drawable.card2,1.5),
        Course("Generator on there Internet tend", R.drawable.card1,5.0),

    )
    Column(
        modifier = Modifier
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
            Row() {
                Text("Categories")
                Spacer(modifier = Modifier.weight(1f))
                Text("SEE ALL")
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_search
                    ),
                    contentDescription = null,
                )
            }
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
            Row() {
                Text("Top Courses")
                Spacer(modifier = Modifier.weight(1f))
                Text("SEE ALL")
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_search
                    ),
                    contentDescription = null,
                )
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                courses.forEach {
                    item { CourseCard(it) }
                }
            }
        }
    }
}

//    Button(onClick = {  }) {
//        Text(text = "Home")
//    }


@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 875
)
@Composable
fun HomeBodyPreview() {
    ELearnTheme {
        Surface {
            HomeBody()
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
            HomeBody()
        }
    }
}