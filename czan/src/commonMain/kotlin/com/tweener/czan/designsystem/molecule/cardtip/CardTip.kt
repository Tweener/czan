package com.tweener.czan.designsystem.molecule.cardtip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
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
    colors: CardColors = CardDefaults.cardColors(),
    sizes: CardSizes = CardDefaults.cardSizes(),
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
    colors: CardColors = CardDefaults.cardColors(),
    sizes: CardSizes = CardDefaults.cardSizes(),
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
    colors: CardColors = CardDefaults.cardColors(),
    sizes: CardSizes = CardDefaults.cardSizes(),
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
