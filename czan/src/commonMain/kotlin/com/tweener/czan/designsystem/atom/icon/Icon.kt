package com.tweener.czan.designsystem.atom.icon

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * @author Vivien Mahe
 * @since 13/12/2023
 */

@Composable
fun Icon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
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
    resource: DrawableResource,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(resource = resource),
        tint = tint,
        contentDescription = contentDescription,
    )
}

@Composable
fun Icon(
    painter: Painter,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    Icon(
        modifier = modifier,
        painter = painter,
        tint = tint,
        contentDescription = contentDescription,
    )
}
