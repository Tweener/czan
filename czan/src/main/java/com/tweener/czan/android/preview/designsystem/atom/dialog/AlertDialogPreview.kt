package com.tweener.czan.android.preview.designsystem.atom.dialog

import androidx.compose.runtime.Composable
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.dialog.AlertDialog
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun AlertDialogPreview() {
    CzanThemePreview {
        AlertDialog(
            title = "AlertDialog title",
            confirmButtonLabel = "Confirm",
            dismissButtonLabel = "Cancel",
            onConfirmButtonClicked = {},
            onDismiss = {},
        ) {
            Text(text = "This is a Text component.")
        }
    }
}
