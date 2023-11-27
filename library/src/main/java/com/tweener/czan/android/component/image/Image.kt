package com.tweener.czan.android.component.image

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.imageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.placeholder.PlaceholderPlugin
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

/**
 * @author Vivien Mahe
 * @since 24/05/2023
 */

@Composable
fun Image(
    color: Color,
    highlightColor: Color,
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    @DrawableRes placeholder: Int = 0,
) {
    GlideImage(
        modifier = modifier,
        imageModel = { imageUrl },
        imageOptions = ImageOptions(contentScale = contentScale, alignment = Alignment.Center),
        previewPlaceholder = placeholder,
        component = imageComponent {
            +ShimmerPlugin(
                baseColor = color,
                highlightColor = highlightColor
            )

            if (placeholder != 0) {
                +PlaceholderPlugin.Failure(painterResource(id = placeholder))
            }
        }
    )
}
