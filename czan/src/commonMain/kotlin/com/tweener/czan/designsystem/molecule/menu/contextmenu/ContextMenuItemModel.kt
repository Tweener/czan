package com.tweener.czan.designsystem.molecule.menu.contextmenu

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @author Vivien Mahe
 * @since 01/04/2024
 */
data class ContextMenuItemModel(
    val id: String,
    val title: String,
    val enabled: Boolean = true,
    val icon: ImageVector? = null,
)
