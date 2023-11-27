package com.tweener.czan.android.designsystem.atom.bars.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.android.theme.CzanTheme

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@Composable
fun CloseBackIconButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    IconButton(
        modifier = modifier,
        onClick = { onClick?.invoke() }
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Close"
        )
    }
}

@UiModePreviews
@Composable
private fun CloseBackIconButtonPreview() {
    CzanTheme {
        CloseBackIconButton()
    }
}
