package com.tweener.czan.preview.designsystem.atom.menu.contextmenu

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.menu.contextmenu.ContextMenu
import com.tweener.czan.designsystem.atom.menu.contextmenu.ContextMenuItemModel
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

/**
 * @author Vivien Mahe
 * @since 28/03/2024
 */

@OptIn(ExperimentalAdaptiveApi::class)
@UiModePreviews
@Composable
private fun ContextMenuPreview() {
    CzanThemePreview {
        ContextMenu(
            shown = true,
            onDismiss = {},
            adaptation = {
                material {
                    colors = MenuDefaults.itemColors(
                        textColor = MaterialTheme.colorScheme.onSurface,
                        disabledTextColor = MaterialTheme.colorScheme.outline,
                        leadingIconColor = MaterialTheme.colorScheme.onSurface,
                        disabledLeadingIconColor = MaterialTheme.colorScheme.outline,
                    )
                }
            },
            items = listOf(
                ContextMenuItemModel(id = "#1", title = "Item 1"),
                ContextMenuItemModel(id = "#2", title = "Item 2"),
                ContextMenuItemModel(id = "#3", title = "Item 3"),
            ),
        )
    }
}
