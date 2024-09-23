package com.tweener.czan.designsystem.organism.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan._internal.kotlinextensions.clickableRipple
import com.tweener.czan._internal.kotlinextensions.conditional
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 12/03/2024
 */

@Composable
fun Card(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: Dp = CardDefaults.elevation,
    borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    contentPadding: Dp = Size.Padding.Default,
    showDividers: Boolean = true,
    onClick: (() -> Unit)? = null,
    header: @Composable (() -> Unit)? = null,
    footer: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val verticalPadding = Size.Padding.ExtraSmall
    val cardBorder = if (elevation == 0.dp) BorderStroke(width = borderStrokeWidth, color = colors.borderStrokeColor()) else null

    Card(
        modifier = modifier,
        shape = shape,
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = colors.containerColor(),
            contentColor = colors.contentColor(),
        ),
        elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = elevation),
        border = cardBorder,
    ) {
        Column(
            modifier = Modifier
                .conditional(
                    condition = colors.containerBrush() != null,
                    ifTrue = { background(colors.containerBrush()!!) },
                    ifFalse = { background(colors.containerColor()) },
                )
                .clickableRipple(enabled = onClick != null) { onClick?.invoke() }
                .padding(vertical = contentPadding),
        ) {
            // Header, if provided
            if (header != null) {
                Box(modifier = Modifier.fillMaxWidth().padding(horizontal = contentPadding)) {
                    header()
                }

                if (showDividers) {
                    Spacer(modifier = Modifier.padding(vertical = verticalPadding))
                    HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = colors.dividerColor())
                }

                Spacer(modifier = Modifier.padding(vertical = verticalPadding))
            }

            // Content
            Box(modifier = Modifier.padding(horizontal = contentPadding)) {
                content()
            }

            // Footer, if provided
            if (footer != null) {
                Spacer(modifier = Modifier.padding(vertical = verticalPadding))

                if (showDividers) {
                    HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = colors.dividerColor())
                }

                Box(modifier = Modifier.fillMaxWidth()) {
                    footer()
                }
            }
        }
    }
}

object CardDefaults {

    val shape: Shape @Composable get() = MaterialTheme.shapes.large
    val elevation: Dp = 0.dp
    val borderStrokeWidth: Dp = 0.dp
    val headerIconSize: Dp = 24.dp

    @Composable
    fun cardColors(
        containerColor: Color = MaterialTheme.colorScheme.background,
        containerBrush: Brush? = null,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        borderStrokeColor: Color = Color.Transparent,
        dividerColor: Color = MaterialTheme.colorScheme.outline,
        chevronTintColor: Color = MaterialTheme.colorScheme.onBackground,
    ): CardColors = CardColors(
        containerColor = containerColor,
        containerBrush = containerBrush,
        contentColor = contentColor,
        borderStrokeColor = borderStrokeColor,
        dividerColor = dividerColor,
        chevronTintColor = chevronTintColor,
    )
}

@Immutable
class CardColors internal constructor(
    private val containerColor: Color,
    private val containerBrush: Brush?,
    private val contentColor: Color,
    private val borderStrokeColor: Color,
    private val dividerColor: Color,
    private val chevronTintColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun containerBrush(): Brush? = containerBrush

    @Composable
    internal fun contentColor(): Color = contentColor

    @Composable
    internal fun borderStrokeColor(): Color = borderStrokeColor

    @Composable
    internal fun dividerColor(): Color = dividerColor

    @Composable
    internal fun chevronTintColor(): Color = chevronTintColor
}
