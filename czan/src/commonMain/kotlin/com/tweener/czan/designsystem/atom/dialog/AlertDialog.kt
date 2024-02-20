package com.tweener.czan.designsystem.atom.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.tweener.czan.designsystem.atom.text.Text
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveAlertDialog
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import io.github.alexzhirkevich.cupertino.cancel
import io.github.alexzhirkevich.cupertino.default

/**
 * @author Vivien Mahe
 * @since 01/09/2023
 */

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun AlertDialog(
    title: String,
    confirmButtonLabel: String,
    onConfirmButtonClicked: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    dismissButtonLabel: String? = null,
    icon: ImageVector? = null,
    content: @Composable () -> Unit,
) {
    AdaptiveAlertDialog(
//        icon = { icon?.let { Icon(it, contentDescription = null) } },
        title = { Text(text = title) },
        message = content,
        buttons = {
            default(
                onClick = onConfirmButtonClicked,
                title = { Text(text = confirmButtonLabel) }
            )

            dismissButtonLabel?.let {
                cancel(
                    onClick = onDismiss,
                    title = { Text(text = it) }
                )
            }
        },
        onDismissRequest = onDismiss
    )
}
