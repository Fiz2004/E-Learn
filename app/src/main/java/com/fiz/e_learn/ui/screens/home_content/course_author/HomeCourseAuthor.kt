package com.fiz.e_learn.ui.screens.home_content.course_author

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.data.courses
import com.fiz.e_learn.ui.screens.home_content.course_more_info.CourseInfoItem
import com.fiz.e_learn.ui.screens.home_content.home_main.*
import com.fiz.e_learn.ui.screens.log_in.TextSubtitle1
import com.fiz.e_learn.ui.theme.*

@Composable
fun HomeCourseAuthorBody(
    id: Int?,
    onClickBuyNow: () -> Unit = { },
    onClickAddCart: () -> Unit = { },
) {
    val course = courses.find { it.id == id } ?: return
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.backgroundHome)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
    ) {
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            text = "About Instructor:",
            style = MaterialTheme.typography.h6,
        )
        
        Row(){
            Image(painter = painterResource(R.drawable.ic_author), contentDescription = null)
        }
        Column(){
            Row() {
                Text(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    text = "Stephen Moris",
                    style = MaterialTheme.typography.subtitle1,
                )
                TextBestSeller()
            }
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                text = "Top Rated Instructor",
                style = MaterialTheme.typography.subtitle1,
            )
            RatingRow(rating = 4.5)
        }

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            text = "The Lorem Ipsum generators on the Internets tend to repeat predefined chunks asks many till necessary,  of over 200 Latin offer words, It is a long combined established fact that a reader will be distracted by the readable content...",
            style = MaterialTheme.typography.subtitle1,
        )

        CourseInfoItem(R.drawable.ic_users,"250 Courses Uploaded")
        CourseInfoItem(R.drawable.ic_users,"Best Seller Award")
        CourseInfoItem(R.drawable.ic_users,"5+ Million Students Followed")

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            text = "OFFER PRICE : \$30.50 \$40.50",
            style = MaterialTheme.typography.subtitle1,
        )

        Row(){
            Button(modifier = Modifier
                .height(54.dp)
                .fillMaxWidth(),
                onClick = { onClickBuyNow() }) {
                TextSubtitle1(
                    text = "Buy Now",
                    color = Black_900,
                )
            }
            OutlinedButton(modifier = Modifier
                .height(54.dp)
                .fillMaxWidth(),
                onClick = { onClickAddCart() }) {
                TextSubtitle1(
                    text = "Add to Cart",
                    color = Black_900,
                )
            }
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
            HomeCourseAuthorBody(1)
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
            HomeCourseAuthorBody(1)
        }
    }
}