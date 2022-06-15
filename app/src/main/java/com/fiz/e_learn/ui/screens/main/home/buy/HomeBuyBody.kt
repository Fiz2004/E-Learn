package com.fiz.e_learn.ui.screens.main.home.buy

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.ELearnButton
import com.fiz.e_learn.ui.screens.main.components.MainColumn
import com.fiz.e_learn.ui.screens.main.home.buy.components.DetailsCard
import com.fiz.e_learn.ui.screens.main.home.buy.components.TextHeaderWithOutlinedTextField
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun HomeBuyBody(
    moveInfoScreen: () -> Unit = {}
) {
    MainColumn {
        DetailsCard(
            modifier = Modifier
                .fillMaxWidth()
        )

        TextHeaderWithOutlinedTextField(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            textHeader = stringResource(R.string.buy_card_number),
            textHint = stringResource(R.string.buy_card_number_hint),
            trailingIcon = {
                Image(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(32.dp, 16.dp),
                    painter = painterResource(
                        id = R.drawable.pic_buy_visa
                    ),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        )

        TextHeaderWithOutlinedTextField(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            textHeader = stringResource(R.string.buy_name),
            textHint = stringResource(R.string.buy_name_hint)
        )

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextHeaderWithOutlinedTextField(
                modifier = Modifier
                    .weight(0.475f),
                textHeader = stringResource(R.string.buy_expiry_date),
                textHint = stringResource(R.string.buy_expiry_date_hint)
            )

            Spacer(modifier = Modifier.weight(0.05f))

            TextHeaderWithOutlinedTextField(
                modifier = Modifier
                    .weight(0.475f),
                textHeader = stringResource(R.string.buy_cvv),
                textHint = stringResource(R.string.buy_cvv_hint)
            )
        }

        ELearnButton(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(R.string.buy_pay_now)
        )
    }
}


@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 564
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
    heightDp = 564
)
@Composable
fun HomeBodyDarkPreview() {
    ELearnTheme {
        Surface {
            HomeBuyBody()
        }
    }
}