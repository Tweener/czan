package com.tweener.czan.android.designsystem.atom.icon

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

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

@Composable
fun Icon(
    modifier: Modifier = Modifier,
    @DrawableRes resourceId: Int,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = resourceId),
        tint = tint,
        contentDescription = contentDescription,
    )
}
