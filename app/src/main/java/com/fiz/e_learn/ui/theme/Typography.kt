package com.fiz.e_learn.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fiz.e_learn.R
    private val Inter = FontFamily(
        Font(R.font.inter_regular),
        Font(R.font.inter_light, FontWeight.Light),
        Font(R.font.inter_medium, FontWeight.W500),
        Font(R.font.inter_semibold, FontWeight.W600)
    )

    private val ZillaSlab = FontFamily(
        Font(R.font.zillaslab_regular),
        Font(R.font.zillaslab_bold, FontWeight.Bold)
    )

    val ELearnTypography = Typography(
        h5 = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.W600,
            fontSize = 24.sp
        ),
        subtitle1 = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        ),
        subtitle2 = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Light,
            fontSize = 14.sp
        ),
        overline = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.W600,
            fontSize = 10.sp
        ),
        caption = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        ),


        h6 = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.W600,
            fontSize = 20.sp
        ),
        body1 = TextStyle(
            fontFamily = ZillaSlab,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        body2 = TextStyle(
            fontFamily = Inter,
            fontSize = 14.sp
        ),
        button = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
    )
