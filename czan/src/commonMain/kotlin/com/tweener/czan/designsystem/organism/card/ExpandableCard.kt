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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan._internal.kotlinextensions.clickableRipple
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.theme.Size
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

/**
 * @author Vivien Mahe
 * @since 12/03/2024
 */

@Composable
fun ExpandableCard(
    collapsedIcon: ImageVector,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: Dp = CardDefaults.elevation,
    borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    contentPadding: Dp = Size.Padding.Default,
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
                    .size(CardDefaults.headerIconSize)
                    .rotate(iconRotation),
                imageVector = collapsedIcon,
                tint = colors.chevronTintColor(),
            )
        },
        expanded = expanded,
        shape = shape,
        colors = colors,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
        contentPadding = contentPadding,
        header = header,
        footer = footer,
        hideableContent = hideableContent,
        content = content,
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ExpandableCard(
    collapsedIcon: DrawableResource,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: Dp = CardDefaults.elevation,
    borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    contentPadding: Dp = Size.Padding.Default,
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
                    .size(CardDefaults.headerIconSize)
                    .rotate(iconRotation),
                resource = collapsedIcon,
                tint = colors.chevronTintColor(),
            )
        },
        expanded = expanded,
        shape = shape,
        colors = colors,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
        contentPadding = contentPadding,
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
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: Dp = CardDefaults.elevation,
    borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    contentPadding: Dp = Size.Padding.Default,
    header: @Composable () -> Unit,
    footer: @Composable (() -> Unit)? = null,
    hideableContent: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    var showContent by remember { mutableStateOf(expanded) }
    val iconRotation by animateFloatAsState(targetValue = if (showContent) 180f else 0f)

    val cardContent = @Composable {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickableRipple { showContent = !showContent }
                .padding(contentPadding),
            horizontalArrangement = Arrangement.spacedBy(Size.Padding.ExtraSmall),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = Modifier.weight(1f)) {
                header()
            }

            collapsedIcon(iconRotation)
        }

        if (hideableContent != null) {
            AnimatedVisibility(
                visible = showContent.not(),
                enter = slideInVertically() + expandVertically() + fadeIn(),
                exit = slideOutVertically() + shrinkVertically() + fadeOut(),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = contentPadding, end = contentPadding, bottom = contentPadding, top = Size.Padding.ExtraSmall)
                ) {
                    hideableContent.invoke()
                }
            }
        }

        AnimatedVisibility(
            visible = showContent,
            enter = slideInVertically() + expandVertically() + fadeIn(),
            exit = slideOutVertically() + shrinkVertically() + fadeOut(),
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                // Content
                Box(modifier = Modifier.fillMaxWidth().padding(contentPadding)) {
                    content()
                }

                // Footer, if provided
                if (footer != null) {
                    HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = colors.dividerColor())

                    Box(modifier = Modifier.fillMaxWidth().padding(contentPadding)) {
                        footer()
                    }
                }
            }
        }
    }

    when (elevation) {
        0.dp -> {
            Card(
                modifier = modifier.fillMaxWidth(),
                shape = shape,
                colors = androidx.compose.material3.CardDefaults.cardColors(
                    containerColor = colors.containerColor(),
                    contentColor = colors.contentColor(),
                ),
                elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = elevation),
                border = BorderStroke(width = borderStrokeWidth, color = colors.borderStrokeColor()),
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
                elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = elevation),
            ) {
                cardContent()
            }
        }
    }
}
