package com.tweener.czan.designsystem.atom.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.github.alexzhirkevich.cupertino.CupertinoScaffoldDefaults
import io.github.alexzhirkevich.cupertino.FabPosition
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveScaffold
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import io.github.alexzhirkevich.cupertino.theme.CupertinoTheme

/**
 * @author Vivien Mahe
 * @since 20/02/2024
 */

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun Scaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    navigationBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    containerColor: Color = CupertinoTheme.colorScheme.systemBackground,
    contentColor: Color = CupertinoTheme.colorScheme.label,
    contentWindowInsets: WindowInsets = CupertinoScaffoldDefaults.contentWindowInsets,
    content: @Composable (PaddingValues) -> Unit
) {
    AdaptiveScaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = navigationBar,
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        containerColor = containerColor,
        contentColor = contentColor,
        contentWindowInsets = contentWindowInsets,
        content = content
    )
}
