package com.tweener.czan.preview.designsystem.atom.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.text.HighlightedText
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 27/03/2025
 */

@UiModePreviews
@Composable
private fun TextFieldPasswordHiddenEnabledPreview() {
    CzanThemePreview {
        HighlightedText(
            text = "This is a highlighted text",
            highlights = listOf("highlighted"),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            highlightContainerColor = MaterialTheme.colorScheme.primary,
            highlightContentColor = MaterialTheme.colorScheme.onPrimary,
            cornerRadius = 6.dp,
        )
    }
}
