package com.tweener.czan.designsystem.atom.bars

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveNavigationBar
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveNavigationBarItem
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

/**
 * @author Vivien Mahe
 * @since 20/02/2024
 */

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    colors: NavigationBarColors = NavigationBarDefaults.colors(),
    content: @Composable RowScope.() -> Unit,
) {
    AdaptiveNavigationBar(
        modifier = modifier,
        content = content,
        adaptation = {
            material {
                containerColor = colors.containerColor()
                contentColor = colors.contentColor()
            }
        }
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

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
private fun RowScope.NavigationBarIem(
    icon: @Composable () -> Unit,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    itemColors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
) {
    AdaptiveNavigationBarItem(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        icon = icon,
        label = label?.let { { Text(text = label) } },
        adaptation = {
            material {
                colors = androidx.compose.material3.NavigationBarItemDefaults.colors(
                    selectedIconColor = itemColors.selectedIconColor(),
                    unselectedIconColor = itemColors.unselectedIconColor(),
                    selectedTextColor = itemColors.selectedTextColor(),
                    unselectedTextColor = itemColors.unselectedTextColor(),
                    indicatorColor = itemColors.indicatorColor(),
                )
            }
        },
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
