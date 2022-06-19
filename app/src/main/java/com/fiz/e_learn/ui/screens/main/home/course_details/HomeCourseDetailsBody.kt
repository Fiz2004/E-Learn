package com.fiz.e_learn.ui.screens.main.home.course_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.domain.models.coursesStore
import com.fiz.e_learn.ui.screens.main.home.home_main.components.IconSeeAll
import com.fiz.e_learn.ui.screens.main.home.home_main.components.TextSeeAll
import com.fiz.e_learn.ui.theme.backgroundHome
import com.fiz.e_learn.ui.theme.greenText
import com.fiz.e_learn.ui.theme.surface2

@Composable
fun HomeCourseDetailsBody(
    id: Int?,
    onClickSeeAll: () -> Unit = { }
) {
    val course = coursesStore.find { it.id == id } ?: return
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.backgroundHome)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            backgroundColor = MaterialTheme.colors.surface2
        ) {
            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "What will you learn:",
                    style = MaterialTheme.typography.h6,
                )

                for (will in course.willLearn)
                    Row(
                        modifier = Modifier.padding(bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.ic_ring
                            ),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.greenText),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            modifier = Modifier.padding(start = 12.dp),
                            text = will,
                            style = MaterialTheme.typography.body2,
                        )
                        Spacer(modifier = Modifier.padding(bottom = 8.dp))
                    }
            }
        }

        Spacer(modifier = Modifier.padding(bottom = 8.dp))

        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Description:",
            style = MaterialTheme.typography.h6,
        )

        Spacer(modifier = Modifier.padding(bottom = 8.dp))

        Text(
            modifier = Modifier,
            text = course.description,
            style = MaterialTheme.typography.body2,
        )

        Spacer(modifier = Modifier.padding(bottom = 8.dp))

        Row {
            TextSeeAll(onClickSeeAll)
            IconSeeAll()
        }
    }
}