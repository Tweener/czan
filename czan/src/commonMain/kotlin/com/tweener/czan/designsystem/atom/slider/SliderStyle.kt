package com.tweener.czan.designsystem.atom.slider

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

/**
 * @author Vivien Mahe
 * @since 25/10/2024
 */

enum class SliderStyle {
    PRIMARY,
    SECONDARY,
    TERTIARY;

    val thumbColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.primary
            SECONDARY -> MaterialTheme.colorScheme.secondary
            TERTIARY -> MaterialTheme.colorScheme.tertiary
        }

    val activeTrackColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.primary
            SECONDARY -> MaterialTheme.colorScheme.secondary
            TERTIARY -> MaterialTheme.colorScheme.tertiary
        }

    val inactiveTrackColor: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.outline
}
