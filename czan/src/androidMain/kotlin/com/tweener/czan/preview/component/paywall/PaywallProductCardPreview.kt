package com.tweener.czan.preview.component.paywall

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.tweener.czan.component.paywall.PaywallProductCard
import com.tweener.czan.component.paywall.PaywallProductCardDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 16/01/2025
 */

@UiModePreviews
@Composable
private fun PaywallProductCardSelectedPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            PaywallProductCard(
                selected = true,
                productTitle = "Monthly",
                productHeadline = "7-day free trial",
                productAmount = "1.99 €",
                productAmountHeadline = "per month",
                colors = PaywallProductCardDefaults.colors(),
                sizes = PaywallProductCardDefaults.sizes(selectedBorderStrokeWidth = 2.dp),
            )
        }
    }
}

@UiModePreviews
@Composable
private fun PaywallProductCardNotSelectedPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            PaywallProductCard(
                selected = false,
                productTitle = "Monthly",
                productAmount = "1.99 €",
                productAmountHeadline = "per month",
                colors = PaywallProductCardDefaults.colors(),
                sizes = PaywallProductCardDefaults.sizes(borderStrokeWidth = 1.dp),
            )
        }
    }
}

@UiModePreviews
@Composable
private fun PaywallProductCardWithPromoChipPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            PaywallProductCard(
                selected = true,
                productTitle = "Monthly",
                productHeadline = "7-day free trial",
                productAmount = "1.99 €",
                productAmountHeadline = "per month",
                promoTagText = "50% OFF!",
                colors = PaywallProductCardDefaults.colors(
                    promoTagContainerColor = MaterialTheme.colorScheme.errorContainer,
                    promoTagContentColor = MaterialTheme.colorScheme.onErrorContainer,
                ),
            )
        }
    }
}

@UiModePreviews
@Composable
private fun PaywallProductCardWithPromoChipBrushPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            PaywallProductCard(
                selected = true,
                productTitle = "Monthly",
                productHeadline = "A very long headline text to see how it behaves",
                productAmount = "1.99 €",
                promoTagText = "50% OFF!",
                colors = PaywallProductCardDefaults.colors(
                    promoTagContainerBrush = Brush.linearGradient(
                        0.0f to MaterialTheme.colorScheme.errorContainer,
                        1.0f to MaterialTheme.colorScheme.primaryContainer,
                        start = Offset.Zero,
                        end = Offset.Infinite
                    ),
                    promoTagContentColor = MaterialTheme.colorScheme.onErrorContainer,
                ),
            )
        }
    }
}
