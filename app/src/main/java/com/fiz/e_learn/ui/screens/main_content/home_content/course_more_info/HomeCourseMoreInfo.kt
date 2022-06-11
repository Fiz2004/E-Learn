package com.fiz.e_learn.ui.screens.main_content.home_content.course_more_info

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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.data.courses
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome
import com.fiz.e_learn.ui.theme.greenText
import com.fiz.e_learn.ui.theme.surface2

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
            Column {
                Text(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    text = "Curricullum:",
                    style = MaterialTheme.typography.h6,
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    text = "${course.countLectures} Lectures   /   ${course.length.toInt()}h ${course.length % 1}min Length",
                    style = MaterialTheme.typography.body2,
                )

                for ((index, episode) in course.structure.withIndex()) {
                    Row(
                        modifier = Modifier.padding(bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 12.dp),
                            text = "Episode ${index + 1} - ",
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            modifier = Modifier.padding(start = 12.dp),
                            text = episode.nameEpisode,
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    if (episode.description.isNotBlank()) {
                        Text(
                            modifier = Modifier.padding(start = 12.dp, bottom = 8.dp),
                            text = episode.description,
                            style = MaterialTheme.typography.body2,
                        )
                    }
                }
            }
        }

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            text = "Course Info:",
            style = MaterialTheme.typography.h6,
        )

//        CourseInfoItem(R.drawable.ic_update,"Last Updated on ${
//            DateTimeFormatter.ofPattern("MMMM dd, yyyy").format(course.lastUpdate)}")
        CourseInfoItemWithClickedText(
            R.drawable.ic_users,
            "Author : ",
            "${course.author}",
            onClickAuthor
        )
        CourseInfoItem(R.drawable.ic_local, "English, French")
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
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
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
    onClickAuthor: () -> Unit = { }
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
                    tag = "sign up", start = offset,
                    end = offset
                )
                    .firstOrNull()?.let {
                        onClickAuthor()
                    }
            },
        )
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