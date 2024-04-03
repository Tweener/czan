package com.tweener.czan.designsystem.molecule.menu.contextmenu

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

/**
 * @author Vivien Mahe
 * @since 01/04/2024
 */

@Immutable
object CupertinoMenuContextDefaults {

    @Composable
    @ReadOnlyComposable
    fun colors(
        contentColor: Color = MaterialTheme.colorScheme.onSurface,
        disabledContextColor: Color = MaterialTheme.colorScheme.outline,
    ): CupertinoMenuItemColors = CupertinoMenuItemColors(
        contentColor = contentColor,
        disabledContentColor = disabledContextColor,
    )
}

@Immutable
data class CupertinoMenuItemColors internal constructor(
    private val contentColor: Color,
    private val disabledContentColor: Color,
) {
    /**
     * Represents the content color passed to the icon if used.
     *
     * @param enabled whether the item is enabled or not
     */
    @Composable
    internal fun contentColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(
            if (enabled) {
                contentColor
            } else {
                disabledContentColor
            }
        )
    }
}
