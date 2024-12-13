package com.tweener.czan.designsystem.atom.bars.progress

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.tweener.czan.theme.CzanUiDefaults

/**
 * @author Vivien Mahe
 * @since 13/10/2023
 */

@Composable
fun LinearProgressBar(
    modifier: Modifier = Modifier,
    animated: Boolean = false,
    animationDurationMillis: Int = 300,
    progress: Float = 0f, // Between 0.0 and 1.0
    color: Color = CzanUiDefaults.ProgressBar.selectedColor,
    trackColor: Color = CzanUiDefaults.ProgressBar.trackColor,
    strokeCap: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
) {
    val progressAnimation = remember { Animatable(0f) }

    LaunchedEffect(progress) {
        if (animated) {
            progressAnimation.animateTo(
                targetValue = progress,
                animationSpec = tween(
                    durationMillis = (animationDurationMillis * (1f - progressAnimation.value)).toInt(),
                    easing = LinearEasing,
                ),
            )
        } else {
            progressAnimation.snapTo(progress)
        }
    }

    LinearProgressIndicator(
        modifier = modifier,
        progress = { progressAnimation.value },
        color = color,
        trackColor = trackColor,
        strokeCap = strokeCap,
        gapSize = (-24).dp,
        drawStopIndicator = {},
    )
}


@Composable
fun LinearProgressBar(
    modifier: Modifier = Modifier,
    color: Color = CzanUiDefaults.ProgressBar.selectedColor,
    trackColor: Color = CzanUiDefaults.ProgressBar.trackColor,
    strokeCap: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
) {
    LinearProgressIndicator(
        modifier = modifier,
        color = color,
        trackColor = trackColor,
        strokeCap = strokeCap,
        gapSize = (-24).dp,
    )
}
