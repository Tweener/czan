package com.tweener.czan.designsystem.atom.bars.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "BackArrow"
        )
    }
}
