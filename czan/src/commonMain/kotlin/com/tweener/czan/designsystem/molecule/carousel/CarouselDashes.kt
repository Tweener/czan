package com.tweener.czan.designsystem.molecule.carousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 07/06/2024
 */

@Composable
fun CarouselDashes(
    pageCount: Int,
    foregroundColor: Color,
    modifier: Modifier = Modifier,
    currentPage: Int = 0,
    backgroundColor: Color = foregroundColor.copy(alpha = 0.16f),
    thickness: Dp = 4.dp,
    animated: Boolean = true,
    durationMillis: Int = 5000,
    paused: Boolean = false,
    onPageFinished: ((Int) -> Unit)? = null,
    onCarouselFinished: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
    ) {
        repeat(pageCount) { pageIndex ->
            val state = when {
                pageIndex < currentPage -> CarouselDashState.FINISHED
                pageIndex == currentPage && animated -> CarouselDashState.IN_PROGRESS
                pageIndex == currentPage && animated.not() -> CarouselDashState.FINISHED
                else -> CarouselDashState.NOT_STARTED
            }

            CarouselDash(
                modifier = Modifier.weight(1f),
                state = state,
                paused = paused || state != CarouselDashState.IN_PROGRESS,
                foregroundColor = foregroundColor,
                backgroundColor = backgroundColor,
                thickness = thickness,
                durationMillis = durationMillis,
                onFinished = {
                    when (currentPage) {
                        pageCount - 1 -> onCarouselFinished?.invoke()
                        else -> onPageFinished?.invoke(currentPage)
                    }
                },
            )
        }
    }
}
