package com.tweener.czan.designsystem.atom.button

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import com.tweener.czan.theme.CzanUiDefaults

/**
 * @author Vivien Mahe
 * @since 24/08/2023
 */
enum class ButtonStyle {
    PRIMARY,
    SECONDARY,
    TERTIARY,
    ERROR;

    val containerColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.primary
            SECONDARY -> MaterialTheme.colorScheme.secondary
            TERTIARY -> MaterialTheme.colorScheme.tertiary
            ERROR -> MaterialTheme.colorScheme.error
        }

    val contentColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.onPrimary
            SECONDARY -> MaterialTheme.colorScheme.onSecondary
            TERTIARY -> MaterialTheme.colorScheme.onTertiary
            ERROR -> MaterialTheme.colorScheme.onError
        }

    val disabledContainerColor: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)

    val disabledContentColor: Color
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme.onSurface.copy(alpha = CzanUiDefaults.uiDisabledAlpha())
}
