package com.tweener.czan.preview.designsystem.molecule.carousel

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.molecule.carousel.Carousel
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun CarouselWithDotsPreview() {
    CzanThemePreview {
        Carousel(pagerState = rememberPagerState { 4 }) {
            Text("Page $it")
        }
    }
}

@UiModePreviews
@Composable
private fun CarouselWithoutDotsPreview() {
    CzanThemePreview {
        Carousel(
            pagerState = rememberPagerState { 4 },
            showDots = false
        ) {
            Text("Page $it")
        }
    }
}
