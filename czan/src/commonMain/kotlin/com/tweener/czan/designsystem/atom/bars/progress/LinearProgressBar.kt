package com.tweener.czan.designsystem.atom.bars.progress

import androidx.annotation.FloatRange
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import com.tweener.czan.theme.CzanUiDefaults

/**
 * @author Vivien Mahe
 * @since 13/10/2023
 */

@Composable
fun LinearProgressBar(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) progress: Float = 0f,
    color: Color = CzanUiDefaults.ProgressBar.selectedColor,
    trackColor: Color = CzanUiDefaults.ProgressBar.trackColor,
    strokeCap: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
) {
    LinearProgressIndicator(
        modifier = modifier,
        progress = { progress },
        color = color,
        trackColor = trackColor,
        strokeCap = strokeCap,
    )
}
