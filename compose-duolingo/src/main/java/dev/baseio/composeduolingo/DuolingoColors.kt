package dev.baseio.composeduolingo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

class Colors(
  background: Color,
  textColor: Color,
  surface: Color,
  isLight: Boolean
) {
  var background by mutableStateOf(background, structuralEqualityPolicy())
    internal set
  var surface by mutableStateOf(surface, structuralEqualityPolicy())
    internal set
  var textColor by mutableStateOf(textColor, structuralEqualityPolicy())
    internal set
  var isLight by mutableStateOf(isLight, structuralEqualityPolicy())
    internal set

  fun copy(
    background: Color = this.background,
    textColor: Color = this.textColor,
    surface: Color = this.surface,
    isLight: Boolean = this.isLight
  ): Colors = Colors(
    background, textColor, surface, isLight
  )

  override fun toString(): String {
    return "Colors(" +
      "background=$background,textColor=$textColor,surface=$surface,isLight=$isLight)"
  }
}

fun lightColors() = Colors(isLight = true, textColor = Color.Black,surface = Color.White, background = Color.White)
fun darkColors() = Colors(isLight = false, textColor = Color.White, surface = Color.Black, background = Color.Black)

internal fun Colors.updateColorsFrom(other: Colors) {
  background = other.background
  isLight = other.isLight
}

internal val LocalColors = staticCompositionLocalOf { lightColors() }