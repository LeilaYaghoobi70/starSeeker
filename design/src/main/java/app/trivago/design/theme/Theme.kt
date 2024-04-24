package app.trivago.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette =
    darkColorScheme(
        primary = PrimaryDark,
        secondary = SecondaryDark,
        background = BackgroundDark,
        onBackground = OnBackgroundDark,
        surface = SurfaceDark,
        error = Red40,
        onError = Red,
    )

private val LightColorPalette =
    lightColorScheme(
        primary = PrimaryLight,
        secondary = SecondaryLight,
        background = BackgroundLight,
        onBackground = OnBackgroundLight,
        error = Red40,
        onError = Red,
        surface = SurfaceLight,
        onSecondary = OnBackgroundLight,
    )

@Composable
fun StarSeekerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors =
        if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}
