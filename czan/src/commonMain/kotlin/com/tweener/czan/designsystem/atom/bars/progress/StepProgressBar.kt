package com.tweener.czan.designsystem.atom.bars.progress

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.theme.CzanUiDefaults

/**
 * @author Vivien Mahe
 * @since 13/10/2023
 */

@Composable
fun StepProgressBar(
    stepsCount: Int,
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    color: Color = CzanUiDefaults.ProgressBar.color,
    selectedColor: Color = CzanUiDefaults.ProgressBar.selectedColor,
    dashColor: Color = CzanUiDefaults.ProgressBar.dashColor,
    dashWidth: Dp = 10.dp
) {
    val progressBarHeight = 4.dp
    val animationDuration = 300
    var progress by remember { mutableFloatStateOf(0f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = animationDuration, easing = FastOutSlowInEasing),
        label = "Step progress indicator",
    )

    LaunchedEffect(selectedIndex) {
        progress = (selectedIndex + 1) / stepsCount.toFloat()
    }

    Box(modifier = modifier.height(progressBarHeight)) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(progressBarHeight),
            progress = animatedProgress,
            color = color,
            trackColor = selectedColor
        )

        if (stepsCount > 1) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (stepIndex in 0..<stepsCount - 1) {
                    Divider(
                        modifier = Modifier.width(dashWidth),
                        thickness = progressBarHeight,
                        color = dashColor
                    )
                }
            }
        }
    }
}

//@PreviewLightDark
//@Composable
//private fun ProgressBarNoSelectionPreview() {
//    CzanThemePreview {
//        StepProgressBar(stepsCount = 5)
//    }
//}
//
//@PreviewLightDark
//@Composable
//private fun ProgressBarSecondSelectedPreview() {
//    CzanThemePreview {
//        StepProgressBar(stepsCount = 5, selectedIndex = 1)
//    }
//}
