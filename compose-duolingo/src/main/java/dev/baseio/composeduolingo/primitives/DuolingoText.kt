package dev.baseio.composeduolingo.primitives

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import dev.baseio.composeduolingo.DuolingoTheme

@Composable
fun DuolingoText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = DuolingoTheme.duolingoColors.contentColor,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle
) {
  val mergedStyle = style.merge(
    TextStyle(
      color = color,
      fontSize = fontSize,
      fontWeight = fontWeight,
      textAlign = textAlign,
      lineHeight = lineHeight,
      fontFamily = fontFamily,
      textDecoration = textDecoration,
      fontStyle = fontStyle,
      letterSpacing = letterSpacing
    )
  )
  BasicText(
    text,
    modifier,
    mergedStyle,
    onTextLayout,
    overflow,
    softWrap,
    maxLines,
  )
}
