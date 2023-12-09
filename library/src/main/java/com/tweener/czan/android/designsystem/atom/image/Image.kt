package com.tweener.czan.android.designsystem.atom.image

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
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
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    color: Color = Color.Transparent,
    highlightColor: Color = Color.Transparent,
    contentScale: ContentScale = ContentScale.Crop,
    @DrawableRes placeholder: Int = 0,
    dimensions: Pair<Int, Int>? = null,
) {
    GlideImage(
        modifier = modifier,
        imageModel = { imageUrl },
        imageOptions = ImageOptions(contentScale = contentScale, alignment = Alignment.Center),
        requestOptions = {
            with(RequestOptions()) {
                dimensions?.let { override(it.first, it.second) }
                diskCacheStrategy(DiskCacheStrategy.ALL)
            }
        },
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
