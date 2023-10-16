package com.tweener.cezanne.android.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Vivien Mahe
 * @since 24/08/2023
 */
enum class ButtonSize {
    BIG,
    REGULAR,
    SMALL;

    companion object {
        private val BigButtonHeight = 52.dp
        private val ButtonHeight = 40.dp
        private val SmallButtonHeight = 32.dp

        private val BigButtonShape = RoundedCornerShape(36.dp)

        private val SmallButtonHorizontalPadding = 14.dp
        private val SmallButtonVerticalPadding = 8.dp
        private val SmallButtonWithIconHorizontalStartPadding = 12.dp
    }

    val height: Dp
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            BIG -> BigButtonHeight
            REGULAR -> ButtonHeight
            SMALL -> SmallButtonHeight
        }

    val shape: Shape
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            BIG -> BigButtonShape
            REGULAR -> MaterialTheme.shapes.extraLarge
            SMALL -> MaterialTheme.shapes.large
        }

    val textStyle: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            BIG -> MaterialTheme.typography.bodyMedium
            REGULAR -> MaterialTheme.typography.labelLarge
            SMALL -> MaterialTheme.typography.labelMedium
        }

    val contentPadding: PaddingValues
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            BIG -> ButtonDefaults.ContentPadding
            REGULAR -> ButtonDefaults.ContentPadding
            SMALL -> PaddingValues(
                horizontal = SmallButtonHorizontalPadding,
                vertical = SmallButtonVerticalPadding
            )
        }

    val contentWithIconPadding: PaddingValues
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            BIG -> ButtonDefaults.ButtonWithIconContentPadding
            REGULAR -> ButtonDefaults.ButtonWithIconContentPadding
            SMALL -> PaddingValues(
                start = SmallButtonWithIconHorizontalStartPadding,
                top = SmallButtonVerticalPadding,
                end = SmallButtonHorizontalPadding,
                bottom = SmallButtonVerticalPadding
            )
        }
}
