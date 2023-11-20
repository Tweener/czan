package com.tweener.cezanne.android._internal.kotlinextensions

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.tweener.placeholder.material3.PlaceholderHighlight
import com.tweener.placeholder.material3.placeholder
import com.tweener.placeholder.material3.shimmer

/**
 * @author Vivien Mahe
 * @since 15/11/2023
 */


fun Modifier.shimmer(
    refreshing: Boolean,
    shape: Shape = RectangleShape,
    color: Color,
    highlightColor: Color,
): Modifier =
    composed {
        this.placeholder(
            visible = refreshing,
            shape = shape,
            highlight = PlaceholderHighlight.shimmer(highlightColor = highlightColor),
            color = color
        )
    }

fun Modifier.verticalGradientBackground(
    color: Color,
    startAlpha: Float = 1f,
    endAlpha: Float = 0f
): Modifier =
    composed {
        this.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    color.copy(alpha = startAlpha),
                    color.copy(alpha = endAlpha)
                ),
            )
        )
    }

fun Modifier.horizontalGradientBackground(
    color: Color,
    startAlpha: Float = 1f,
    endAlpha: Float = 0f
): Modifier =
    composed {
        this.background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    color.copy(alpha = startAlpha),
                    color.copy(alpha = endAlpha)
                ),
            )
        )
    }

fun Modifier.bottomBorder(
    width: Dp,
    color: Color
) =
    composed {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { width.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx / 2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width, y = height),
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
