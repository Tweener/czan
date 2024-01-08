package com.tweener.czan.preview.designsystem.molecule.carousel

import androidx.compose.runtime.Composable
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.carousel.CarouselDots
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun CarouselDotsPreview() {
    CzanThemePreview {
        CarouselDots(
            pageCount = 3,
            currentPage = 1
        )
    }
}
