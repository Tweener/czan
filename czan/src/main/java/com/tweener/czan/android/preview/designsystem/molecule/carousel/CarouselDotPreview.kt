package com.tweener.czan.android.preview.designsystem.molecule.carousel

import androidx.compose.runtime.Composable
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.carousel.CarouselDot
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun CarouselDotSelectedPreview() {
    CzanThemePreview {
        CarouselDot(
            isSelected = true
        )
    }
}

@UiModePreviews
@Composable
private fun CarouselDotNotSelectedPreview() {
    CzanThemePreview {
        CarouselDot(
            isSelected = false
        )
    }
}
