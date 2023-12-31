package com.tweener.czan.designsystem.atom.icon

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * @author Vivien Mahe
 * @since 13/12/2023
 */

@Composable
fun Icon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    Icon(
        modifier = modifier,
        imageVector = imageVector,
        tint = tint,
        contentDescription = contentDescription,
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Icon(
    modifier: Modifier = Modifier,
    resourceName: String,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(res = resourceName),
        tint = tint,
        contentDescription = contentDescription,
    )
}
