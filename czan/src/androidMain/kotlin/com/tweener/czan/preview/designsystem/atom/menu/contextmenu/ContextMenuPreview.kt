package com.tweener.czan.preview.designsystem.atom.menu.contextmenu

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.menu.contextmenu.ContextMenu
import com.tweener.czan.designsystem.atom.menu.contextmenu.ContextMenuDefaults
import com.tweener.czan.designsystem.atom.menu.contextmenu.ContextMenuItemModel
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
        ContextMenu(
            shown = true,
            onDismiss = {},
            items = listOf(
                ContextMenuItemModel(id = "#1", title = "Item 1"),
                ContextMenuItemModel(id = "#2", title = "Item 2", enabled = false),
                ContextMenuItemModel(id = "#3", title = "Item 3"),
            ),
            colors = ContextMenuDefaults.colors(
                contentColor = MaterialTheme.colorScheme.primary,
                disabledContentColor = MaterialTheme.colorScheme.outline,
            ),
        )
    }
}
