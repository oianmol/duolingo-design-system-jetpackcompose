package dev.baseio.composeduolingo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

@Composable
fun DuolingoTheme(
  colors: Colors = DuolingoTheme.colors,
  content: @Composable () -> Unit
) {
  val rememberedColors = remember {
    // Explicitly creating a new object here so we don't mutate the initial [colors]
    // provided, and overwrite the values set in it.
    colors.copy()
  }.apply { updateColorsFrom(colors) }
  CompositionLocalProvider(
    LocalColors provides rememberedColors,
  ) {
    content()
  }
}

object DuolingoTheme {
  val colors: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
}