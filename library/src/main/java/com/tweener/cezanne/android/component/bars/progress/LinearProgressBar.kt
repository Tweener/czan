package com.tweener.cezanne.android.component.bars.progress

import androidx.annotation.FloatRange
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.system.CezanneUiDefaults
import com.tweener.cezanne.android.theme.CezanneTheme

/**
 * @author Vivien Mahe
 * @since 13/10/2023
 */

@Composable
fun LinearProgressBar(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) progress: Float = 0f,
    color: Color = CezanneUiDefaults.ProgressBar.color,
    selectedColor: Color = CezanneUiDefaults.ProgressBar.selectedColor
) {
    LinearProgressIndicator(
        modifier = modifier,
        progress = progress,
        color = color,
        trackColor = selectedColor
    )
}

@UiModePreviews
@Composable
private fun LinearProgressBarProgressNonePreview() {
    CezanneTheme {
        LinearProgressBar(progress = 0f)
    }
}

@UiModePreviews
@Composable
private fun LinearProgressBarProgress30Preview() {
    CezanneTheme {
        LinearProgressBar(progress = 0.3f)
    }
}
