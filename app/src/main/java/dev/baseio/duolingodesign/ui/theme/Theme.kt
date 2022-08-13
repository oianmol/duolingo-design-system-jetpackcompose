package dev.baseio.duolingodesign.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import dev.baseio.composeduolingo.Colors
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
    colors = colors,
    content = content
  )
}

val DarkColorPalette = Colors(background = Color.Black, false)
val LightColorPalette = Colors(background = Color.White, false)