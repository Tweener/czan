package com.tweener.czan.preview.designsystem.organism.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandCircleDown
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.organism.card.CardDefaults
import com.tweener.czan.designsystem.organism.card.ExpandableCard
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 12/03/2024
 */

@UiModePreviews
@Composable
private fun ExpandableCardCollapsedPreview() {
    CzanThemePreview {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Size.Padding.Default)
        ) {
            ExpandableCard(
                collapsedIcon = Icons.Outlined.ExpandCircleDown,
                expanded = false,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                elevation = 4.dp,
                contentPadding = Size.Padding.Small,
                header = { Text(text = "This is a header") },
                footer = { Text(text = "This is a footer") },
            ) {
                Text(text = "This is a Card with a simple Text")
            }
        }
    }
}

@UiModePreviews
@Composable
private fun ExpandableCardExpandedPreview() {
    CzanThemePreview {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Size.Padding.Default)
        ) {
            ExpandableCard(
                collapsedIcon = Icons.Outlined.ExpandCircleDown,
                expanded = true,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                elevation = 4.dp,
                contentPadding = Size.Padding.Small,
                header = { Text(text = "This is a header") },
                footer = { Text(text = "This is a footer") },
            ) {
                Text(text = "This is a Card with a simple Text")
            }
        }
    }
}
