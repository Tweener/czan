package com.tweener.czan.preview.designsystem.atom.bars.progress

import androidx.compose.runtime.Composable
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.bars.progress.StepProgressBar
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun ProgressBarNoSelectionPreview() {
    CzanThemePreview {
        StepProgressBar(stepsCount = 5)
    }
}

@UiModePreviews
@Composable
private fun ProgressBarSecondSelectedPreview() {
    CzanThemePreview {
        StepProgressBar(stepsCount = 5, selectedIndex = 1)
    }
}
