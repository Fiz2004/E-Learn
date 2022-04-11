package com.fiz.e_learn

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeContentBody(
    onClickButton :()->Unit={}
){
    Button(onClick = { onClickButton() }) {
        Text(text = "Go Favorities")
    }
}