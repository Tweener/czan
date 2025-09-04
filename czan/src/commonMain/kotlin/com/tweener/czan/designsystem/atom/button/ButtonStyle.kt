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
    ON_PRIMARY,
    PRIMARY_CONTAINER,
    SECONDARY,
    ON_SECONDARY,
    SECONDARY_CONTAINER,
    TERTIARY,
    ON_TERTIARY,
    TERTIARY_CONTAINER,
    ERROR;

    val containerColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.primary
            ON_PRIMARY -> MaterialTheme.colorScheme.onPrimary
            PRIMARY_CONTAINER -> MaterialTheme.colorScheme.primaryContainer
            SECONDARY -> MaterialTheme.colorScheme.secondary
            ON_SECONDARY -> MaterialTheme.colorScheme.onSecondary
            SECONDARY_CONTAINER -> MaterialTheme.colorScheme.secondaryContainer
            TERTIARY -> MaterialTheme.colorScheme.tertiary
            ON_TERTIARY -> MaterialTheme.colorScheme.onTertiary
            TERTIARY_CONTAINER -> MaterialTheme.colorScheme.tertiaryContainer
            ERROR -> MaterialTheme.colorScheme.error
        }

    val contentColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> MaterialTheme.colorScheme.onPrimary
            ON_PRIMARY -> MaterialTheme.colorScheme.primary
            PRIMARY_CONTAINER -> MaterialTheme.colorScheme.onPrimaryContainer
            SECONDARY -> MaterialTheme.colorScheme.onSecondary
            ON_SECONDARY -> MaterialTheme.colorScheme.secondary
            SECONDARY_CONTAINER -> MaterialTheme.colorScheme.onSecondaryContainer
            TERTIARY -> MaterialTheme.colorScheme.onTertiary
            ON_TERTIARY -> MaterialTheme.colorScheme.tertiary
            TERTIARY_CONTAINER -> MaterialTheme.colorScheme.onTertiaryContainer
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
