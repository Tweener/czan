package com.tweener.czan.android.designsystem.atom.switch

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

/**
 * @author Vivien Mahe
 * @since 29/08/2023
 */
enum class SwitchStyle {
    PRIMARY,
    SECONDARY,
    TERTIARY;

    val checkedThumbColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.onPrimary
            SECONDARY -> MaterialTheme.colorScheme.onSecondary
            TERTIARY -> MaterialTheme.colorScheme.onTertiary
        }

    val uncheckedThumbColor: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.outline

    val checkedTrackColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.primary
            SECONDARY -> MaterialTheme.colorScheme.secondary
            TERTIARY -> MaterialTheme.colorScheme.tertiary
        }

    val uncheckedTrackColor: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.surfaceVariant

    val checkedIconColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.onPrimaryContainer
            SECONDARY -> MaterialTheme.colorScheme.onSecondaryContainer
            TERTIARY -> MaterialTheme.colorScheme.onTertiaryContainer
        }

    val uncheckedIconColor: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.surfaceVariant
}
