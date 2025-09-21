package com.tweener.czan.preview.designsystem.organism.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.organism.card.Card
import com.tweener.czan.designsystem.organism.card.CardDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 12/03/2024
 */

@UiModePreviews
@Composable
private fun CardPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
                sizes = CardDefaults.sizes(
                    elevation = 0.dp,
                    contentPadding = PaddingValues(Size.Padding.Small),
                ),
            ) {
                Text(text = "This is a Card with a simple Text")
            }
        }
    }
}

@UiModePreviews
@Composable
private fun CardWithHeaderPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            Card(
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    dividerColor = MaterialTheme.colorScheme.outline,
                    borderStrokeColor = MaterialTheme.colorScheme.outline,
                ),
                sizes = CardDefaults.sizes(
                    elevation = 12.dp,
                    contentPadding = PaddingValues(Size.Padding.Small),
                    borderStrokeWidth = 1.dp,
                ),
                header = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "This is a the Card's title")
                        Text(text = "And this is a the Card's headline")
                    }
                },
                showDividers = false,
            ) {
                Text(text = "This is the Cards' content")
            }
        }
    }
}

@UiModePreviews
@Composable
private fun CardWithFooterPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                sizes = CardDefaults.sizes(
                    elevation = 4.dp,
                    contentPadding = PaddingValues(Size.Padding.Small),
                ),
                footer = { Text(text = "This is a footer") },
            ) {
                Text(text = "This is a Card with a simple Text")
            }
        }
    }
}

@UiModePreviews
@Composable
private fun CardWithHeaderAndFooterPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.colors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                sizes = CardDefaults.sizes(
                    elevation = 4.dp,
                    contentPadding = PaddingValues(Size.Padding.Small),
                ),
                header = { Text(text = "This is a header") },
                footer = { Text(text = "This is a footer") },
            ) {
                Text(text = "This is a Card with a simple Text")
            }
        }
    }
}
