package com.tweener.czan.designsystem.organism.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
    border: BorderStroke? = null,
    contentPadding: Dp = Size.Padding.Default,
    header: @Composable (() -> Unit)? = null,
    footer: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = colors.containerColor()),
        elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = elevation),
        border = border,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Header, if provided
            if (header != null) {
                Box(modifier = Modifier.fillMaxWidth().padding(contentPadding)) {
                    header()
                }

                HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = colors.dividerColor())
            }

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

object CardDefaults {

    val shape: Shape @Composable get() = MaterialTheme.shapes.large

    val elevation: Dp = 0.dp

    @Composable
    fun cardColors(
        containerColor: Color = MaterialTheme.colorScheme.background,
        dividerColor: Color = MaterialTheme.colorScheme.outline,
    ): CardColors = CardColors(
        containerColor = containerColor,
        dividerColor = dividerColor,
    )
}

@Immutable
class CardColors internal constructor(
    private val containerColor: Color,
    private val dividerColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun dividerColor(): Color = dividerColor
}
