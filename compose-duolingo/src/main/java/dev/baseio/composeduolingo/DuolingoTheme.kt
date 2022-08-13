package dev.baseio.composeduolingo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

@Composable
fun DuolingoTheme(
  duolingoColors: DuolingoColors = DuolingoTheme.duolingoColors,
  content: @Composable () -> Unit
) {
  val rememberedColors = remember {
    // Explicitly creating a new object here so we don't mutate the initial [colors]
    // provided, and overwrite the values set in it.
    duolingoColors.copy()
  }.apply { updateColorsFrom(duolingoColors) }
  CompositionLocalProvider(
    LocalColors provides rememberedColors,
  ) {
    content()
  }
}

object DuolingoTheme {
  val duolingoColors: DuolingoColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
}