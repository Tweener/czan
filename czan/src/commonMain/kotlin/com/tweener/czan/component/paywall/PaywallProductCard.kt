package com.tweener.czan.component.paywall

/**
 * @author Vivien Mahe
 * @since 16/01/2025
 */

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan._internal.kotlinextensions.clickableRipple
import com.tweener.czan._internal.kotlinextensions.conditional
import com.tweener.czan.designsystem.atom.radiobutton.RadioButton
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size

@Composable
fun PaywallProductCard(
    productTitle: String,
    productAmount: String,
    modifier: Modifier = Modifier,
    productHeadline: String? = null,
    productAmountHeadline: String? = null,
    promoTagText: String? = null,
    selected: Boolean = false,
    shape: Shape = PaywallProductCardDefaults.shape,
    colors: PaywallProductCardColors = PaywallProductCardDefaults.colors(),
    sizes: PaywallProductCardSizes = PaywallProductCardDefaults.sizes(),
    onClick: (() -> Unit)? = null,
) {
    val cardBorderColor = if (selected) colors.selectedBorderStrokeColor() else colors.borderStrokeColor()

    Card(
        modifier = modifier,
        shape = shape,
        colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = colors.containerColor()),
        border = BorderStroke(width = sizes.borderStrokeWidth(), color = cardBorderColor),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickableRipple { onClick?.invoke() }
                .padding(sizes.contentPadding()),
            horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(checked = selected, onCheckedChange = { onClick?.invoke() })

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = productTitle,
                            color = colors.productTitleColor(),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium,
                        )

                        promoTagText?.let {
                            Box(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(sizes.promoTagRoundedCornerSize()))
                                    .conditional(
                                        condition = colors.promoTagContainerBrush() != null,
                                        ifTrue = { background(colors.promoTagContainerBrush()!!) },
                                        ifFalse = { background(colors.promoTagContainerColor()) },
                                    )
                                    .padding(sizes.promoTagPadding()),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = it,
                                    color = colors.promoTagContentColor(),
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Medium,
                                )
                            }
                        }
                    }

                    productHeadline?.let {
                        Text(
                            text = it,
                            color = colors.productHeadlineColor(),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
                    horizontalAlignment = Alignment.End,
                ) {
                    Text(
                        text = productAmount,
                        color = colors.productAmountColor(),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.End,
                    )

                    productAmountHeadline?.let {
                        Text(
                            text = it,
                            color = colors.productAmountHeadlineColor(),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.End,
                        )
                    }
                }
            }
        }
    }
}

object PaywallProductCardDefaults {

    val shape: Shape @Composable get() = MaterialTheme.shapes.large
    private val borderStrokeWidth: Dp = 1.dp

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        borderStrokeColor: Color = MaterialTheme.colorScheme.outline,
        selectedBorderStrokeColor: Color = MaterialTheme.colorScheme.primary,
        productTitleColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        productHeadlineColor: Color = MaterialTheme.colorScheme.onBackground,
        productAmountColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        productAmountHeadlineColor: Color = MaterialTheme.colorScheme.onBackground,
        promoTagContainerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
        promoTagContainerBrush: Brush? = null,
        promoTagContentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    ): PaywallProductCardColors = PaywallProductCardColors(
        containerColor = containerColor,
        contentColor = contentColor,
        borderStrokeColor = borderStrokeColor,
        selectedBorderStrokeColor = selectedBorderStrokeColor,
        productTitleColor = productTitleColor,
        productHeadlineColor = productHeadlineColor,
        productAmountColor = productAmountColor,
        productAmountHeadlineColor = productAmountHeadlineColor,
        promoTagContainerColor = promoTagContainerColor,
        promoTagContainerBrush = promoTagContainerBrush,
        promoTagContentColor = promoTagContentColor,
    )


    @Composable
    fun sizes(
        contentPadding: PaddingValues = PaddingValues(top = Size.Padding.Default, end = Size.Padding.Large, bottom = Size.Padding.Default, start = Size.Padding.Small),
        borderStrokeWidth: Dp = PaywallProductCardDefaults.borderStrokeWidth,
        promoTagRoundedCornerSize: Dp = Size.Padding.Small,
        promoTagPadding: PaddingValues = PaddingValues(horizontal = Size.Padding.ExtraSmall, vertical = Size.Padding.Tiny),
    ): PaywallProductCardSizes = PaywallProductCardSizes(
        contentPadding = contentPadding,
        borderStrokeWidth = borderStrokeWidth,
        promoTagRoundedCornerSize = promoTagRoundedCornerSize,
        promoTagPadding = promoTagPadding,
    )
}

@Immutable
class PaywallProductCardColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
    private val borderStrokeColor: Color,
    private val selectedBorderStrokeColor: Color,
    private val productTitleColor: Color,
    private val productHeadlineColor: Color,
    private val productAmountColor: Color,
    private val productAmountHeadlineColor: Color,
    private val promoTagContainerColor: Color,
    private val promoTagContainerBrush: Brush?,
    private val promoTagContentColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun contentColor(): Color = contentColor

    @Composable
    internal fun borderStrokeColor(): Color = borderStrokeColor

    @Composable
    internal fun selectedBorderStrokeColor(): Color = selectedBorderStrokeColor

    @Composable
    internal fun productTitleColor(): Color = productTitleColor

    @Composable
    internal fun productHeadlineColor(): Color = productHeadlineColor

    @Composable
    internal fun productAmountColor(): Color = productAmountColor

    @Composable
    internal fun productAmountHeadlineColor(): Color = productAmountHeadlineColor

    @Composable
    internal fun promoTagContainerColor(): Color = promoTagContainerColor

    @Composable
    internal fun promoTagContainerBrush(): Brush? = promoTagContainerBrush

    @Composable
    internal fun promoTagContentColor(): Color = promoTagContentColor

}

@Immutable
class PaywallProductCardSizes internal constructor(
    private val contentPadding: PaddingValues,
    private val borderStrokeWidth: Dp,
    private val promoTagRoundedCornerSize: Dp,
    private val promoTagPadding: PaddingValues,
) {
    @Composable
    internal fun contentPadding(): PaddingValues = contentPadding

    @Composable
    internal fun borderStrokeWidth(): Dp = borderStrokeWidth

    @Composable
    internal fun promoTagRoundedCornerSize(): Dp = promoTagRoundedCornerSize

    @Composable
    internal fun promoTagPadding(): PaddingValues = promoTagPadding
}
