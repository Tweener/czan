package com.tweener.cezanne.android.component.carousel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tweener.cezanne.android.component.text.Text
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.system.CezanneUiDefaults
import com.tweener.cezanne.android.theme.CezanneTheme
import com.tweener.cezanne.android.theme.Size
import kotlin.time.Duration
import kotlinx.coroutines.delay

/**
 * @author Vivien Mahe
 * @since 13/05/2023
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(
    itemsCount: Int,
    modifier: Modifier = Modifier,
    userScrollEnabled: Boolean = true,
    showDots: Boolean = true,
    animationType: CarouselAnimationType = CarouselAnimationType.NONE,
    slideDuration: Duration = CezanneUiDefaults.Carousel.slideDuration(),
    pagerState: PagerState = rememberPagerState { itemsCount },
    itemContent: @Composable (index: Int) -> Unit,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    var pageIndex by remember { mutableIntStateOf(0) }

    if (animationType != CarouselAnimationType.NONE) {
        LaunchedEffect(pageIndex) {
            delay(slideDuration)

            val newPageIndex = (pagerState.currentPage + 1) % itemsCount
            if (newPageIndex != 0 || animationType != CarouselAnimationType.ONE_TIME) {
                pagerState.animateScrollToPage(newPageIndex)
                pageIndex = newPageIndex
            }
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState,
            pageSpacing = Size.Padding.Default,
            userScrollEnabled = userScrollEnabled
        ) { index ->
            itemContent(index)
        }

        if (showDots) {
            Spacer(modifier = Modifier.padding(vertical = Size.Padding.ExtraSmall))

            CarouselDots(
                modifier = Modifier.fillMaxWidth(),
                pageCount = itemsCount,
                currentPage = if (isDragged) pagerState.currentPage else pagerState.targetPage,
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@UiModePreviews
@Composable
private fun CarouselWithDotsPreview() {
    CezanneTheme {
        Carousel(itemsCount = 5) {
            Text("Page $it")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@UiModePreviews
@Composable
private fun CarouselWithoutDotsPreview() {
    CezanneTheme {
        Carousel(
            itemsCount = 5,
            showDots = false
        ) {
            Text("Page $it")
        }
    }
}
