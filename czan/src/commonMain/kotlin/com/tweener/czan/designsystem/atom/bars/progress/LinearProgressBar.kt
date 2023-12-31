package com.tweener.czan.designsystem.atom.bars.progress

import androidx.annotation.FloatRange
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tweener.czan.theme.CzanUiDefaults

/**
 * @author Vivien Mahe
 * @since 13/10/2023
 */

@Composable
fun LinearProgressBar(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) progress: Float = 0f,
    color: Color = CzanUiDefaults.ProgressBar.color,
    selectedColor: Color = CzanUiDefaults.ProgressBar.selectedColor
) {
    LinearProgressIndicator(
        modifier = modifier,
        progress = progress,
        color = color,
        trackColor = selectedColor
    )
}

//@PreviewLightDark
//@Composable
//private fun LinearProgressBarProgressNonePreview() {
//    CzanThemePreview {
//        LinearProgressBar(progress = 0f)
//    }
//}
//
//@PreviewLightDark
//@Composable
//private fun LinearProgressBarProgress30Preview() {
//    CzanThemePreview {
//        LinearProgressBar(progress = 0.3f)
//    }
//}
