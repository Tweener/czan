package com.tweener.czan._internal.kotlinextensions

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

/**
 * @author Vivien Mahe
 * @since 31/12/2023
 */

inline fun Modifier.conditional(
    condition: Boolean,
    ifTrue: Modifier.() -> Modifier,
    ifFalse: Modifier.() -> Modifier = { this },
): Modifier =
    if (condition) {
        then(ifTrue(Modifier))
    } else {
        then(ifFalse(Modifier))
    }

fun Modifier.verticalGradientBackground(
    color: Color,
    startAlpha: Float = 1f,
    endAlpha: Float = 0f
): Modifier =
    this.background(
        brush = Brush.verticalGradient(
            colors = listOf(
                color.copy(alpha = startAlpha),
                color.copy(alpha = endAlpha)
            ),
        )
    )

fun Modifier.horizontalGradientBackground(
    color: Color,
    startAlpha: Float = 1f,
    endAlpha: Float = 0f
): Modifier =
    this.background(
        brush = Brush.horizontalGradient(
            colors = listOf(
                color.copy(alpha = startAlpha),
                color.copy(alpha = endAlpha)
            ),
        )
    )

fun Modifier.bottomBorder(
    width: Dp,
    color: Color
) =
    composed {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { width.toPx() }

        Modifier.drawBehind {
            val height = size.height - strokeWidthPx / 2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = size.width, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }

fun Modifier.topBorder(
    width: Dp,
    color: Color
) =
    composed {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { width.toPx() }

        Modifier.drawBehind {
            drawLine(
                color = color,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = size.width, y = 0f),
                strokeWidth = strokeWidthPx
            )
        }
    }
