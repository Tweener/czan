package com.tweener.cezanne.android.component.button

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import com.tweener.cezanne.android.system.CezanneUiDefaults

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
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.primary.copy(alpha = CezanneUiDefaults.uiDisabledAlpha())
            SECONDARY -> MaterialTheme.colorScheme.secondary.copy(alpha = CezanneUiDefaults.uiDisabledAlpha())
            TERTIARY -> MaterialTheme.colorScheme.tertiary.copy(alpha = CezanneUiDefaults.uiDisabledAlpha())
            ERROR -> MaterialTheme.colorScheme.error.copy(alpha = CezanneUiDefaults.uiDisabledAlpha())
        }

    val disabledContentColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.onPrimary.copy(alpha = CezanneUiDefaults.uiDisabledAlpha())
            SECONDARY -> MaterialTheme.colorScheme.onSecondary.copy(alpha = CezanneUiDefaults.uiDisabledAlpha())
            TERTIARY -> MaterialTheme.colorScheme.onTertiary.copy(alpha = CezanneUiDefaults.uiDisabledAlpha())
            ERROR -> MaterialTheme.colorScheme.onError.copy(alpha = CezanneUiDefaults.uiDisabledAlpha())
        }
}
