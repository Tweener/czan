package com.tweener.czan.designsystem.molecule.menu.contextmenu

import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text

/**
 * @author Vivien Mahe
 * @since 01/04/2024
 */

@Composable
fun ContextMenu(
    modifier: Modifier = Modifier,
    shown: Boolean = true,
    onDismiss: (() -> Unit)? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    colors: ContextMenuColors = ContextMenuDefaults.colors(),
    sizes: ContextMenuSizes = ContextMenuDefaults.sizes(),
    items: List<ContextMenuItemModel>,
    onItemClick: ((ContextMenuItemModel) -> Unit)? = null,
) {
    DropdownMenu(
        modifier = modifier,
        expanded = shown,
        onDismissRequest = { onDismiss?.invoke() },
    ) {
        items.forEach { item ->
            DropdownMenuItem(
                modifier = Modifier,
                text = { Text(text = item.title, style = textStyle, fontWeight = fontWeight) },
                enabled = item.enabled,
                colors = MenuDefaults.itemColors(
                    textColor = colors.contentColor(),
                    disabledTextColor = colors.disabledContentColor(),
                    leadingIconColor = colors.contentColor(),
                    disabledLeadingIconColor = colors.disabledContentColor(),
                ),
                leadingIcon = item.icon?.let { imageVector ->
                    {
                        Icon(
                            modifier = Modifier.size(sizes.iconsSize()),
                            imageVector = imageVector,
                            tint = if (item.enabled) colors.contentColor() else colors.disabledContentColor(),
                        )
                    }
                },
                onClick = { onItemClick?.invoke(item) },
            )
        }
    }
}

object ContextMenuDefaults {

    val IconsSize = 24.dp

    @Composable
    fun colors(
        contentColor: Color = MaterialTheme.colorScheme.onSurface,
        disabledContentColor: Color = MaterialTheme.colorScheme.outline,
        dividerColor: Color = MaterialTheme.colorScheme.outline,
    ): ContextMenuColors = ContextMenuColors(
        contentColor = contentColor,
        disabledContentColor = disabledContentColor,
        dividerColor = dividerColor,
    )

    @Composable
    fun sizes(
        iconsSize: Dp = IconsSize,
    ): ContextMenuSizes = ContextMenuSizes(
        iconsSize = iconsSize,
    )
}

@Immutable
class ContextMenuColors internal constructor(
    private val contentColor: Color,
    private val disabledContentColor: Color,
    private val dividerColor: Color,
) {
    @Composable
    internal fun contentColor(): Color = contentColor

    @Composable
    internal fun disabledContentColor(): Color = disabledContentColor

    @Composable
    internal fun dividerColor(): Color = dividerColor
}

@Immutable
class ContextMenuSizes internal constructor(
    private val iconsSize: Dp,
) {
    @Composable
    internal fun iconsSize(): Dp = iconsSize
}
