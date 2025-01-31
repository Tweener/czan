package com.tweener.czan.designsystem.molecule.cardtip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.organism.card.Card
import com.tweener.czan.designsystem.organism.card.CardColors
import com.tweener.czan.designsystem.organism.card.CardDefaults
import com.tweener.czan.designsystem.organism.card.CardSizes
import com.tweener.czan.theme.Size
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

/**
 * @author Vivien Mahe
 * @since 18/04/2024
 */

@Composable
fun CardTip(
    text: StringResource,
    icon: DrawableResource,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
    shape: Shape = CardDefaults.shape,
    colors: CardTipColors = CardTipDefaults.colors(),
    sizes: CardTipSizes = CardTipDefaults.sizes(),
) {
    CardTip(
        modifier = modifier,
        text = {
            Text(
                text = stringResource(resource = text),
                style = textStyle,
                color = colors.contentColor(),
            )
        },
        icon = { Icon(resource = icon, tint = colors.iconTint()) },
        shape = shape,
        colors = colors,
        sizes = sizes,
    )
}

@Composable
fun CardTip(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
    shape: Shape = CardDefaults.shape,
    colors: CardTipColors = CardTipDefaults.colors(),
    sizes: CardTipSizes = CardTipDefaults.sizes(),
) {
    CardTip(
        modifier = modifier,
        text = {
            Text(
                text = text,
                style = textStyle,
                color = colors.contentColor(),
            )
        },
        icon = { Icon(imageVector = icon, tint = colors.iconTint()) },
        shape = shape,
        colors = colors,
        sizes = sizes,
    )
}

@Composable
private fun CardTip(
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.shape,
    colors: CardTipColors = CardTipDefaults.colors(),
    sizes: CardTipSizes = CardTipDefaults.sizes(),
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = colors,
        sizes = sizes,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
            verticalAlignment = Alignment.Top,
        ) {
            icon()
            text()
        }
    }
}

object CardTipDefaults {

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.background,
        containerBrush: Brush? = null,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        borderStrokeColor: Color = Color.Transparent,
        dividerColor: Color = MaterialTheme.colorScheme.outline,
        iconTint: Color = contentColor,
    ): CardTipColors = CardTipColors(
        containerColor = containerColor,
        containerBrush = containerBrush,
        contentColor = contentColor,
        borderStrokeColor = borderStrokeColor,
        dividerColor = dividerColor,
        iconTint = iconTint,
    )

    @Composable
    fun sizes(
        contentPadding: PaddingValues = PaddingValues(all = Size.Padding.Default),
        elevation: Dp = CardDefaults.elevation,
        borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    ): CardTipSizes = CardTipSizes(
        contentPadding = contentPadding,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
    )
}

@Immutable
class CardTipColors internal constructor(
    containerColor: Color,
    containerBrush: Brush?,
    contentColor: Color,
    borderStrokeColor: Color,
    dividerColor: Color,
    private val iconTint: Color,
) : CardColors(
    containerColor = containerColor,
    containerBrush = containerBrush,
    contentColor = contentColor,
    borderStrokeColor = borderStrokeColor,
    dividerColor = dividerColor,
) {
    @Composable
    internal fun iconTint(): Color = iconTint
}

@Immutable
class CardTipSizes internal constructor(
    contentPadding: PaddingValues,
    elevation: Dp,
    borderStrokeWidth: Dp,
) : CardSizes(
    contentPadding = contentPadding,
    elevation = elevation,
    borderStrokeWidth = borderStrokeWidth,
)
