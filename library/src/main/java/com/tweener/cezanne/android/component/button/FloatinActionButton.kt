package com.tweener.cezanne.android.component.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.theme.CezanneTheme

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@Composable
fun FloatingActionButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = { onClick?.invoke() },
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
    }
}

@UiModePreviews
@Composable
private fun FloatingActionButtonPreview() {
    CezanneTheme {
        FloatingActionButton(icon = Icons.Default.Add)
    }
}
