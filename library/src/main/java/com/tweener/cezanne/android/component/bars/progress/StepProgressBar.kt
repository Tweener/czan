package com.tweener.cezanne.android.component.bars.progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.system.CezanneUiDefaults
import com.tweener.cezanne.android.theme.CezanneTheme
import com.tweener.cezanne.android.theme.Size

/**
 * @author Vivien Mahe
 * @since 13/10/2023
 */

@Composable
fun StepProgressBar(
    stepsCount: Int,
    modifier: Modifier = Modifier,
    selectedIndex: Int = -1,
    color: Color = CezanneUiDefaults.ProgressBar.color,
    selectedColor: Color = CezanneUiDefaults.ProgressBar.selectedColor
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small)
    ) {
        for (stepIndex in 0..<stepsCount) {
            val isStepSelected = stepIndex == selectedIndex
            val progress = if (isStepSelected) 1f else 0f

            LinearProgressIndicator(
                modifier = Modifier.weight(0.2f),
                progress = progress,
                color = color,
                trackColor = selectedColor
            )
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
        StepProgressBar(
            stepsCount = 5,
            selectedIndex = 1
        )
    }
}
