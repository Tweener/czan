package com.tweener.czan.preview.designsystem.atom.text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.House
import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.text.LeadingIconText
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 20/04/2024
 */

@UiModePreviews
@Composable
private fun LeadingIconTextPreview() {
    CzanThemePreview {
        LeadingIconText(
            text = "This is a text",
            icon = Icons.Default.House,
        )
    }
}
