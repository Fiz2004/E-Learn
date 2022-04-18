package com.fiz.e_learn.ui.screens.create_account.components

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.ui.screens.create_account.CreateAccountViewModel
import com.fiz.e_learn.ui.screens.log_in.TextSubtitle1
import com.fiz.e_learn.ui.theme.Black_900

@Composable
fun CreateAccountButton(
    modifier: Modifier = Modifier,
    viewModel: CreateAccountViewModel,
    onClickCreateAccount: () -> Unit = {}
) {

    val context = LocalContext.current

    Button(modifier = modifier
        .height(54.dp)
        .fillMaxWidth(),
        enabled = viewModel.isCreateAccountButtonEnabled(),
        onClick = {
            if (viewModel.clickCreateAccount())
                onClickCreateAccount()
            else
                Toast.makeText(context, "Error Create Account", Toast.LENGTH_SHORT).show()
        }) {

        TextSubtitle1(
            text = "Create account",
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