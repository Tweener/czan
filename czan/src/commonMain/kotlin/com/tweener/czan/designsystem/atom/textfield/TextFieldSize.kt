package com.tweener.czan.designsystem.atom.textfield

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Vivien Mahe
 * @since 04/04/2024
 */
enum class TextFieldSize {
    BIG,
    REGULAR,
    SMALL;

    companion object {
        private val BigTextFieldHeight = 84.dp
        private val TextFieldHeight = 52.dp
        private val SmallTextFieldHeight = 44.dp

        private val BigTextFieldIconSize = 44.dp
        private val TextFieldIconSize = 24.dp
        private val SmallTextFieldIconSize = 12.dp
    }

    val textStyle: TextStyle // Used for both text and placeholder
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            BIG -> MaterialTheme.typography.displayMedium
            REGULAR -> MaterialTheme.typography.titleMedium
            SMALL -> MaterialTheme.typography.labelMedium
        }

    val height: Dp
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            BIG -> BigTextFieldHeight
            REGULAR -> TextFieldHeight
            SMALL -> SmallTextFieldHeight
        }

    val shape: Shape
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            BIG -> CircleShape
            REGULAR -> MaterialTheme.shapes.extraLarge
            SMALL -> MaterialTheme.shapes.large
        }

    val iconSize: Dp
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            BIG -> BigTextFieldIconSize
            REGULAR -> TextFieldIconSize
            SMALL -> SmallTextFieldIconSize
        }
}
