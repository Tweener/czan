package com.tweener.czan.preview.designsystem.molecule.carousel

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.molecule.carousel.CarouselDash
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 07/06/2024
 */

@UiModePreviews
@Composable
private fun CarouselDashNoBackgroundPreview() {
    CzanThemePreview {
        CarouselDash(
            foregroundColor = MaterialTheme.colorScheme.primary,
        )
    }
}

@UiModePreviews
@Composable
private fun CarouselDashWithBackgroundPreview() {
    CzanThemePreview {
        CarouselDash(
            foregroundColor = MaterialTheme.colorScheme.primary,
            backgroundColor = MaterialTheme.colorScheme.background,
        )
    }
}
