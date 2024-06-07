package com.tweener.czan.designsystem.molecule.carousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    initialPage: Int = 0,
    backgroundColor: Color = foregroundColor.copy(alpha = 0.16f),
    thickness: Dp = 4.dp,
    durationMillis: Int = 5000,
    paused: Boolean = false,
    onFinished: (() -> Unit)? = null,
) {
    var currentPage by remember { mutableStateOf(initialPage) }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
    ) {
        repeat(pageCount) { iteration ->
            CarouselDash(
                modifier = Modifier.weight(1f),
                initialProgress = if (iteration < currentPage) 1f else 0f,
                paused = paused || iteration != currentPage,
                foregroundColor = foregroundColor,
                backgroundColor = backgroundColor,
                thickness = thickness,
                durationMillis = durationMillis,
                onFinished = {
                    when (currentPage) {
                        pageCount - 1 -> onFinished?.invoke()
                        else -> currentPage++
                    }
                },
            )
        }
    }
}
