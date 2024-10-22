package com.tweener.czan.preview.designsystem.molecule.cardtip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.molecule.cardtip.CardTip
import com.tweener.czan.designsystem.organism.card.CardDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 18/04/2024
 */

@UiModePreviews
@Composable
private fun CardTipPreview() {
    CzanThemePreview {
        CardTip(
            text = "This is a CardTip which displays a Card that contains a leading icon and a multi-lines text.",
            icon = Icons.Default.Lightbulb,
        )
    }
}

@UiModePreviews
@Composable
private fun CardTipChangePropertiesPreview() {
    CzanThemePreview {
        CardTip(
            text = "This is a CardTip which displays a Card that contains a leading icon and a multi-lines text.",
            icon = Icons.Default.Lightbulb,
            textStyle = MaterialTheme.typography.titleSmall,
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                borderStrokeColor = MaterialTheme.colorScheme.onPrimaryContainer,
                iconTint = MaterialTheme.colorScheme.tertiary,
            ),
            sizes = CardDefaults.cardSizes(
                borderStrokeWidth = 1.dp,
                contentPadding = PaddingValues(Size.Padding.Large),
            ),
        )
    }
}
