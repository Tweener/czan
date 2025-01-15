package com.tweener.czan.designsystem.atom.snackbar

/**
 * @author Vivien Mahe
 * @since 15/01/2025
 */

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

@Composable
fun rememberSnackbarHostState(): SnackbarHostState = remember { SnackbarHostState() }

@Composable
fun Snackbar(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    actionOnNewLine: Boolean = false,
    shape: Shape = SnackbarDefaults.shape,
    colors: SnackbarColors = SnackbarDefaults.snackbarColors(),
) {
    SnackbarHost(
        modifier = modifier,
        hostState = hostState,
        snackbar = { data ->
            Snackbar(
                snackbarData = data,
                actionOnNewLine = actionOnNewLine,
                shape = shape,
                containerColor = colors.containerColor(),
                contentColor = colors.contentColor(),
                actionColor = colors.actionColor(),
                actionContentColor = colors.actionContentColor(),
                dismissActionContentColor = colors.dismissActionContentColor(),
            )
        }
    )
}

object SnackbarDefaults {

    val shape: Shape @Composable get() = MaterialTheme.shapes.extraSmall

    @Composable
    fun snackbarColors(
        containerColor: Color = MaterialTheme.colorScheme.inverseSurface,
        contentColor: Color = MaterialTheme.colorScheme.inverseOnSurface,
        actionColor: Color = MaterialTheme.colorScheme.inversePrimary,
        actionContentColor: Color = MaterialTheme.colorScheme.inversePrimary,
        dismissActionContentColor: Color = MaterialTheme.colorScheme.inverseOnSurface,
    ): SnackbarColors = SnackbarColors(
        containerColor = containerColor,
        contentColor = contentColor,
        actionColor = actionColor,
        actionContentColor = actionContentColor,
        dismissActionContentColor = dismissActionContentColor,
    )
}

@Immutable
class SnackbarColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
    private val actionColor: Color,
    private val actionContentColor: Color,
    private val dismissActionContentColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun contentColor(): Color = contentColor

    @Composable
    internal fun actionColor(): Color = actionColor

    @Composable
    internal fun actionContentColor(): Color = actionContentColor

    @Composable
    internal fun dismissActionContentColor(): Color = dismissActionContentColor
}
