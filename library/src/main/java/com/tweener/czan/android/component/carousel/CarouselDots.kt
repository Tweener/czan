package com.tweener.czan.android.component.carousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.android.theme.CzanTheme

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
    CzanTheme {
        CarouselDots(
            pageCount = 3,
            currentPage = 1
        )
    }
}
