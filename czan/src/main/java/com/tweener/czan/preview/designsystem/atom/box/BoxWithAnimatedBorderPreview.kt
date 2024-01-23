package com.tweener.czan.preview.designsystem.atom.box

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.box.BoxWithAnimatedBorder
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 12/01/2024
 */

@UiModePreviews
@Composable
private fun BoxWithAnimatedBorderPreview() {
    CzanThemePreview {
        BoxWithAnimatedBorder(
            borderColors = listOf(
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.secondary,
                MaterialTheme.colorScheme.tertiary,
                MaterialTheme.colorScheme.tertiary,
                MaterialTheme.colorScheme.secondary,
                MaterialTheme.colorScheme.primary
            ),
            borderWidth = 2.dp,
        ) {
            Text(text = "Some content inside the Box with animated border")
        }
    }
}
