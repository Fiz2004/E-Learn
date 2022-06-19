package com.fiz.e_learn.ui.screens.main.home.cart

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.ELearnButton
import com.fiz.e_learn.ui.screens.main.components.MainColumn
import com.fiz.e_learn.ui.screens.sigin.TextSubtitle1
import com.fiz.e_learn.ui.theme.*

@Composable
fun HomeCartBody(
    moveBuyScreen: () -> Unit = {}
) {
    MainColumn {
        CardCourse("Get Started with Python", "\$40.95", modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(8.dp))

        CardCourse("Get Started with Python", "\$40.95", modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            backgroundColor = MaterialTheme.colors.surface2
        ) {
            Row(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp),
                    contentAlignment = Center
                ) {
                    Text(
                        text = stringResource(R.string.cart_coupon_code),
                        style = MaterialTheme.typography.body2,
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(130.dp),
                    onClick = {}) {
                    TextSubtitle1(stringResource(R.string.cart_apply_now))
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        Row {
            Text(
                text = stringResource(R.string.cart_subtotal),
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "\$40.95",
                style = MaterialTheme.typography.subtitle1
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text(
                text = stringResource(R.string.cart_shipping),
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(R.string.cart_free),
                style = MaterialTheme.typography.subtitle1
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Text(
                text = stringResource(R.string.total),
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "\$40.95",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.greenText
            )
        }

        Spacer(modifier = Modifier.height(38.dp))

        ELearnButton(stringResource(id = R.string.proceed_to_checkout), onClick = moveBuyScreen)

        Spacer(modifier = Modifier.height(40.dp))
    }
}


@Composable
private fun CardCourse(
    text: String,
    price: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.surface2,
                shape = RoundedCornerShape(14.dp)
            )
            .padding(vertical = 24.dp)
            .padding(start = 8.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.card1),
            contentDescription = null,
            modifier = Modifier
                .size(52.dp)
                .clip(shape = RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column() {
            Text(
                text = text,
                style = MaterialTheme.typography.subtitle1,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = price,
                color = MaterialTheme.colors.greenText,
                style = MaterialTheme.typography.h6,
            )

        }

        Spacer(
            modifier = Modifier
                .weight(1f)
                .defaultMinSize(minWidth = 22.dp)
        )

        val count = remember { mutableStateOf(1) }
        Quantity(count = count.value.toString(),
            minusClicked = { count.value-- },
            plusClicked = { count.value++ })
    }
}

@Composable
fun Quantity(
    count: String,
    minusClicked: () -> Unit = {},
    plusClicked: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .height(72.dp)
            .width(40.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.greenText),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface2
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .clickable { minusClicked() },
                text = "-",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = count,
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                modifier = Modifier
                    .clickable { plusClicked() },
                text = "+",
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = WIDTH_SCREEN_DP,
    heightDp = HEIGHT_SCREEN_BODY_DP
)
@Composable
fun HomeCartPreview() {
    ELearnTheme {
        Surface {
            HomeCartBody()
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
fun HomeCartDarkPreview() {
    ELearnTheme {
        Surface {
            HomeCartBody()
        }
    }
}