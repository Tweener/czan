package com.tweener.czan.designsystem.atom.bars

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    content: @Composable RowScope.() -> Unit,
) {
    AdaptiveNavigationBar(
        modifier = modifier,
        content = content,
        adaptation = {
            material {
                containerColor = NavigationBarDefaults.containerColor
                contentColor = MaterialTheme.colorScheme.contentColorFor(containerColor)
            }
        }
    )
}

@Composable
fun RowScope.NavigationBarItem(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
) {
    NavigationBarIem(
        modifier = modifier,
        label = label,
        selected = selected,
        onClick = onClick,
        icon = { icon?.let { Icon(imageVector = it, contentDescription = label) } },
    )
}

@Composable
fun RowScope.NavigationBarItem(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: Painter? = null,
) {
    NavigationBarIem(
        modifier = modifier,
        label = label,
        selected = selected,
        onClick = onClick,
        icon = { icon?.let { Icon(painter = it, contentDescription = label) } },
    )
}

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
private fun RowScope.NavigationBarIem(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    AdaptiveNavigationBarItem(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        icon = icon,
        label = { Text(text = label) },
        adaptation = {
            material {
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                )
            }
        },
    )
}
