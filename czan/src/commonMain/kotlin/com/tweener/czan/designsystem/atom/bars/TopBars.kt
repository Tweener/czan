@file:OptIn(ExperimentalMaterial3Api::class)

package com.tweener.czan.designsystem.atom.bars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.bars.icon.ArrowBackIconButton
import com.tweener.czan.designsystem.atom.bars.icon.CloseBackIconButton
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import org.jetbrains.compose.resources.DrawableResource

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBar(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    logo: Painter? = null,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
                verticalAlignment = Alignment.CenterVertically
            ) {
                logo?.let {
                    Image(
                        modifier = Modifier.size(42.dp),
                        painter = logo,
                        colorFilter = ColorFilter.tint(color = colors.titleColor()),
                        contentDescription = null
                    )
                }

                Text(
                    text = title,
                    color = colors.titleColor(),
                    style = textStyle
                )
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colors.containerColor(),
            actionIconContentColor = colors.titleColor(),
            titleContentColor = colors.titleColor(),
            navigationIconContentColor = colors.titleColor(),
        )
    )
}

@Composable
fun SimpleTopBar(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        textStyle = textStyle,
        colors = colors,
        actions = actions
    )
}

@Composable
fun NoTitleTopBarWithBackButton(
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = "",
        colors = colors,
        navigationIcon = { ArrowBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@Composable
fun TopBarWithBackButton(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        textStyle = textStyle,
        colors = colors,
        navigationIcon = { ArrowBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@Composable
fun NoTitleTopBarWithCloseButton(
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = "",
        colors = colors,
        navigationIcon = { CloseBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@Composable
fun TopBarWithCloseButton(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        textStyle = textStyle,
        colors = colors,
        navigationIcon = { CloseBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@Composable
fun TopBarWithCustomIcon(
    title: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    colors: TopBarColors = TopBarDefaults.colors(),
    navigationIcon: DrawableResource,
    onIconClicked: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        textStyle = textStyle,
        colors = colors,
        navigationIcon = {
            IconButton(onClick = { onIconClicked?.invoke() }) {
                Icon(resource = navigationIcon, tint = colors.navigationIconColor())
            }
        },
        actions = actions,
    )
}

@Composable
internal fun TopBarWithIcon(
    title: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    colors: TopBarColors = TopBarDefaults.colors(),
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        title = { Text(text = title, style = textStyle) },
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        windowInsets = TopAppBarDefaults.windowInsets,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colors.containerColor(),
            titleContentColor = colors.titleColor(),
            navigationIconContentColor = colors.navigationIconColor(),
            actionIconContentColor = colors.actionIconColor(),
        ),
        scrollBehavior = scrollBehavior,
    )
}

@Composable
fun RowScope.TopBarAction(
    icon: DrawableResource,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentDescription: String? = null
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(resource = icon, contentDescription = contentDescription)
    }
}

@Composable
fun RowScope.TopBarAction(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentDescription: String? = null
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(imageVector = icon, contentDescription = contentDescription)
    }
}

@Composable
fun RowScope.TopBarAction(
    icon: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentDescription: String? = null
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(painter = icon, contentDescription = contentDescription)
    }
}

object TopBarDefaults {

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        titleColor: Color = MaterialTheme.colorScheme.contentColorFor(containerColor),
        navigationIconColor: Color = titleColor,
        actionIconColor: Color = titleColor,
    ): TopBarColors = TopBarColors(
        containerColor = containerColor,
        titleColor = titleColor,
        navigationIconColor = navigationIconColor,
        actionIconColor = actionIconColor,
    )
}

@Immutable
class TopBarColors internal constructor(
    private val containerColor: Color,
    private val titleColor: Color,
    private val navigationIconColor: Color,
    private val actionIconColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun titleColor(): Color = titleColor

    @Composable
    internal fun navigationIconColor(): Color = navigationIconColor

    @Composable
    internal fun actionIconColor(): Color = actionIconColor
}
