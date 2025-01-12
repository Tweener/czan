package com.tweener.czan.designsystem.atom.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @author Vivien Mahe
 * @since 01/09/2023
 */

@Composable
expect fun AlertDialog(
    title: String,
    message: String,
    confirmButtonLabel: String,
    onConfirmButtonClicked: () -> Unit,
    onDismiss: () -> Unit,
    dismissButtonLabel: String? = null,
    icon: ImageVector? = null,
)
