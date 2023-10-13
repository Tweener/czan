package com.tweener.cezanne.android.component.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.theme.CezanneTheme
import com.tweener.cezanne.android.theme.Size

/**
 * @author Vivien Mahe
 * @since 12/05/2023
 */

@Composable
fun CarouselDot(
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val color = when (isSelected) {
        true -> MaterialTheme.colorScheme.primary
        false -> MaterialTheme.colorScheme.outlineVariant
    }

    Box(
        modifier = modifier
            .padding(Size.Padding.ExtraTiny)
            .clip(CircleShape)
            .background(color)
            .size(Size.Padding.ExtraSmall)
    )
}

@UiModePreviews
@Composable
private fun CarouselDotSelectedPreview() {
    CezanneTheme {
        CarouselDot(
            isSelected = true
        )
    }
}

@UiModePreviews
@Composable
private fun CarouselDotNotSelectedPreview() {
    CezanneTheme {
        CarouselDot(
            isSelected = false
        )
    }
}
