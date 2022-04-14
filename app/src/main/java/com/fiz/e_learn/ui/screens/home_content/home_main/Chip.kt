package com.fiz.e_learn.ui.screens.home_content.home_main

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.theme.ELearnTheme
import com.fiz.e_learn.ui.theme.border

@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
    Card(
        modifier = modifier.height(44.dp).background(color=MaterialTheme.colors.surface),
        border = BorderStroke(color = MaterialTheme.colors.border, width = 1.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = text)
        }
    }
}


@Preview(
    showBackground = true,
    widthDp = 158,
    heightDp = 168
)
@Composable
fun ChipPreview() {
    ELearnTheme {
        Surface {
            Chip(text="Test")
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 158,
    heightDp = 168
)
@Composable
fun ChipDarkPreview() {
    ELearnTheme {
        Surface {
            Chip(text="Test")
        }
    }
}