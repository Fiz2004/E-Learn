package com.fiz.e_learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.fiz.e_learn.ui.theme.ELearnTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ELearnTheme {
                Surface {
                    ELearnApp(mainViewModel)
                }
            }
        }
    }
}

