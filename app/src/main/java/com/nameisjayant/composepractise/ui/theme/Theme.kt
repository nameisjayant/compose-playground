package com.nameisjayant.composepractise.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Immutable
data class CustomColors(
    val primaryColor: Color = Color.Black,
    val secondaryColor: Color = Color.Red
)

@Immutable
data class CustomTypography(
    val style: TextStyle = TextStyle(
        fontSize = 18.sp
    )
)

val LocalCustomColor = staticCompositionLocalOf { CustomColors() }
val LocalCustomTypography = staticCompositionLocalOf { CustomTypography() }


object CustomTheme {

    val customColors @Composable get() = LocalCustomColor.current
    val customTypography @Composable get() = LocalCustomTypography.current
}

@Composable
fun CustomComposeTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalCustomColor provides CustomTheme.customColors,
        LocalCustomTypography provides CustomTheme.customTypography
    ) {
        content()
    }
}


@Composable
fun ComposePractiseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}