package io.github.satoshun.example.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightThemeColors = lightColorScheme(
  primary = Slate800,
  onPrimary = Color.White,
  secondary = Orange700,
  onSecondary = Color.Black,
)

val DarkThemeColors = darkColorScheme(
  primary = Slate200,
  onPrimary = Color.Black,
  secondary = Orange500,
  onSecondary = Color.Black,
)

@Composable
fun AppTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  MaterialTheme(
    colorScheme = if (darkTheme) DarkThemeColors else LightThemeColors,
    content = content
  )
}
