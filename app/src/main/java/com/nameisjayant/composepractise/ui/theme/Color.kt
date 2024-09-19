package com.nameisjayant.composepractise.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

// rgb
val rgbColor = Color(102, 80, 164)

// gradient color
val linearGradientColor = Brush.linearGradient(
    colors = listOf(
        Purple40,
        Pink40
    )
)

val radialGradientColor = Brush.radialGradient(
    colors = listOf(
        Purple40,
        Pink40
    )
)

val systemColor @Composable get() = if (isSystemInDarkTheme()) Purple80 else Purple40


val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

