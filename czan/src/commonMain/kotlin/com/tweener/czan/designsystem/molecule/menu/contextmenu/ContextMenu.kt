package com.tweener.czan.designsystem.molecule.menu.contextmenu

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import io.github.alexzhirkevich.cupertino.CupertinoDropdownMenu
import io.github.alexzhirkevich.cupertino.CupertinoIcon
import io.github.alexzhirkevich.cupertino.CupertinoText
import io.github.alexzhirkevich.cupertino.ExperimentalCupertinoApi
import io.github.alexzhirkevich.cupertino.MenuAction
import io.github.alexzhirkevich.cupertino.adaptive.Adaptation
import io.github.alexzhirkevich.cupertino.adaptive.AdaptationScope
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveWidget
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

/**
 * @author Vivien Mahe
 * @since 01/04/2024
 */

@OptIn(ExperimentalAdaptiveApi::class)
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
    AdaptiveContextMenu(
        modifier = modifier,
        shown = shown,
        onDismiss = onDismiss,
        textStyle = textStyle,
        fontWeight = fontWeight,
        sizes = sizes,
        items = items,
        onItemClick = onItemClick,
        adaptation = {
            material {
                this.colors = MenuDefaults.itemColors(
                    textColor = colors.contentColor(),
                    disabledTextColor = colors.disabledContentColor(),
                    leadingIconColor = colors.contentColor(),
                    disabledLeadingIconColor = colors.disabledContentColor(),
                )
            }
        },
    )
}

@OptIn(ExperimentalAdaptiveApi::class, ExperimentalCupertinoApi::class)
@Composable
private fun AdaptiveContextMenu(
    modifier: Modifier = Modifier,
    shown: Boolean = true,
    onDismiss: (() -> Unit)? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    sizes: ContextMenuSizes = ContextMenuDefaults.sizes(),
    adaptation: AdaptationScope<CupertinoContextMenuAdaptation, MaterialContextMenuAdaptation>.() -> Unit = {},
    items: List<ContextMenuItemModel>,
    onItemClick: ((ContextMenuItemModel) -> Unit)? = null,
) {
    AdaptiveWidget(
        adaptation = remember { ContextMenuAdaptation() },
        adaptationScope = adaptation,
        material = {
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
                        colors = it.colors,
                        leadingIcon = item.icon?.let { imageVector ->
                            {
                                Icon(
                                    modifier = Modifier.size(sizes.iconsSize()),
                                    imageVector = imageVector,
                                    tint = if (item.enabled) it.colors.leadingIconColor else it.colors.disabledLeadingIconColor,
                                )
                            }
                        },
                        onClick = { onItemClick?.invoke(item) },
                    )
                }
            }
        },
        cupertino = {
            CupertinoDropdownMenu(
                modifier = modifier,
                expanded = shown,
                elevation = 6.dp,
                paddingValues = PaddingValues(Size.Padding.ExtraSmall),
                onDismissRequest = { onDismiss?.invoke() },
            ) {
                items.forEach { item ->
                    MenuAction(
                        contentColor = it.colors.contentColor(enabled = item.enabled).value,
                        enabled = item.enabled,
                        icon = {
                            item.icon?.let { imageVector ->
                                CupertinoIcon(
                                    modifier = Modifier.size(sizes.iconsSize()),
                                    imageVector = imageVector,
                                    contentDescription = null,
                                    tint = it.colors.contentColor(item.enabled).value,
                                )
                            }
                        },
                        onClick = { onItemClick?.invoke(item) },
                    ) {
                        CupertinoText(
                            text = item.title,
                            style = textStyle,
                            fontWeight = fontWeight,
                        )
                    }
                }
            }
        },
    )
}

@Stable
class CupertinoContextMenuAdaptation internal constructor(
    var colors: CupertinoMenuItemColors
)

@Stable
class MaterialContextMenuAdaptation internal constructor(
    var colors: MenuItemColors
)

@OptIn(ExperimentalAdaptiveApi::class)
@Stable
private class ContextMenuAdaptation :
    Adaptation<CupertinoContextMenuAdaptation, MaterialContextMenuAdaptation>() {

    @Composable
    override fun rememberCupertinoAdaptation(): CupertinoContextMenuAdaptation {

        val colors = CupertinoMenuContextDefaults.colors()

        return remember(colors) {
            CupertinoContextMenuAdaptation(
                colors = colors
            )
        }
    }

    @Composable
    override fun rememberMaterialAdaptation(): MaterialContextMenuAdaptation {

        val colors = MenuDefaults.itemColors()

        return remember(colors) {
            MaterialContextMenuAdaptation(colors)
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
