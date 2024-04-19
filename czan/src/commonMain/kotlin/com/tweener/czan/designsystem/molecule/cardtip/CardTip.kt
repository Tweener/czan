package com.tweener.czan.designsystem.molecule.cardtip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.tweener.czan.theme.Size
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

/**
 * @author Vivien Mahe
 * @since 18/04/2024
 */

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CardTip(
    text: StringResource,
    icon: DrawableResource,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: Dp = CardDefaults.elevation,
    borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    iconTint: Color = colors.contentColor(),
    contentPadding: Dp = Size.Padding.Default,
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
        icon = { Icon(resource = icon, tint = iconTint) },
        shape = shape,
        colors = colors,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
        contentPadding = contentPadding,
    )
}

@Composable
fun CardTip(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: Dp = CardDefaults.elevation,
    borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    iconTint: Color = colors.contentColor(),
    contentPadding: Dp = Size.Padding.Default,
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
        icon = { Icon(imageVector = icon, tint = iconTint) },
        shape = shape,
        colors = colors,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
        contentPadding = contentPadding,
    )
}

@Composable
private fun CardTip(
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: Dp = CardDefaults.elevation,
    borderStrokeWidth: Dp = CardDefaults.borderStrokeWidth,
    contentPadding: Dp = Size.Padding.Default,
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = colors,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
        contentPadding = contentPadding,
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
