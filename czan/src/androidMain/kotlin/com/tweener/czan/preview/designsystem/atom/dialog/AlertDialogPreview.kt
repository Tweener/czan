package com.tweener.czan.preview.designsystem.atom.dialog

import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.dialog.AlertDialog
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun AlertDialogOnlyConfirmButtonPreview() {
    CzanThemePreview {
        AlertDialog(
            title = "AlertDialog title",
            message = "This is a Text component.",
            confirmButtonLabel = "Confirm",
            onConfirmButtonClicked = {},
            onDismiss = {},
        )
    }
}

@UiModePreviews
@Composable
private fun AlertDialogWithDismissButtonPreview() {
    CzanThemePreview {
        AlertDialog(
            title = "AlertDialog title",
            message = "This is a Text component.",
            confirmButtonLabel = "Confirm",
            dismissButtonLabel = "Cancel",
            onConfirmButtonClicked = {},
            onDismiss = {},
        )
    }
}
