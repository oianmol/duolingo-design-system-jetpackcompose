package dev.baseio.composeduolingo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

class Colors(
  background: Color,
  isLight: Boolean
) {
  var background by mutableStateOf(background, structuralEqualityPolicy())
    internal set
  var isLight by mutableStateOf(isLight, structuralEqualityPolicy())
    internal set

  fun copy(
    background: Color = this.background,
    isLight: Boolean = this.isLight
  ): Colors = Colors(
    background, isLight
  )

  override fun toString(): String {
    return "Colors(" +
      "background=$background,isLight=$isLight)"
  }
}

fun lightColors() = Colors(isLight = true, background = Color.White)
fun darkColors() = Colors(isLight = false, background = Color.Black)

internal fun Colors.updateColorsFrom(other: Colors) {
  background = other.background
  isLight = other.isLight
}

internal val LocalColors = staticCompositionLocalOf { lightColors() }