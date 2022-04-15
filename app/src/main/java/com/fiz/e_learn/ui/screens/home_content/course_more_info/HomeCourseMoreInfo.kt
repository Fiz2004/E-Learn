package com.fiz.e_learn.ui.screens.home_content.course_more_info

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.screens.home_content.home_course_base.HomeCourseBaseBody
import com.fiz.e_learn.ui.screens.home_content.home_main.*
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome
import com.fiz.e_learn.ui.theme.greenText
import com.fiz.e_learn.ui.theme.surface2
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

@Composable
fun HomeCourseMoreInfoBody(
    id: Int?,
    onClickAuthor: () -> Unit = { }
) {
    val course = courses.find { it.id == id } ?: return
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
            Column() {
                Text(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    text = "Curricullum:",
                    style = MaterialTheme.typography.body2,
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    text = "179 Lectures   /   20h 4min Length",
                    style = MaterialTheme.typography.body2,
                )

                for ((index,episode) in course.structure.withIndex())
                    Row(
                        modifier = Modifier.padding(bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 12.dp),
                            text = "Episode $index - ",
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            modifier = Modifier.padding(start = 12.dp),
                            text = episode,
                            style = MaterialTheme.typography.body2,
                        )
                    }
            }
        }

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            text = "Course Info:",
            style = MaterialTheme.typography.body2,
        )

        Row() {
            Image(
                modifier = Modifier.padding(start=6.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.greenText),
                painter = painterResource(
                    id = R.drawable.ic_account
                ),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                text = "Last Updated on June 02, 2021",
                style = MaterialTheme.typography.body2,
            )
        }
        Row() {
            Image(
                modifier = Modifier.padding(start=6.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.greenText),
                painter = painterResource(
                    id = R.drawable.ic_account
                ),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    .clickable { onClickAuthor() },
                text = "Author : Stephen Moris",
                style = MaterialTheme.typography.body2,
            )
        }
        Row() {
            Image(
                modifier = Modifier.padding(start=6.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.greenText),
                painter = painterResource(
                    id = R.drawable.ic_account
                ),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                text = "English, French",
                style = MaterialTheme.typography.body2,
            )
        }

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
            HomeCourseMoreInfoBody(1)
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
            HomeCourseMoreInfoBody(1)
        }
    }
}