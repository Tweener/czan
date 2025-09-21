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
import androidx.compose.ui.draw.shadow
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
    Card(
        modifier = modifier.shadow(elevation = sizes.elevation(), shape = shape, spotColor = colors.shadowColor()),
        shape = shape,
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = colors.containerColor(),
            contentColor = colors.contentColor(),
        ),
        border = BorderStroke(width = sizes.borderStrokeWidth(), color = colors.borderStrokeColor()),
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
                Box(modifier = Modifier.fillMaxWidth().padding(sizes.headerPadding())) {
                    header()
                }

                if (showDividers) HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = colors.dividerColor())
            }

            Box(modifier = Modifier.fillMaxWidth().padding(sizes.contentPadding())) {
                content()
            }

            footer?.let {
                if (showDividers) HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = colors.dividerColor())

                Box(modifier = Modifier.fillMaxWidth().padding(sizes.footerPadding())) {
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

    internal val containerColorDefault: Color @Composable get() = MaterialTheme.colorScheme.background
    internal val contentColorDefault: Color @Composable get() = MaterialTheme.colorScheme.onBackground
    internal val borderStrokeColorDefault: Color @Composable get() = Color.Transparent
    internal val dividerColorDefault: Color @Composable get() = MaterialTheme.colorScheme.outline
    internal val shadowColorDefault: Color @Composable get() = Color.Black.copy(alpha = 0.08f)

    @Composable
    fun colors(
        containerColor: Color = containerColorDefault,
        containerBrush: Brush? = null,
        contentColor: Color = contentColorDefault,
        borderStrokeColor: Color = borderStrokeColorDefault,
        dividerColor: Color = dividerColorDefault,
        shadowColor: Color = shadowColorDefault,
    ): CardColors = CardColors(
        containerColor = containerColor,
        containerBrush = containerBrush,
        contentColor = contentColor,
        borderStrokeColor = borderStrokeColor,
        dividerColor = dividerColor,
        shadowColor = shadowColor,
    )

    @Composable
    fun sizes(
        contentPadding: PaddingValues = PaddingValues(all = Size.Padding.Default),
        headerPadding: PaddingValues = contentPadding,
        footerPadding: PaddingValues = contentPadding,
        elevation: Dp = CardDefaults.elevation,
        borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    ): CardSizes = CardSizes(
        contentPadding = contentPadding,
        headerPadding = headerPadding,
        footerPadding = footerPadding,
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
    private val shadowColor: Color,
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
    internal fun shadowColor(): Color = shadowColor
}

@Immutable
open class CardSizes internal constructor(
    private val contentPadding: PaddingValues,
    private val headerPadding: PaddingValues = contentPadding,
    private val footerPadding: PaddingValues = contentPadding,
    private val elevation: Dp,
    private val borderStrokeWidth: Dp,
) {
    @Composable
    internal fun contentPadding(): PaddingValues = contentPadding

    @Composable
    internal fun headerPadding(): PaddingValues = headerPadding

    @Composable
    internal fun footerPadding(): PaddingValues = footerPadding

    @Composable
    internal fun elevation(): Dp = elevation

    @Composable
    internal fun borderStrokeWidth(): Dp = borderStrokeWidth
}
