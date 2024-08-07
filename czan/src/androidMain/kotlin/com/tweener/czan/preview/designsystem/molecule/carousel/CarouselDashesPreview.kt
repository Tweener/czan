package com.tweener.czan.preview.designsystem.molecule.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.molecule.carousel.CarouselDashes
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 07/06/2024
 */

@UiModePreviews
@Composable
private fun CarouselDashesPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.background(Color.DarkGray).padding(Size.Padding.Default)) {
            CarouselDashes(
                pageCount = 4,
                currentPage = 1,
                foregroundColor = MaterialTheme.colorScheme.primary,
                backgroundColor = MaterialTheme.colorScheme.background,
                thickness = 8.dp,
            )
        }
    }
}
