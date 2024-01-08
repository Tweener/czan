package com.tweener.czan.designsystem.molecule.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.tweener.czan.theme.CzanUiDefaults
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 17/10/2023
 */

@Composable
fun CarouselDropShadow(
    modifier: Modifier = Modifier,
    color: Color = CzanUiDefaults.Carousel.dropShadowColor
) {
    val shadowHeight = Size.Padding.Small * 2

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(shadowHeight)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        color.copy(alpha = 0f),
                        color.copy(alpha = CzanUiDefaults.uiDisabledAlpha())
                    )
                )
            )
    )
}
