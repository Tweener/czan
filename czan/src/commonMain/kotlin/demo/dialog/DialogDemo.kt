package demo.dialog

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.button.ButtonStyle
import com.tweener.czan.designsystem.atom.dialog.AlertDialog
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import demo._internal.SectionFlowContent
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun DialogDemo() {
    var showBasicDialog by remember { mutableStateOf(false) }
    var showConfirmOnlyDialog by remember { mutableStateOf(false) }
    var showIconDialog by remember { mutableStateOf(false) }
    var showWarningDialog by remember { mutableStateOf(false) }

    CzanThemePreview {
        PreviewBox {
            Section(title = "Alert Dialogs") {
                SectionFlowContent {
                    Button(
                        text = "Basic Dialog",
                        style = ButtonStyle.PRIMARY,
                        onClick = { showBasicDialog = true }
                    )

                    Button(
                        text = "Confirm Only",
                        style = ButtonStyle.SECONDARY,
                        onClick = { showConfirmOnlyDialog = true }
                    )

                    Button(
                        text = "With Icon",
                        style = ButtonStyle.TERTIARY,
                        onClick = { showIconDialog = true }
                    )

                    Button(
                        text = "Warning Dialog",
                        style = ButtonStyle.ERROR,
                        onClick = { showWarningDialog = true }
                    )
                }
            }
        }

        // Basic dialog with confirm and dismiss buttons
        if (showBasicDialog) {
            AlertDialog(
                title = "Confirm Action",
                message = "Are you sure you want to continue with this action? This cannot be undone.",
                confirmButtonLabel = "Continue",
                dismissButtonLabel = "Cancel",
                onConfirmButtonClicked = { showBasicDialog = false },
                onDismiss = { showBasicDialog = false }
            )
        }

        // Confirm only dialog
        if (showConfirmOnlyDialog) {
            AlertDialog(
                title = "Information",
                message = "This is an informational message that only requires acknowledgment.",
                confirmButtonLabel = "Got it",
                onConfirmButtonClicked = { showConfirmOnlyDialog = false },
                onDismiss = { showConfirmOnlyDialog = false }
            )
        }

        // Dialog with icon
        if (showIconDialog) {
            AlertDialog(
                title = "New Feature Available",
                message = "We've added a new feature to improve your experience. Would you like to learn more about it?",
                confirmButtonLabel = "Learn More",
                dismissButtonLabel = "Maybe Later",
                icon = Icons.Default.Info,
                onConfirmButtonClicked = { showIconDialog = false },
                onDismiss = { showIconDialog = false }
            )
        }

        // Warning dialog
        if (showWarningDialog) {
            AlertDialog(
                title = "Delete Item",
                message = "This will permanently delete the selected item. This action cannot be reversed.",
                confirmButtonLabel = "Delete",
                dismissButtonLabel = "Cancel",
                icon = Icons.Default.Warning,
                onConfirmButtonClicked = { showWarningDialog = false },
                onDismiss = { showWarningDialog = false }
            )
        }
    }
}

@Preview
@Composable
private fun DialogDemoPreview() {
    CzanThemePreview {
        DialogDemo()
    }
}