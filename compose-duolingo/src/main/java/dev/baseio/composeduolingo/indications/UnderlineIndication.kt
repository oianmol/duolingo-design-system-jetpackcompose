package dev.baseio.composeduolingo.indications

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class UnderlineIndication(private val elevation: Dp) : Indication {
    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val isPressed by interactionSource.collectIsPressedAsState()
        val indicationElevation by animateDpAsState(targetValue = if (isPressed) 0.dp else elevation)

        return UnderlineIndicationInstance(
            elevation = indicationElevation
        )
    }
}

class UnderlineIndicationInstance(
    val elevation: Dp
) : IndicationInstance {
    override fun ContentDrawScope.drawIndication() {
        translate(
            top = elevation.toPx()
        ) {
            this@drawIndication.drawContent()
        }
    }
}

@Composable
fun rememberUnderlineIndication(elevation: Dp = 2.dp) = remember { UnderlineIndication(elevation = elevation) }