package com.tweener.czan.designsystem.atom.line

/**
 * @author Vivien Mahe
 * @since 24/10/2024
 */

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DashedLine(
    modifier: Modifier = Modifier,
    colors: LineColors = LineDefaults.lineColors(),
    sizes: LineSizes = LineDefaults.lineSizes(),
) {
    Canvas(modifier = modifier.fillMaxWidth()) {
        drawLine(
            color = colors.strokeColor(),
            strokeWidth = sizes.strokeWidth().toPx(),
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(sizes.dashOn().toPx(), sizes.dashOff().toPx()),
                phase = 0f,
            ),
        )
    }
}

object LineDefaults {

    @Composable
    fun lineColors(
        strokeColor: Color = MaterialTheme.colorScheme.primary,
    ): LineColors = LineColors(
        strokeColor = strokeColor,
    )

    @Composable
    fun lineSizes(
        dashOn: Dp = 4.dp,
        dashOff: Dp = 4.dp,
        strokeWidth: Dp = 1.dp,
    ): LineSizes = LineSizes(
        dashOn = dashOn,
        dashOff = dashOff,
        strokeWidth = strokeWidth,
    )
}

@Immutable
class LineColors internal constructor(
    private val strokeColor: Color,
) {
    internal fun strokeColor(): Color = strokeColor
}

@Immutable
class LineSizes internal constructor(
    private val dashOn: Dp,
    private val dashOff: Dp,
    private val strokeWidth: Dp,
) {
    internal fun dashOn(): Dp = dashOn

    internal fun dashOff(): Dp = dashOff

    internal fun strokeWidth(): Dp = strokeWidth
}
