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
 * @since 01/09/2023
 */

@Composable
fun AlertDialog(
    title: String,
    confirmButtonLabel: String,
    onConfirmButtonClicked: () -> Unit,
    onDismiss: () -> Unit,
    dismissButtonLabel: String? = null,
    icon: ImageVector? = null,
    content: @Composable () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                text = confirmButtonLabel,
                onClick = onConfirmButtonClicked,
            )
        },
        dismissButton = {
            Button(
                text = dismissButtonLabel,
                outlined = true,
                onClick = onDismiss,
            )
        },
        shape = AlertDialogDefaults.shape,
        title = { Text(text = title) },
        text = content,
        icon = icon?.let { { Icon(it) } },
        containerColor = AlertDialogDefaults.containerColor,
        properties = DialogProperties(),
    )
}
