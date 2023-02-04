package com.scouting.app.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.scouting.app.R

val Inter = FontFamily(
    Font(resId = R.font.inter_bold, weight = FontWeight.Bold),
    Font(resId = R.font.inter_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.inter_medium, weight = FontWeight.Medium),
    Font(resId = R.font.inter_regular, weight = FontWeight.Normal),
    Font(resId = R.font.inter_light, weight = FontWeight.Thin)
)

@Composable
fun typography() = Typography(
    /**
     *
    h1 = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = dimensionResource(id = R.dimen.h1_text_size).value.sp,
    letterSpacing = (-1).sp
    ),
    h2 = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = dimensionResource(id = R.dimen.h2_text_size).value.sp
    ),
    h3 = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = dimensionResource(id = R.dimen.h3_text_size).value.sp
    ),
    h4 = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = dimensionResource(id = R.dimen.h4_text_size).value.sp
    ),
    h5 = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = dimensionResource(id = R.dimen.h5_text_size).value.sp
    ),
    h6 = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 25.sp
    ),**/

    displayLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp,
        letterSpacing = (-1).sp
    ),
    displayMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 50.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 35.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 30.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 25.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /**
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = dimensionResource(id = R.dimen.subtitle1_text_size).value.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = dimensionResource(id = R.dimen.subtitle2_text_size).value.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = dimensionResource(id = R.dimen.body1_text_size).value.sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = dimensionResource(id = R.dimen.body2_text_size).value.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = dimensionResource(id = R.dimen.button_text_size).value.sp
    )
    **/
)