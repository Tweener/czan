package com.tweener.czan.designsystem.atom.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import com.tweener.czan._internal.kotlinextensions.conditional
import com.tweener.czan.theme.CzanUiDefaults
import com.valentinilk.shimmer.shimmer
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * @author Vivien Mahe
 * @since 24/05/2023
 */

@Composable
fun Image(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
    contentDescription: String? = null,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    Image(
        modifier = modifier,
        imageVector = imageVector,
        contentScale = contentScale,
        alignment = alignment,
        contentDescription = contentDescription,
        alpha = alpha,
        colorFilter = colorFilter,
    )
}

@Composable
fun Image(
    modifier: Modifier = Modifier,
    resource: DrawableResource,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
    contentDescription: String? = null,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    Image(
        modifier = modifier,
        painter = painterResource(resource = resource),
        contentScale = contentScale,
        alignment = alignment,
        contentDescription = contentDescription,
        alpha = alpha,
        colorFilter = colorFilter,
    )
}

@Composable
fun Image(
    modifier: Modifier = Modifier,
    bitmap: ImageBitmap,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
    contentDescription: String? = null,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    Image(
        modifier = modifier,
        bitmap = bitmap,
        contentScale = contentScale,
        alignment = alignment,
        contentDescription = contentDescription,
        alpha = alpha,
        colorFilter = colorFilter,
    )
}

@Composable
fun Image(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    colors: ImageColors = ImageDefaults.imageColors(),
    placeholderRes: DrawableResource? = null,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
    imageSize: ImageSize? = null,
    circleCrop: Boolean = false,
) {
    var isLoading by remember { mutableStateOf(false) }

    val model = ImageRequest.Builder(LocalPlatformContext.current)
        .data(imageUrl)
        .memoryCachePolicy(policy = CachePolicy.ENABLED)
        .diskCachePolicy(policy = CachePolicy.ENABLED)
        .networkCachePolicy(policy = CachePolicy.ENABLED)
        .apply {
            if (imageSize != null) {
                size(imageSize.width, imageSize.height) // Set the target size to load the image at.
            }
        }
        .build()

    AsyncImage(
        modifier = modifier
            .apply { if (circleCrop) clip(CircleShape) }
            .conditional(isLoading, { shimmer() }),
        model = model,
        placeholder = placeholderRes?.let { painterResource(resource = it) },
        contentScale = contentScale,
        alignment = alignment,
        contentDescription = null,
        onLoading = { isLoading = true },
        onSuccess = { isLoading = false },
        onError = { isLoading = false },
//        component = imageComponent {
//            +ShimmerPlugin(
//                baseColor = colors.shimmerBaseColor(),
//                highlightColor = colors.shimmerHighlightColor()
//            )
//        }
    )
}

object ImageDefaults {

    @Composable
    fun imageColors(
        shimmerBaseColor: Color = CzanUiDefaults.Shimmer.baseColor,
        shimmerHighlightColor: Color = CzanUiDefaults.Shimmer.highlightColor,
    ): ImageColors = ImageColors(
        shimmerBaseColor = shimmerBaseColor,
        shimmerHighlightColor = shimmerHighlightColor,
    )
}

@Immutable
class ImageColors internal constructor(
    private val shimmerBaseColor: Color,
    private val shimmerHighlightColor: Color,
) {

    @Composable
    internal fun shimmerBaseColor(): Color = shimmerBaseColor

    @Composable
    internal fun shimmerHighlightColor(): Color = shimmerHighlightColor
}
