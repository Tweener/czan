package com.tweener.czan.designsystem.atom.icon

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource
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
    resource: DrawableResource,
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
    modifier: Modifier = Modifier,
    painter: Painter,
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
