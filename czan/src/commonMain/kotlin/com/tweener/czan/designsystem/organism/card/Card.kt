package com.tweener.czan.designsystem.organism.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
    colors: CardColors = CardDefaults.colors(),
    sizes: CardSizes = CardDefaults.sizes(),
    showDividers: Boolean = true,
    onClick: (() -> Unit)? = null,
    header: @Composable (() -> Unit)? = null,
    footer: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val cardBorder = if (sizes.elevation() == 0.dp) BorderStroke(width = sizes.borderStrokeWidth(), color = colors.borderStrokeColor()) else null

    Card(
        modifier = modifier,
        shape = shape,
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = colors.containerColor(),
            contentColor = colors.contentColor(),
        ),
        elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = sizes.elevation()),
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
        ) {
            header?.let {
                Box(modifier = Modifier.fillMaxWidth().padding(sizes.contentPadding())) {
                    header()
                }

                if (showDividers) HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = colors.dividerColor())
            }

            Box(modifier = Modifier.fillMaxWidth().padding(sizes.contentPadding())) {
                content()
            }

            footer?.let {
                if (showDividers) HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = colors.dividerColor())

                Box(modifier = Modifier.fillMaxWidth().padding(sizes.contentPadding())) {
                    footer()
                }
            }
        }
    }
}

object CardDefaults {

    internal val shape: Shape @Composable get() = MaterialTheme.shapes.large
    internal val elevation: Dp = 0.dp
    internal val borderStrokeWidth: Dp = 0.dp

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.background,
        containerBrush: Brush? = null,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        borderStrokeColor: Color = Color.Transparent,
        dividerColor: Color = MaterialTheme.colorScheme.outline,
    ): CardColors = CardColors(
        containerColor = containerColor,
        containerBrush = containerBrush,
        contentColor = contentColor,
        borderStrokeColor = borderStrokeColor,
        dividerColor = dividerColor,
    )

    @Composable
    fun sizes(
        contentPadding: PaddingValues = PaddingValues(all = Size.Padding.Default),
        elevation: Dp = CardDefaults.elevation,
        borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    ): CardSizes = CardSizes(
        contentPadding = contentPadding,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
    )
}

@Immutable
open class CardColors internal constructor(
    private val containerColor: Color,
    private val containerBrush: Brush?,
    private val contentColor: Color,
    private val borderStrokeColor: Color,
    private val dividerColor: Color,
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
}

@Immutable
open class CardSizes internal constructor(
    private val contentPadding: PaddingValues,
    private val elevation: Dp,
    private val borderStrokeWidth: Dp,
) {
    @Composable
    internal fun contentPadding(): PaddingValues = contentPadding

    @Composable
    internal fun elevation(): Dp = elevation

    @Composable
    internal fun borderStrokeWidth(): Dp = borderStrokeWidth
}
