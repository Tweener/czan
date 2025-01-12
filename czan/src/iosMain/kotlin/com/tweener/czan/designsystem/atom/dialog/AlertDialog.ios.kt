package com.tweener.czan.designsystem.atom.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.tweener.czan.rootViewController
import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleCancel
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert

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
    val alert = UIAlertController.alertControllerWithTitle(
        title = title,
        message = message,
        preferredStyle = UIAlertControllerStyleAlert,
    )

    // Confirm button
    alert.addAction(
        UIAlertAction.actionWithTitle(
            title = confirmButtonLabel,
            style = UIAlertActionStyleDefault,
            handler = { onConfirmButtonClicked() },
        )
    )

    // Dismiss button
    dismissButtonLabel?.let {
        alert.addAction(
            UIAlertAction.actionWithTitle(
                title = it,
                style = UIAlertActionStyleCancel,
                handler = { onDismiss() },
            )
        )
    }

    rootViewController?.presentViewController(alert, animated = true, completion = null)
}
