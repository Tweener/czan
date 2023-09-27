package com.tweener.cezanne.android.component.bars.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.theme.CezanneTheme

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@Composable
fun ArrowBackIconButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    IconButton(
        modifier = modifier,
        onClick = { onClick?.invoke() }
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "BackArrow"
        )
    }
}

@UiModePreviews
@Composable
private fun ArrowBackIconButtonPreview() {
    CezanneTheme {
        ArrowBackIconButton()
    }
}
