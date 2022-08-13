package dev.baseio.composeduolingo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.semantics

@Composable
fun DuolingoBackground(
  modifier: Modifier = Modifier,
  color: Color = DuolingoTheme.colors.background,
  content: @Composable () -> Unit
) {
  Box(
    modifier = modifier
      .background(
        color = color,
      )
      .semantics(mergeDescendants = false) {}
      .pointerInput(Unit) {},
    propagateMinConstraints = true
  ) {
    content()
  }
}