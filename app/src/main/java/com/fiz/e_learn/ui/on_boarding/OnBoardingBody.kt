package com.fiz.e_learn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiz.e_learn.ui.theme.ELearnTheme

@Composable
fun OnBoardingBody(
    onClickButton: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(color = Color(0xFF2A343C))
            .padding(bottom = 43.84.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = Color(0xFF1F272D))
        )
        Text(
            modifier = Modifier.padding(top = 44.72.dp, bottom = 13.41.dp),
            text = "Online Learning\n" +
                    "Platform",
            textAlign = TextAlign.Center,
            fontSize = 26.31.sp,
            fontFamily = FontFamily(Font(R.font.inter_semibold))
        )
        Text(
            modifier = Modifier
                .padding(start = 50.dp, end = 50.dp, bottom = 68.4.dp),
            textAlign = TextAlign.Center,
            text = "A handful of model sentence" +
                    " structures, too generate Lorem which" +
                    " looks reason able.",
            fontSize = 15.78.sp,
            fontFamily = FontFamily(Font(R.font.inter_light)),
            color = Color(0xFFCACCCE)
        )
        Box(modifier = Modifier
            .size(70.15.dp, 70.15.dp)
            .background(color = Color(0xFF3AFFDF))
            .align(alignment = Alignment.CenterHorizontally)
            .clickable { onClickButton() }) {
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 875)
@Composable
fun OnBoardingBodyPreview() {
    ELearnTheme {
        Surface {
            OnBoardingBody()
        }
    }
}