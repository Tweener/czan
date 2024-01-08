package com.tweener.czan.preview.designsystem.atom.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.button.FloatingActionButton
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun FloatingActionButtonPreview() {
    CzanThemePreview {
        FloatingActionButton(icon = Icons.Default.Add)
    }
}
