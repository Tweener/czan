package com.tweener.czan.designsystem.atom.menu.dropdown

import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

/**
 * @author Vivien Mahe
 * @since 28/03/2024
 */

@Composable
fun ContextMenuItem(
    title: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    colors: ContextMenuItemColors = ContextMenuItemDefaults.colors(),
    onClick: (() -> Unit)? = null,
) {
    CzanContextMenuItem(
        modifier = modifier,
        title = title,
        enabled = enabled,
        textStyle = textStyle,
        fontWeight = fontWeight,
        colors = colors,
        onClick = onClick,
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ContextMenuItem(
    title: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    colors: ContextMenuItemColors = ContextMenuItemDefaults.colors(),
    sizes: ContextMenuItemSizes = ContextMenuItemDefaults.sizes(),
    leadingIcon: DrawableResource? = null,
    trailingIcon: DrawableResource? = null,
    onClick: (() -> Unit)? = null,
) {
    CzanContextMenuItem(
        modifier = modifier,
        title = title,
        enabled = enabled,
        textStyle = textStyle,
        fontWeight = fontWeight,
        colors = colors,
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    modifier = Modifier.size(sizes.iconsSize()),
                    resource = leadingIcon,
                    tint = colors.textColor(),
                )
            }
        },
        trailingIcon = trailingIcon?.let {
            {
                Icon(
                    modifier = Modifier.size(sizes.iconsSize()),
                    resource = trailingIcon,
                    tint = colors.textColor(),
                )
            }
        },
        onClick = onClick,
    )
}

@Composable
fun ContextMenuItem(
    title: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    colors: ContextMenuItemColors = ContextMenuItemDefaults.colors(),
    sizes: ContextMenuItemSizes = ContextMenuItemDefaults.sizes(),
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null,
) {
    CzanContextMenuItem(
        modifier = modifier,
        title = title,
        enabled = enabled,
        textStyle = textStyle,
        fontWeight = fontWeight,
        colors = colors,
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    modifier = Modifier.size(sizes.iconsSize()),
                    imageVector = leadingIcon,
                    tint = colors.textColor(),
                )
            }
        },
        trailingIcon = trailingIcon?.let {
            {
                Icon(
                    modifier = Modifier.size(sizes.iconsSize()),
                    imageVector = trailingIcon,
                    tint = colors.textColor(),
                )
            }
        },
        onClick = onClick,
    )
}

@Composable
private fun CzanContextMenuItem(
    title: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    colors: ContextMenuItemColors = ContextMenuItemDefaults.colors(),
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    DropdownMenuItem(
        modifier = modifier,
        text = { Text(text = title, style = textStyle, fontWeight = fontWeight) },
        enabled = enabled,
        colors = MenuDefaults.itemColors(
            textColor = colors.textColor(),
            disabledTextColor = colors.disabledTextColor(),
        ),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        onClick = {
            onClick?.invoke()
        }
    )
}


object ContextMenuItemDefaults {

    val IconsSize = 24.dp

    @Composable
    fun colors(
        textColor: Color = MaterialTheme.colorScheme.onSurface,
        disabledTextColor: Color = MaterialTheme.colorScheme.outline,
        dividerColor: Color = MaterialTheme.colorScheme.outline,
    ): ContextMenuItemColors = ContextMenuItemColors(
        textColor = textColor,
        disabledTextColor = disabledTextColor,
        dividerColor = dividerColor,
    )

    @Composable
    fun sizes(
        iconsSize: Dp = IconsSize,
    ): ContextMenuItemSizes = ContextMenuItemSizes(
        iconsSize = iconsSize,
    )
}

@Immutable
class ContextMenuItemColors internal constructor(
    private val textColor: Color,
    private val disabledTextColor: Color,
    private val dividerColor: Color,
) {
    @Composable
    internal fun textColor(): Color = textColor

    @Composable
    internal fun disabledTextColor(): Color = disabledTextColor

    @Composable
    internal fun dividerColor(): Color = dividerColor
}

@Immutable
class ContextMenuItemSizes internal constructor(
    private val iconsSize: Dp,
) {
    @Composable
    internal fun iconsSize(): Dp = iconsSize
}
