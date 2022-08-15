package dev.baseio.duolingodesign.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.baseio.composeduolingo.DuolingoColors
import dev.baseio.composeduolingo.DuolingoTheme

@Composable
fun DuolingoComposeUITheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }

  DuolingoTheme(
    duolingoColors = colors,
    content = content
  )
}

val DarkColorPalette = DuolingoColors(background = Color.Black, isLight = false, contentColor = Color.White)
val LightColorPalette = DuolingoColors(background = Color.White, isLight = false, contentColor = Color.Black)