package dev.baseio.composeduolingo

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

class DuolingoColors(
  background: Color,
  contentColor: Color,
  surface: Color = background,
  isLight: Boolean
) {
  var background by mutableStateOf(background, structuralEqualityPolicy())
    internal set
  var surface by mutableStateOf(surface, structuralEqualityPolicy())
    internal set
  var contentColor by mutableStateOf(contentColor, structuralEqualityPolicy())
    internal set
  var isLight by mutableStateOf(isLight, structuralEqualityPolicy())
    internal set

  fun copy(
    background: Color = this.background,
    textColor: Color = this.contentColor,
    surface: Color = this.surface,
    isLight: Boolean = this.isLight
  ): DuolingoColors = DuolingoColors(
    background, textColor, surface, isLight
  )

  override fun toString(): String {
    return "Colors(" +
      "background=$background,textColor=$contentColor,surface=$surface,isLight=$isLight)"
  }
}

fun lightColors() = DuolingoColors(isLight = true, contentColor = Color.Black,surface = Color.White, background = Color.White)
fun darkColors() = DuolingoColors(isLight = false, contentColor = Color.White, surface = Color.Black, background = Color.Black)

internal fun DuolingoColors.updateColorsFrom(other: DuolingoColors) {
  background = other.background
  isLight = other.isLight
}

internal val LocalColors = staticCompositionLocalOf { lightColors() }