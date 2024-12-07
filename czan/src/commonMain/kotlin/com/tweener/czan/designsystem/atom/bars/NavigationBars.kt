package com.tweener.czan.designsystem.atom.bars

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text

/**
 * @author Vivien Mahe
 * @since 20/02/2024
 */

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    colors: NavigationBarColors = NavigationBarDefaults.colors(),
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = colors.containerColor(),
        contentColor = colors.contentColor(),
        windowInsets = androidx.compose.material3.NavigationBarDefaults.windowInsets,
        content = content,
    )
}

@Composable
fun RowScope.NavigationBarItem(
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
) {
    NavigationBarIem(
        modifier = modifier,
        icon = { Icon(imageVector = icon, contentDescription = label) },
        label = label,
        selected = selected,
        onClick = onClick,
        itemColors = colors,
    )
}

@Composable
fun RowScope.NavigationBarItem(
    icon: Painter,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
) {
    NavigationBarIem(
        modifier = modifier,
        icon = { Icon(painter = icon, contentDescription = label) },
        label = label,
        selected = selected,
        onClick = onClick,
        itemColors = colors,
    )
}

@Composable
private fun RowScope.NavigationBarIem(
    icon: @Composable () -> Unit,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null,
    alwaysShowLabel: Boolean = true,
    itemColors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        modifier = modifier,
        enabled = enabled,
        label = label?.let { { Text(text = label) } },
        alwaysShowLabel = alwaysShowLabel,
        colors = androidx.compose.material3.NavigationBarItemDefaults.colors(
            selectedIconColor = itemColors.selectedIconColor(),
            unselectedIconColor = itemColors.unselectedIconColor(),
            selectedTextColor = itemColors.selectedTextColor(),
            unselectedTextColor = itemColors.unselectedTextColor(),
            indicatorColor = itemColors.indicatorColor(),
        ),
        interactionSource = remember { MutableInteractionSource() },
    )
}

object NavigationBarDefaults {

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        contentColor: Color = MaterialTheme.colorScheme.contentColorFor(containerColor),
    ): NavigationBarColors = NavigationBarColors(
        containerColor = containerColor,
        contentColor = contentColor,
    )
}

@Immutable
class NavigationBarColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun contentColor(): Color = contentColor
}

object NavigationBarItemDefaults {

    @Composable
    fun colors(
        selectedIconColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
        unselectedIconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        selectedTextColor: Color = MaterialTheme.colorScheme.onSurface,
        unselectedTextColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        indicatorColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    ): NavigationBarItemColors = NavigationBarItemColors(
        selectedIconColor = selectedIconColor,
        unselectedIconColor = unselectedIconColor,
        selectedTextColor = selectedTextColor,
        unselectedTextColor = unselectedTextColor,
        indicatorColor = indicatorColor,
    )
}

@Immutable
class NavigationBarItemColors internal constructor(
    private val selectedIconColor: Color,
    private val unselectedIconColor: Color,
    private val selectedTextColor: Color,
    private val unselectedTextColor: Color,
    private val indicatorColor: Color,
) {
    @Composable
    internal fun selectedIconColor(): Color = selectedIconColor

    @Composable
    internal fun unselectedIconColor(): Color = unselectedIconColor

    @Composable
    internal fun selectedTextColor(): Color = selectedTextColor

    @Composable
    internal fun unselectedTextColor(): Color = unselectedTextColor

    @Composable
    internal fun indicatorColor(): Color = indicatorColor
}
