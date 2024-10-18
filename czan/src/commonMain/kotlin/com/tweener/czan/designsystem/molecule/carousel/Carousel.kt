package com.tweener.czan.designsystem.molecule.carousel

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import com.tweener.czan.theme.CzanUiDefaults
import com.tweener.czan.theme.Size
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration

/**
 * @author Vivien Mahe
 * @since 13/05/2023
 */

@Composable
fun Carousel(
    modifier: Modifier = Modifier,
    userScrollEnabled: Boolean = true,
    userTapHalfScreenEnabled: Boolean = false,
    showDots: Boolean = true,
    pageSpacing: Dp = Size.Padding.Default,
    animationType: CarouselAnimationType = CarouselAnimationType.NONE,
    slideDuration: Duration = CzanUiDefaults.Carousel.slideDuration(),
    pagerState: PagerState = rememberPagerState { 0 },
    onScreenPressed: ((Boolean) -> Unit)? = null,
    itemContent: @Composable (index: Int) -> Unit,
) {
    val tapDelayMillis = 200
    val scope = rememberCoroutineScope()
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    var pageIndex by remember { mutableIntStateOf(0) }

    if (animationType != CarouselAnimationType.NONE) {
        LaunchedEffect(pageIndex) {
            delay(slideDuration)

            val newPageIndex = (pagerState.currentPage + 1) % pagerState.pageCount
            if (newPageIndex != 0 || animationType != CarouselAnimationType.ONE_TIME) {
                pagerState.animateScrollToPage(newPageIndex)
                pageIndex = newPageIndex
            }
        }
    }

    val goToNextStep: () -> Unit = {
        if (pagerState.currentPage - 1 < pagerState.pageCount) {
            scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
        }
    }

    val goToPreviousStep: () -> Unit = {
        if (pagerState.currentPage > 0) {
            scope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) }
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                awaitEachGesture {
                    awaitFirstDown().also { down ->
                        down.consume()
                        onScreenPressed?.invoke(true)
                    }
                    waitForUpOrCancellation()?.also { up ->
                        up.consume()
                        onScreenPressed?.invoke(false)

                        // Only use the "tap half screen" feature is requested
                        if (userTapHalfScreenEnabled) {
                            val pressTime = up.previousUptimeMillis
                            val releaseTime = up.uptimeMillis
                            val pressDuration = releaseTime - pressTime

                            if (pressDuration < tapDelayMillis) {
                                // Press is considered as a tap
                                if (up.position.x >= this@pointerInput.size.width / 2) goToNextStep()
                                else goToPreviousStep()
                            }
                        }
                    }
                }
            }
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState,
            pageSpacing = pageSpacing,
            userScrollEnabled = userScrollEnabled
        ) { index ->
            itemContent(index)
        }

        if (showDots) {
            Spacer(modifier = Modifier.padding(vertical = Size.Padding.ExtraSmall))

            CarouselDots(
                modifier = Modifier.fillMaxWidth(),
                pageCount = pagerState.pageCount,
                currentPage = if (isDragged) pagerState.currentPage else pagerState.targetPage,
            )
        }
    }
}
