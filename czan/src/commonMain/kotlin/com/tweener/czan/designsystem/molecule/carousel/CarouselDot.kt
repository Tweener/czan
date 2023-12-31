package com.tweener.czan.designsystem.molecule.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 12/05/2023
 */

@Composable
fun CarouselDot(
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val color = when (isSelected) {
        true -> MaterialTheme.colorScheme.primary
        false -> MaterialTheme.colorScheme.outlineVariant
    }

    Box(
        modifier = modifier
            .padding(Size.Padding.ExtraTiny)
            .clip(CircleShape)
            .background(color)
            .size(Size.Padding.ExtraSmall)
    )
}

//@PreviewLightDark
//@Composable
//private fun CarouselDotSelectedPreview() {
//    CzanThemePreview {
//        CarouselDot(
//            isSelected = true
//        )
//    }
//}
//
//@PreviewLightDark
//@Composable
//private fun CarouselDotNotSelectedPreview() {
//    CzanThemePreview {
//        CarouselDot(
//            isSelected = false
//        )
//    }
//}
