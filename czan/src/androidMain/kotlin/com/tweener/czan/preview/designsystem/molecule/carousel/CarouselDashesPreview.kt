package com.tweener.czan.preview.designsystem.molecule.carousel

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.molecule.carousel.CarouselDashes
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 07/06/2024
 */

@UiModePreviews
@Composable
private fun CarouselDashesPreview() {
    CzanThemePreview {
        CarouselDashes(
            pageCount = 4,
            foregroundColor = MaterialTheme.colorScheme.primary,
            backgroundColor = MaterialTheme.colorScheme.background,
            thickness = 8.dp,
        )
    }
}
