package com.tweener.czan.preview.designsystem.atom.menu.dropdown

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.menu.dropdown.ContextMenu
import com.tweener.czan.designsystem.atom.menu.dropdown.ContextMenuItem
import com.tweener.czan.designsystem.atom.menu.dropdown.ContextMenuItemDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 28/03/2024
 */

@UiModePreviews
@Composable
private fun ContextMenuPreview() {
    CzanThemePreview {
        val colors = ContextMenuItemDefaults.colors(
            textColor = MaterialTheme.colorScheme.onSurface,
            disabledTextColor = MaterialTheme.colorScheme.outline,
            dividerColor = MaterialTheme.colorScheme.outline,
        )

        ContextMenu(
            shown = true,
            onDismiss = {},
        ) {
            ContextMenuItem(title = "Item 1", colors = colors, onClick = {})
            ContextMenuItem(title = "Item 2", colors = colors, onClick = {})
            ContextMenuItem(title = "Item 3", colors = colors, onClick = {})
        }
    }
}
