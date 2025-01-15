package com.tweener.czan.preview.designsystem.atom.snackbar

/**
 * @author Vivien Mahe
 * @since 15/01/2025
 */

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.scaffold.Scaffold
import com.tweener.czan.designsystem.atom.snackbar.Snackbar
import com.tweener.czan.designsystem.atom.snackbar.SnackbarDefaults
import com.tweener.czan.designsystem.atom.snackbar.rememberSnackbarHostState
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import kotlinx.coroutines.launch

@UiModePreviews
@Composable
private fun SnackbarNoActionPreview() {
    CzanThemePreview {
        val snackbarScope = rememberCoroutineScope()
        val snackbarHostState = rememberSnackbarHostState()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                Snackbar(
                    hostState = snackbarHostState,
                    shape = MaterialTheme.shapes.large,
                    colors = SnackbarDefaults.snackbarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                )
            },
        ) { _ ->
            Button(text = "Show snackbar") {
                snackbarScope.launch {
                    snackbarHostState.showSnackbar(message = "This is a snackbar")
                }
            }
        }
    }
}

@UiModePreviews
@Composable
private fun SnackbarWithActionPreview() {
    CzanThemePreview {
        val snackbarScope = rememberCoroutineScope()
        val snackbarHostState = rememberSnackbarHostState()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                Snackbar(
                    hostState = snackbarHostState,
                    shape = RoundedCornerShape(300.dp),
                    colors = SnackbarDefaults.snackbarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        actionColor = Color.Green,
                        actionContentColor = Color.Red,
                        dismissActionContentColor = Color.Blue,
                    ),
                )
            },
        ) { _ ->
            Button(text = "Show snackbar") {
                snackbarScope.launch {
                    val result = snackbarHostState.showSnackbar(
                        message = "This is a snackbar",
                        actionLabel = "Action",
                        withDismissAction = true,
                    )

                    when (result) {
                        SnackbarResult.ActionPerformed -> {}
                        SnackbarResult.Dismissed -> {}
                    }
                }
            }
        }
    }
}
