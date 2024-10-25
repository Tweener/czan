package com.tweener.czan.designsystem.atom.line

/**
 * @author Vivien Mahe
 * @since 24/10/2024
 */

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
fun HorizontalDashedLine(
    modifier: Modifier = Modifier,
    colors: LineColors = LineDefaults.lineColors(),
    sizes: LineSizes = LineDefaults.lineSizes(),
) {
    Canvas(modifier = modifier.fillMaxWidth().height(sizes.thickness())) {
        drawLine(
            color = colors.strokeColor(),
            strokeWidth = sizes.thickness().toPx(),
            start = Offset(0f, sizes.thickness().toPx() / 2),
            end = Offset(size.width, sizes.thickness().toPx() / 2),
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(sizes.dashOn().toPx(), sizes.dashOff().toPx()),
                phase = 0f,
            ),
        )
    }
}

@Composable
fun VerticalDashedLine(
    modifier: Modifier = Modifier,
    colors: LineColors = LineDefaults.lineColors(),
    sizes: LineSizes = LineDefaults.lineSizes(),
) {
    Canvas(modifier = modifier.fillMaxHeight().width(sizes.thickness())) {
        drawLine(
            color = colors.strokeColor(),
            strokeWidth = sizes.thickness().toPx(),
            start = Offset(sizes.thickness().toPx() / 2, 0f),
            end = Offset(sizes.thickness().toPx() / 2, size.height),
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
        thickness: Dp = 1.dp,
    ): LineSizes = LineSizes(
        dashOn = dashOn,
        dashOff = dashOff,
        thickness = thickness,
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
    private val thickness: Dp,
) {
    internal fun dashOn(): Dp = dashOn

    internal fun dashOff(): Dp = dashOff

    internal fun thickness(): Dp = thickness
}
