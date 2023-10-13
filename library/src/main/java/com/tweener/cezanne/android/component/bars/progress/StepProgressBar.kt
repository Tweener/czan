package com.tweener.cezanne.android.component.bars.progress

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
import androidx.compose.ui.unit.dp
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.system.CezanneUiDefaults
import com.tweener.cezanne.android.theme.CezanneTheme

/**
 * @author Vivien Mahe
 * @since 13/10/2023
 */

@Composable
fun StepProgressBar(
    stepsCount: Int,
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    color: Color = CezanneUiDefaults.ProgressBar.color,
    selectedColor: Color = CezanneUiDefaults.ProgressBar.selectedColor,
    dashColor: Color = CezanneUiDefaults.ProgressBar.dashColor
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
                        modifier = Modifier.width(20.dp),
                        thickness = progressBarHeight,
                        color = dashColor
                    )
                }
            }
        }
    }
}

@UiModePreviews
@Composable
private fun ProgressBarNoSelectionPreview() {
    CezanneTheme {
        StepProgressBar(stepsCount = 5)
    }
}

@UiModePreviews
@Composable
private fun ProgressBarSecondSelectedPreview() {
    CezanneTheme {
        StepProgressBar(stepsCount = 5, selectedIndex = 1)
    }
}
