package com.tweener.czan.designsystem.molecule.carousel

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Vivien Mahe
 * @since 07/06/2024
 */

enum class CarouselDashState {
    NOT_STARTED,
    IN_PROGRESS,
    FINISHED;
}

@Composable
fun CarouselDash(
    foregroundColor: Color,
    modifier: Modifier = Modifier,
    backgroundColor: Color = foregroundColor.copy(alpha = 0.16f),
    thickness: Dp = 4.dp,
    state: CarouselDashState = CarouselDashState.NOT_STARTED,
    durationMillis: Int = 5000,
    paused: Boolean = false,
    onFinished: (() -> Unit)? = null,
) {
    val progressAnimation = remember { Animatable(0f) }

    LaunchedEffect(state) {
        when (state) {
            CarouselDashState.NOT_STARTED -> progressAnimation.snapTo(0f)
            CarouselDashState.IN_PROGRESS -> progressAnimation.snapTo(0f)
            CarouselDashState.FINISHED -> progressAnimation.snapTo(1f)
        }
    }

    LaunchedEffect(paused) {
        when (paused) {
            true -> progressAnimation.stop()
            false -> {
                progressAnimation.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(
                        durationMillis = (durationMillis * (1f - progressAnimation.value)).toInt(),
                        easing = LinearEasing,
                    ),
                )

                onFinished?.invoke()
            }
        }
    }

    LinearProgressIndicator(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
            .clip(shape = MaterialTheme.shapes.large),
        progress = { progressAnimation.value },
        color = foregroundColor,
        trackColor = backgroundColor,
        gapSize = (-24).dp,
        drawStopIndicator = {},
    )
}
