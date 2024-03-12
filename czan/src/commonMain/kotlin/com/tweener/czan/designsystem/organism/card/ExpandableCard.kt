package com.tweener.czan.designsystem.organism.card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.theme.Size

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
    var showContent by remember { mutableStateOf(expanded) }
    val iconRotation by animateFloatAsState(targetValue = if (showContent) 180f else 0f)

    val cardContent = @Composable {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showContent = !showContent }
                .padding(contentPadding),
            horizontalArrangement = Arrangement.spacedBy(Size.Padding.ExtraSmall),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = Modifier.weight(1f)) {
                header()
            }

            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .rotate(iconRotation),
                imageVector = collapsedIcon,
                tint = colors.chevronTintColor(),
            )
        }

        if (hideableContent != null) {
            AnimatedVisibility(showContent.not()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(contentPadding)
                ) {
                    hideableContent.invoke()
                }
            }
        }

        AnimatedVisibility(showContent) {
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
            androidx.compose.material3.Card(
                modifier = modifier.fillMaxWidth(),
                shape = shape,
                colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = colors.containerColor()),
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
                colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = colors.containerColor()),
                elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = elevation),
            ) {
                cardContent()
            }
        }
    }
}
