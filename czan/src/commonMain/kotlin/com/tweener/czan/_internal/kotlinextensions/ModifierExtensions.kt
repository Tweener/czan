package com.tweener.czan._internal.kotlinextensions

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.defaultShimmerTheme
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

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

@Composable
fun Modifier.clickableRipple(
    enabled: Boolean = true,
    onClick: () -> Unit
): Modifier =
    this.clickable(
        enabled = enabled,
        onClick = onClick,
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple()
    )

@Composable
fun Modifier.shimmer(
    durationMillis: Int = 800,
    delayMillis: Int = 1_500,
): Modifier = composed {
    val shimmer = rememberShimmer(
        shimmerBounds = ShimmerBounds.View,
        theme = defaultShimmerTheme.copy(
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationMillis,
                    delayMillis = delayMillis,
                    easing = LinearEasing,
                ),
                repeatMode = RepeatMode.Restart,
            ),
        ),
    )

    shimmer(customShimmer = shimmer)
}
