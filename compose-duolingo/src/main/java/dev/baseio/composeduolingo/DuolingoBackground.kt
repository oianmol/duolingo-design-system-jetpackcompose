package dev.baseio.composeduolingo

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun DuolingoSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = DuolingoTheme.duolingoColors.surface,
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
    color: Color = DuolingoTheme.duolingoColors.surface,
    border: BorderStroke? = null,
    elevation: Dp = 0.dp,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit
) {
    val density = LocalDensity.current

    var bottomBarWidth: Dp by remember { mutableStateOf(0.dp) }

    val bottomBarHeight = remember(elevation) { elevation * 2 }

    val isPressed by interactionSource.collectIsPressedAsState()

    val contentTranslationY by animateFloatAsState(
        targetValue = with(density) {
            if (!isPressed) elevation.times(1.5f).toPx() else bottomBarHeight.toPx()
        }
    )

    Column(modifier = Modifier.clip(shape)) {
        Box(
            modifier = modifier
                .graphicsLayer { translationY = contentTranslationY }
                .surface(
                    shape = shape,
                    backgroundColor = color,
                    border = border,
                    elevation = elevation
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    enabled = enabled,
                    role = Role.Button,
                    onClick = onClick
                )
                .onSizeChanged { size -> bottomBarWidth = with(density) { size.width.toDp() } }
                .zIndex(1f),
            propagateMinConstraints = true
        ) {
            content()
        }
        border?.let { nnBorder ->
            Box(
                modifier = Modifier
                    .size(
                        width = bottomBarWidth,
                        height = bottomBarHeight,
                    )
                    .background(nnBorder.brush)
            )
        }
    }
}

@Composable
fun DuolingoSurface(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    color: Color = DuolingoTheme.duolingoColors.surface,
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
                indication = null,
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
    color: Color = DuolingoTheme.duolingoColors.surface,
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
                indication = null,
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
) = this
    .shadow(elevation, shape, clip = false)
    .then(if (border != null) Modifier.border(border, shape) else Modifier)
    .background(color = backgroundColor, shape = shape)
    .clip(shape)
