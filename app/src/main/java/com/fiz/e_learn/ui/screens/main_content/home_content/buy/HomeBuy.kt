package com.fiz.e_learn.ui.screens.main_content.home_content.buy

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.ELearnButton
import com.fiz.e_learn.ui.screens.sigin.TextSubtitle1
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.backgroundHome
import com.fiz.e_learn.ui.theme.greenText
import com.fiz.e_learn.ui.theme.surface2

@Composable
fun HomeBuyBody(
    onClickPayNow: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.backgroundHome)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
    ) {
        CardCourse()

        Spacer(modifier = Modifier.padding(8.dp))

        CardCourse()

        Spacer(modifier = Modifier.padding(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            backgroundColor = MaterialTheme.colors.surface2
        ) {
            Row {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                    text = "Coupon Code",
                    style = MaterialTheme.typography.body2
                )

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    modifier = Modifier
                        .height(54.dp)
                        .width(130.dp),
                    onClick = {}) {
                    TextSubtitle1("APPLY NOW")
                }
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Row {
            Text(
                text = "Subtotal",
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "\$40.95",
                style = MaterialTheme.typography.subtitle1
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Row {
            Text(
                text = "Shipping",
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Free",
                style = MaterialTheme.typography.subtitle1
            )
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Row {
            Text(
                text = "Total",
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "\$40.95",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.greenText
            )
        }

        Spacer(modifier = Modifier.padding(32.dp))

        ELearnButton(stringResource(id = R.string.proceed_to_checkout))
    }
}

@Composable
private fun CardCourse() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        backgroundColor = MaterialTheme.colors.surface2
    ) {
        Row(
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colors.surface2)
                .padding(start = 8.dp, top = 16.dp, bottom = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.card1
                ),
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .size(53.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(
                modifier = Modifier
                    .weight(0.05f)
                    .defaultMinSize(minWidth = 22.dp)
            )

            Column(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .weight(0.5f)
            ) {
                Text(
                    text = "Get Started with Python",
                    style = MaterialTheme.typography.subtitle1,
                )
                Text(
                    text = "\$40.95",
                    color = MaterialTheme.colors.greenText,
                    style = MaterialTheme.typography.h6,
                )

            }

            Spacer(
                modifier = Modifier
                    .weight(0.05f)
                    .defaultMinSize(minWidth = 22.dp)
            )

            Card(
                modifier = Modifier
                    .height(72.dp)
                    .width(40.dp),
                border = BorderStroke(2.dp, MaterialTheme.colors.greenText),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = MaterialTheme.colors.surface2
            ) {
                Column(
                    modifier = Modifier.padding(2.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "-",
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Text(
                        text = "1",
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Text(
                        text = "+",
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
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
            HomeBuyBody()
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
            HomeBuyBody()
        }
    }
}