package com.fiz.e_learn.ui.screens.main.home.buy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.theme.greenText
import com.fiz.e_learn.ui.theme.surface2

@Composable
fun DetailsCard(
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colors.surface2,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 16.dp)
                .padding(vertical = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.buy_select_payment),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.pic_buy_visa
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(53.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(
                        id = R.drawable.pic_buy_pay_pal
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(53.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(
                        id = R.drawable.pic_buy_mastercard
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(53.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(
                        id = R.drawable.pic_buy_american_express
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(53.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_buy_plus
                ),
                contentDescription = null,
                tint = MaterialTheme.colors.greenText
            )
            Text(
                text = stringResource(R.string.buy_add_new_card).uppercase(),
                textDecoration = TextDecoration.Underline,
                color = MaterialTheme.colors.greenText
            )
        }
    }
}