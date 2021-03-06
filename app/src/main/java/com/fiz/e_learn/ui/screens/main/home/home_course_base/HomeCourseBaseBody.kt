package com.fiz.e_learn.ui.screens.main.home.home_course_base

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.fiz.e_learn.R
import com.fiz.e_learn.domain.models.coursesStore
import com.fiz.e_learn.ui.screens.main.home.home_main.components.RatingRow
import com.fiz.e_learn.ui.screens.main.home.home_main.components.TextBestSeller
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome
import com.fiz.e_learn.ui.theme.greenText
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

@Composable
fun HomeCourseBaseBody(
    id: Int?,
    moveCourseDetails: () -> Unit = { }
) {
    val course = coursesStore.find { it.id == id } ?: return
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.backgroundHome)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
    ) {

        Row {
            Text(
                text = course.name,
                style = MaterialTheme.typography.h6
            )
            if (course.bestSeller)
                TextBestSeller(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row {
            RatingRow(course.rating)

            Text(
                text = stringResource(
                    id = R.string.base_ratings_students,
                    course.countVoted.toString(),
                    course.allVoted.toString()
                ),
                style = MaterialTheme.typography.caption
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = course.annotation,
            style = MaterialTheme.typography.body2,
            letterSpacing = 1.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = stringResource(id=R.string.base_read_more),
            color = MaterialTheme.colors.greenText,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.clickable { moveCourseDetails() }
        )

        Spacer(modifier = Modifier.height(14.dp))

        VideoPlayer()

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            text = stringResource(id=R.string.base_this_course_include),
            style = MaterialTheme.typography.body2,
        )

        for (include in course.includes)
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
                    text = include,
                    style = MaterialTheme.typography.body2,
                )
            }
    }
}

@Composable
fun VideoPlayer() {
    // This is the official way to access current context from Composable functions
    val context = LocalContext.current

    // Do not recreate the player everytime this Composable commits
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {

            val dataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(
                context,
                DefaultHttpDataSource.Factory().setAllowCrossProtocolRedirects(true)
            )

            val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(
                    MediaItem.fromUri(
                        // Big Buck Bunny from Blender Project
                        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                    )
                )

            this.setMediaSource(source)
        }
    }

    AndroidView(
        modifier = Modifier.height(158.dp),
        factory = { context ->
            StyledPlayerView(context).apply {
                player = exoPlayer
            }
        }
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
            HomeCourseBaseBody(1)
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
            HomeCourseBaseBody(1)
        }
    }
}