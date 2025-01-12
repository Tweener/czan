package com.tweener.czan.designsystem.atom.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication

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
    content: @Composable () -> Unit,
) {
    UIApplication.sharedApplication.keyWindow?.rootViewController?.let { rootViewController ->
        val alert = UIAlertController.alertControllerWithTitle(
            title = title,
            message = message,
            preferredStyle = UIAlertControllerStyleAlert
        )

        val action = UIAlertAction.actionWithTitle(
            title = confirmButtonLabel,
            style = UIAlertActionStyleDefault,
            handler = { onDismiss() }
        )

        alert.addAction(action)

        rootViewController.presentViewController(alert, animated = true, completion = null)
    }
}
