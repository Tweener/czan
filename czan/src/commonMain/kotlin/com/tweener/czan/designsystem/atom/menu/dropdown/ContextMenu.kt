package com.tweener.czan.designsystem.atom.menu.dropdown

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Vivien Mahe
 * @since 28/03/2024
 */

@Composable
fun ContextMenu(
    modifier: Modifier = Modifier,
    shown: Boolean = true,
    onDismiss: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    DropdownMenu(
        modifier = modifier,
        expanded = shown,
        onDismissRequest = { onDismiss?.invoke() },
    ) {
        content()
    }
}
