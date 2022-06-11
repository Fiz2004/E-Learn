package com.fiz.e_learn.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.screens.sigin.TextSubtitle1
import com.fiz.e_learn.ui.theme.Black_900

@Composable
fun ELearnButton(
    text:Int,
    modifier: Modifier = Modifier,
    enabled:Boolean=true,
    onClick: () -> Unit = {}
) {

    Button(modifier = modifier
        .height(54.dp)
        .fillMaxWidth(),
        enabled = enabled,
        onClick = onClick) {
        TextSubtitle1(
            text = text,
            color = Black_900,
        )
    }
}

//
//@Preview(
//    showBackground = true,
//    widthDp = 375,
//    heightDp = 875
//)
//@Composable
//fun CreateAccountBodyPreview() {
//    ELearnTheme {
//        Surface {
//            CreateAccountButton()
//        }
//    }
//}
//
//@Preview(
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    widthDp = 375,
//    heightDp = 875
//)
//@Composable
//fun CreateAccountBodyDarkPreview() {
//    ELearnTheme {
//        Surface {
//            CreateAccountButton()
//        }
//    }
//}