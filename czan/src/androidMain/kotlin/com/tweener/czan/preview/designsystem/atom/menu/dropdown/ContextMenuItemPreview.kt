package com.tweener.czan.preview.designsystem.atom.menu.dropdown

import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.menu.dropdown.ContextMenuItem
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 28/03/2024
 */

@UiModePreviews
@Composable
private fun ContextMenuItemPreview() {
    CzanThemePreview {
        ContextMenuItem(title = "Oui")
    }
}
