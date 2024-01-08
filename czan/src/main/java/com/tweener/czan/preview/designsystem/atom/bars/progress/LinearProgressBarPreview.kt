package com.tweener.czan.preview.designsystem.atom.bars.progress

import androidx.compose.runtime.Composable
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.bars.progress.LinearProgressBar
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun LinearProgressBarProgressNonePreview() {
    CzanThemePreview {
        LinearProgressBar(progress = 0f)
    }
}

@UiModePreviews
@Composable
private fun LinearProgressBarProgress30Preview() {
    CzanThemePreview {
        LinearProgressBar(progress = 0.3f)
    }
}
