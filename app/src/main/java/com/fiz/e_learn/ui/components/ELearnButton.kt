package com.fiz.e_learn.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.screens.sigin.TextSubtitle1
import com.fiz.e_learn.ui.theme.Black_900
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun ELearnButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier
            .height(52.dp)
            .fillMaxWidth(),
        enabled = enabled,
        onClick = onClick,
        shape = RoundedCornerShape(18.dp)
    ) {
        TextSubtitle1(
            text = text,
            color = Black_900,
        )
    }
}


@Preview(
    showBackground = true,
    widthDp = 375,
    heightDp = 875
)
@Composable
fun CreateAccountBodyPreview() {
    ELearnTheme {
        Surface {
            ELearnButton("Test")
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
fun CreateAccountBodyDarkPreview() {
    ELearnTheme {
        Surface {
            ELearnButton("Test")
        }
    }
}