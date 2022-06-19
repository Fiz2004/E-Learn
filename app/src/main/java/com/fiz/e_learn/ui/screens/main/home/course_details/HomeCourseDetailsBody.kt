package com.fiz.e_learn.ui.screens.main.home.course_details

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.fiz.e_learn.R
import com.fiz.e_learn.domain.models.coursesStore
import com.fiz.e_learn.ui.screens.main.home.home_main.components.IconSeeAll
import com.fiz.e_learn.ui.screens.main.home.home_main.components.TextSeeAll
import com.fiz.e_learn.ui.theme.*

@Composable
fun HomeCourseDetailsBody(
    id: Int?,
    moveCourseMoreInfo: () -> Unit = { }
) {
    val course = coursesStore.find { it.id == id } ?: return
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.backgroundHome)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(26.dp),
            backgroundColor = MaterialTheme.colors.surface2
        ) {
            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                Spacer(modifier = Modifier.height(26.dp))
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(id = R.string.details_will_learn),
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
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = stringResource(id = R.string.details_description),
            style = MaterialTheme.typography.h6,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier,
            text = course.description,
            style = MaterialTheme.typography.body2.copy(
                lineHeight = 22.sp
            ),
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            TextSeeAll(moveCourseMoreInfo)
            IconSeeAll()
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
            HomeCourseDetailsBody(1)
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
            HomeCourseDetailsBody(1)
        }
    }
}
