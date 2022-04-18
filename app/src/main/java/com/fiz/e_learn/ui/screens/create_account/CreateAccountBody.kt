package com.fiz.e_learn.ui.screens.create_account

import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.fiz.e_learn.R
import com.fiz.e_learn.ui.components.*
import com.fiz.e_learn.ui.screens.create_account.components.*

@Composable
fun CreateAccountBody(
    viewModel: CreateAccountViewModel,
    onClickTermsOfServices: () -> Unit = {},
    onClickPrivacyPolicy: () -> Unit = {},
    onClickCreateAccount: () -> Unit = {},
    onClickSignIn: () -> Unit = {},
) {
    val context = LocalContext.current

    BaseContainerForLogInGroup {
        BaseIconForLogInGroup(R.drawable.ic_people, 48.dp, 32.dp)

        Spacer(modifier = Modifier.padding(12.dp))

        TextH5(R.string.create_account)

        Spacer(modifier = Modifier.padding(4.dp))

        TextSubtitle2(R.string.create_account_description)

        Spacer(modifier = Modifier.padding(20.dp))

        UserNameTextField()

        Spacer(modifier = Modifier.padding(12.dp))

        EmailTextField(text=viewModel.emailId, textChange = {emailId->viewModel.newEmailId(emailId)})

        Spacer(modifier = Modifier.padding(12.dp))

        PasswordFingerPrintTextField(text=viewModel.password, textChange = {password->viewModel.newPassword(password)})

        Spacer(modifier = Modifier.padding(8.dp))

        TextPrivacy(
            onClickTermsOfServices = onClickTermsOfServices,
            onClickPrivacyPolicy = onClickPrivacyPolicy
        )

        Spacer(modifier = Modifier.padding(8.dp))

        ELearnButton("Create account",enabled=viewModel.isCreateAccountButtonEnabled(),onClick = {

            if (viewModel.clickCreateAccount())
                onClickCreateAccount()
            else
                Toast.makeText(context, "Error Create Account", Toast.LENGTH_SHORT).show()
        })

        Spacer(modifier = Modifier.padding(8.dp))

        SignInText(onClickSignIn)

    }
}

//@Preview(
//    showBackground = true,
//    widthDp = 375,
//    heightDp = 875
//)
//@Composable
//fun CreateAccountBodyPreview() {
//    ELearnTheme {
//        Surface {
//            CreateAccountBody()
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
//            CreateAccountBody()
//        }
//    }
//}