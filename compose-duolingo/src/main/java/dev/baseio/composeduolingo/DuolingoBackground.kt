package dev.baseio.composeduolingo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.semantics
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DuolingoSurface(
  modifier: Modifier = Modifier,
  shape: Shape = RectangleShape,
  color: Color = DuolingoTheme.colors.surface,
  border: BorderStroke? = null,
  elevation: Dp = 0.dp,
  content: @Composable () -> Unit
) {
  Box(
    modifier = modifier
      .surface(
        shape = shape,
        backgroundColor = color,
        border = border,
        elevation = elevation
      )
      .semantics(mergeDescendants = false) {}
      .pointerInput(Unit) {},
    propagateMinConstraints = true
  ) {
    content()
  }
}

@Composable
fun DuolingoSurface(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  shape: Shape = RectangleShape,
  color: Color = DuolingoTheme.colors.surface,
  border: BorderStroke? = null,
  elevation: Dp = 0.dp,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  content: @Composable () -> Unit
) {
  Box(
    modifier = modifier
      .surface(
        shape = shape,
        backgroundColor = color,
        border = border,
        elevation = elevation
      )
      .clickable(
        interactionSource = interactionSource,
        indication = rememberRipple(),
        enabled = enabled,
        role = Role.Button,
        onClick = onClick
      ),
    propagateMinConstraints = true
  ) {
    content()
  }
}

@Composable
fun DuolingoSurface(
  selected: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  shape: Shape = RectangleShape,
  color: Color = DuolingoTheme.colors.surface,
  border: BorderStroke? = null,
  elevation: Dp = 0.dp,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  content: @Composable () -> Unit
) {
  Box(
    modifier = modifier
      .surface(
        shape = shape,
        backgroundColor = color,
        border = border,
        elevation = elevation
      )
      .selectable(
        selected = selected,
        interactionSource = interactionSource,
        indication = rememberRipple(),
        enabled = enabled,
        role = Role.Tab,
        onClick = onClick
      ),
    propagateMinConstraints = true
  ) {
    content()
  }
}


@Composable
fun DuolingoSurface(
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  shape: Shape = RectangleShape,
  color: Color = DuolingoTheme.colors.surface,
  border: BorderStroke? = null,
  elevation: Dp = 0.dp,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  content: @Composable () -> Unit
) {
  Box(
    modifier = modifier
      .surface(
        shape = shape,
        backgroundColor = color,
        border = border,
        elevation = elevation
      )
      .toggleable(
        value = checked,
        interactionSource = interactionSource,
        indication = rememberRipple(),
        enabled = enabled,
        role = Role.Switch,
        onValueChange = onCheckedChange
      ),
    propagateMinConstraints = true
  ) {
    content()
  }
}

private fun Modifier.surface(
  shape: Shape,
  backgroundColor: Color,
  border: BorderStroke?,
  elevation: Dp
) = this.shadow(elevation, shape, clip = false)
  .then(if (border != null) Modifier.border(border, shape) else Modifier)
  .background(color = backgroundColor, shape = shape)
  .clip(shape)
