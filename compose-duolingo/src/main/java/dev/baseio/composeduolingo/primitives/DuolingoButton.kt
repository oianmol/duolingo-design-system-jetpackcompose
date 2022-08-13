package dev.baseio.composeduolingo.primitives

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.baseio.composeduolingo.DuolingoSurface

@Composable
fun DuolingoButton(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  elevation: Dp,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
  content: @Composable RowScope.() -> Unit
) {
  DuolingoSurface(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    elevation = elevation,
    interactionSource = interactionSource,
  ){
    Row(
      Modifier
        .defaultMinSize(
          minWidth = ButtonDefaults.MinWidth,
          minHeight = ButtonDefaults.MinHeight
        )
        .padding(contentPadding),
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically,
      content = content
    )
  }

}

object ButtonDefaults {
  private val ButtonHorizontalPadding = 16.dp
  private val ButtonVerticalPadding = 8.dp

  /**
   * The default content padding used by [Button]
   */
  val ContentPadding = PaddingValues(
    start = ButtonHorizontalPadding,
    top = ButtonVerticalPadding,
    end = ButtonHorizontalPadding,
    bottom = ButtonVerticalPadding
  )

  /**
   * The default min width applied for the [Button].
   * Note that you can override it by applying Modifier.widthIn directly on [Button].
   */
  val MinWidth = 64.dp

  /**
   * The default min height applied for the [Button].
   * Note that you can override it by applying Modifier.heightIn directly on [Button].
   */
  val MinHeight = 36.dp

  /**
   * The default size of the icon when used inside a [Button].
   *
   * @sample androidx.compose.material.samples.ButtonWithIconSample
   */
  val IconSize = 18.dp

  /**
   * The default size of the spacing between an icon and a text when they used inside a [Button].
   *
   * @sample androidx.compose.material.samples.ButtonWithIconSample
   */
  val IconSpacing = 8.dp

  /**
   * The default color opacity used for an [OutlinedButton]'s border color
   */
  const val OutlinedBorderOpacity = 0.12f

  /**
   * The default [OutlinedButton]'s border size
   */
  val OutlinedBorderSize = 1.dp

  private val TextButtonHorizontalPadding = 8.dp

  /**
   * The default content padding used by [TextButton]
   */
  val TextButtonContentPadding = PaddingValues(
    start = TextButtonHorizontalPadding,
    top = ContentPadding.calculateTopPadding(),
    end = TextButtonHorizontalPadding,
    bottom = ContentPadding.calculateBottomPadding()
  )
}