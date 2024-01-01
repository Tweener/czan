package com.tweener.czan.android.preview.designsystem.atom.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.text.OutlineText
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun OutlineTextPreview() {
    CzanThemePreview {
        OutlineText(
            text = "This is an outline text",
            color = Color.Black,
            outlineColor = Color.White,
            outlineOffset = 4.dp
        )
    }
}
