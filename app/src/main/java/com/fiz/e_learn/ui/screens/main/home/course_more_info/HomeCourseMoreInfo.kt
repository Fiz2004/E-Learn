package com.fiz.e_learn.ui.screens.main.home.course_more_info

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.domain.models.coursesStore
import com.fiz.e_learn.ui.theme.*
import org.threeten.bp.format.DateTimeFormatter

@Composable
fun HomeCourseMoreInfoBody(
    id: Int?,
    moveCourseAuthor: () -> Unit = { }
) {
    val course = coursesStore.find { it.id == id } ?: return

    val courseLengthHours = course.length.toInt().toString()
    val courseLengthMin = (course.length % 1).toInt().toString()

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
                Spacer(modifier = Modifier.height(26.dp))
                Text(
                    text = stringResource(R.string.more_info_curricullum),
                    style = MaterialTheme.typography.h6,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text =
                    stringResource(
                        id = R.string.more_info_count_lectures_length,
                        course.countLectures.toString(),
                        courseLengthHours,
                        courseLengthMin
                    ),
                    style = MaterialTheme.typography.body2,
                )

                Spacer(modifier = Modifier.height(8.dp))

                for ((index, episode) in course.structure.withIndex()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(
                                id = R.string.more_info_episode,
                                (index + 1).toString(),
                                episode.nameEpisode
                            ),
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    if (episode.description.isNotBlank()) {
                        Text(
                            text = episode.description,
                            style = MaterialTheme.typography.body2,
                            color=MaterialTheme.colors.onSurface2
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Spacer(modifier = Modifier.height(18.dp))
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(id = R.string.more_info_course_info),
            style = MaterialTheme.typography.h6,
        )

        Spacer(modifier = Modifier.height(8.dp))

        CourseInfoItem(
            R.drawable.ic_update,
            stringResource(
                id = R.string.more_info_last_updated,
                DateTimeFormatter.ofPattern("MMMM dd, yyyy").format(course.lastUpdate)
            )
        )

        CourseInfoItemWithClickedText(
            R.drawable.ic_users,
            stringResource(id = R.string.more_info_author),
            course.author,
            moveCourseAuthor
        )

        CourseInfoItem(R.drawable.ic_local, course.languages.joinToString())
    }
}

@Composable
fun CourseInfoItem(icon: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier.padding(start = 6.dp, end = 10.dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.greenText),
            painter = painterResource(
                id = icon
            ),
            contentDescription = null,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
        )
    }
}

@Composable
private fun CourseInfoItemWithClickedText(
    icon: Int,
    text: String,
    clickedText: String,
    moveCourseAuthor: () -> Unit = { }
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append(text)
            append(" ")
        }
        pushStringAnnotation(
            tag = "author",
            annotation = "author"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.greenText
            )
        ) {
            append(clickedText)
        }
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier.padding(start = 6.dp, end = 10.dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.greenText),
            painter = painterResource(
                id = icon
            ),
            contentDescription = null,
        )
        ClickableText(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            text = annotatedText,
            style = MaterialTheme.typography.body2,
            onClick = { offset ->

                annotatedText.getStringAnnotations(
                    tag = "author", start = offset,
                    end = offset
                )
                    .firstOrNull()?.let {
                        moveCourseAuthor()
                    }
            },
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_BODY_DP
)
@Composable
fun Preview() {
    ELearnTheme {
        Surface {
            HomeCourseMoreInfoBody(1)
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
fun DarkPreview() {
    ELearnTheme {
        Surface {
            HomeCourseMoreInfoBody(1)
        }
    }
}
