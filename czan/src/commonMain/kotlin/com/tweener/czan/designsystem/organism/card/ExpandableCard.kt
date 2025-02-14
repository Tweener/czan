package com.tweener.czan.designsystem.organism.card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.tweener.czan._internal.kotlinextensions.clickableRipple
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.theme.Size
import org.jetbrains.compose.resources.DrawableResource

/**
 * @author Vivien Mahe
 * @since 12/03/2024
 */

@Composable
fun ExpandableCard(
    collapsedIcon: ImageVector,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    enabled: Boolean = true,
    shape: Shape = CardDefaults.shape,
    colors: ExpandableCardColors = ExpandableCardDefaults.colors(),
    sizes: ExpandableCardSizes = ExpandableCardDefaults.sizes(),
    header: @Composable () -> Unit,
    footer: @Composable (() -> Unit)? = null,
    hideableContent: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    ExpandableCard(
        modifier = modifier,
        collapsedIcon = { iconRotation ->
            Icon(
                modifier = Modifier
                    .size(ExpandableCardDefaults.headerToggleIconSize)
                    .rotate(iconRotation),
                imageVector = collapsedIcon,
                tint = colors.chevronTintColor(),
            )
        },
        expanded = expanded,
        enabled = enabled,
        shape = shape,
        colors = colors,
        sizes = sizes,
        header = header,
        footer = footer,
        hideableContent = hideableContent,
        content = content,
    )
}

@Composable
fun ExpandableCard(
    collapsedIcon: DrawableResource,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    enabled: Boolean = true,
    shape: Shape = CardDefaults.shape,
    colors: ExpandableCardColors = ExpandableCardDefaults.colors(),
    sizes: ExpandableCardSizes = ExpandableCardDefaults.sizes(),
    header: @Composable () -> Unit,
    footer: @Composable (() -> Unit)? = null,
    hideableContent: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    ExpandableCard(
        modifier = modifier,
        collapsedIcon = { iconRotation ->
            Icon(
                modifier = Modifier
                    .size(ExpandableCardDefaults.headerToggleIconSize)
                    .rotate(iconRotation),
                resource = collapsedIcon,
                tint = colors.chevronTintColor(),
            )
        },
        expanded = expanded,
        enabled = enabled,
        shape = shape,
        colors = colors,
        sizes = sizes,
        header = header,
        footer = footer,
        hideableContent = hideableContent,
        content = content,
    )
}

@Composable
private fun ExpandableCard(
    collapsedIcon: @Composable (Float) -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    enabled: Boolean = true,
    shape: Shape = CardDefaults.shape,
    colors: ExpandableCardColors = ExpandableCardDefaults.colors(),
    sizes: ExpandableCardSizes = ExpandableCardDefaults.sizes(),
    header: @Composable () -> Unit,
    footer: @Composable (() -> Unit)? = null,
    hideableContent: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    var showContent by rememberSaveable { mutableStateOf(expanded) }
    val iconRotation by animateFloatAsState(targetValue = if (showContent) 180f else 0f)

    val cardContent = @Composable {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickableRipple(enabled = enabled) { showContent = !showContent }
                .padding(sizes.contentPadding()),
            horizontalArrangement = Arrangement.spacedBy(Size.Padding.ExtraSmall),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = Modifier.weight(1f)) {
                header()
            }

            if (enabled) {
                collapsedIcon(iconRotation)
            }
        }

        // Optional content that will be shown only when the whole card is collapsed
        if (hideableContent != null) {
            AnimatedVisibility(
                visible = showContent.not(),
                enter = slideInVertically() + expandVertically() + fadeIn(),
                exit = slideOutVertically() + shrinkVertically() + fadeOut(),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = sizes.contentPadding().calculateStartPadding(layoutDirection = LayoutDirection.Ltr),
                            end = sizes.contentPadding().calculateEndPadding(layoutDirection = LayoutDirection.Ltr),
                            bottom = sizes.contentPadding().calculateBottomPadding(),
                            top = Size.Padding.ExtraSmall,
                        )
                ) {
                    hideableContent.invoke()
                }
            }
        }

        // Content that will be shown only when the whole card is expanded
        AnimatedVisibility(
            visible = showContent,
            enter = slideInVertically() + expandVertically() + fadeIn(),
            exit = slideOutVertically() + shrinkVertically() + fadeOut(),
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                // Content
                Box(modifier = Modifier.fillMaxWidth().padding(sizes.contentPadding())) {
                    content()
                }

                // Footer, if provided
                if (footer != null) {
                    HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = colors.dividerColor())

                    Box(modifier = Modifier.fillMaxWidth().padding(sizes.contentPadding())) {
                        footer()
                    }
                }
            }
        }
    }

    when (sizes.elevation()) {
        0.dp -> {
            Card(
                modifier = modifier.fillMaxWidth(),
                shape = shape,
                colors = androidx.compose.material3.CardDefaults.cardColors(
                    containerColor = colors.containerColor(),
                    contentColor = colors.contentColor(),
                ),
                elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = sizes.elevation()),
                border = BorderStroke(width = sizes.borderStrokeWidth(), color = colors.borderStrokeColor()),
            ) {
                cardContent()
            }
        }

        else -> {
            ElevatedCard(
                modifier = modifier.fillMaxWidth(),
                shape = shape,
                colors = androidx.compose.material3.CardDefaults.cardColors(
                    containerColor = colors.containerColor(),
                    contentColor = colors.contentColor(),
                ),
                elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = sizes.elevation()),
            ) {
                cardContent()
            }
        }
    }
}

object ExpandableCardDefaults {

    val headerToggleIconSize: Dp = 24.dp

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.background,
        containerBrush: Brush? = null,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        borderStrokeColor: Color = Color.Transparent,
        dividerColor: Color = MaterialTheme.colorScheme.outline,
        chevronTintColor: Color = MaterialTheme.colorScheme.onBackground,
    ): ExpandableCardColors = ExpandableCardColors(
        containerColor = containerColor,
        containerBrush = containerBrush,
        contentColor = contentColor,
        borderStrokeColor = borderStrokeColor,
        dividerColor = dividerColor,
        chevronTintColor = chevronTintColor,
    )

    @Composable
    fun sizes(
        contentPadding: PaddingValues = PaddingValues(all = Size.Padding.Default),
        elevation: Dp = CardDefaults.elevation,
        borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    ): ExpandableCardSizes = ExpandableCardSizes(
        contentPadding = contentPadding,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
    )
}

@Immutable
class ExpandableCardColors internal constructor(
    containerColor: Color,
    containerBrush: Brush?,
    contentColor: Color,
    borderStrokeColor: Color,
    dividerColor: Color,
    private val chevronTintColor: Color,
) : CardColors(
    containerColor = containerColor,
    containerBrush = containerBrush,
    contentColor = contentColor,
    borderStrokeColor = borderStrokeColor,
    dividerColor = dividerColor,
) {
    @Composable
    internal fun chevronTintColor(): Color = chevronTintColor
}

@Immutable
class ExpandableCardSizes internal constructor(
    contentPadding: PaddingValues,
    elevation: Dp,
    borderStrokeWidth: Dp,
) : CardSizes(
    contentPadding = contentPadding,
    elevation = elevation,
    borderStrokeWidth = borderStrokeWidth,
)
