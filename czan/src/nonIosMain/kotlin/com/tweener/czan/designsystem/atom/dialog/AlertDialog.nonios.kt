package com.tweener.czan.designsystem.atom.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.window.DialogProperties
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text

/**
 * @author Vivien Mahe
 * @since 12/01/2025
 */

@Composable
actual fun AlertDialog(
    title: String,
    message: String,
    confirmButtonLabel: String,
    onConfirmButtonClicked: () -> Unit,
    onDismiss: () -> Unit,
    dismissButtonLabel: String?,
    icon: ImageVector?,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                text = confirmButtonLabel,
                onClick = onConfirmButtonClicked,
            )
        },
        dismissButton = dismissButtonLabel?.let {
            {
                Button(
                    text = it,
                    outlined = true,
                    onClick = onDismiss,
                )
            }
        },
        shape = AlertDialogDefaults.shape,
        title = { Text(text = title) },
        text = { Text(text = message) },
        icon = icon?.let { { Icon(it) } },
        containerColor = AlertDialogDefaults.containerColor,
        properties = DialogProperties(),
    )
}
