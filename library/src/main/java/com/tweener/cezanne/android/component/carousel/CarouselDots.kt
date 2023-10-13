package com.tweener.cezanne.android.component.carousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.theme.CezanneTheme

/**
 * @author Vivien Mahe
 * @since 12/05/2023
 */

@Composable
fun CarouselDots(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            CarouselDot(isSelected = currentPage == iteration)
        }
    }
}

@UiModePreviews
@Composable
private fun CarouselDotsPreview() {
    CezanneTheme {
        CarouselDots(
            pageCount = 3,
            currentPage = 1
        )
    }
}
