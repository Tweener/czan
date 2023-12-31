package com.tweener.czan.designsystem.atom.image

/**
 * @author Vivien Mahe
 * @since 31/12/2023
 */

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
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
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.tweener.czan.theme.CzanUiDefaults
import org.jetbrains.compose.resources.ExperimentalResourceApi
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

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Image(
    modifier: Modifier = Modifier,
    resource: String,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
    contentDescription: String? = null,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    Image(
        modifier = modifier,
        painter = painterResource(res = resource),
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

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Image(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    colors: ImageColors = ImageDefaults.imageColors(),
    placeholderRes: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
    imageSize: ImageSize? = null,
    circleCrop: Boolean = false,
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(imageUrl)
            .apply {
                if (imageSize != null) {
                    size(imageSize.width, imageSize.height) // Set the target size to load the image at.
                }
            }
            .build()
    )

    AsyncImage(
        modifier = modifier.apply { if (circleCrop) clip(CircleShape) },
        model = painter,
        placeholder = placeholderRes?.let { painterResource(res = it) },
        contentScale = contentScale,
        alignment = alignment,
        contentDescription = null,
//        requestOptions = {
//            var requestOptions = RequestOptions()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//        },
//        component = imageComponent {
//            +ShimmerPlugin(
//                baseColor = colors.shimmerBaseColor(),
//                highlightColor = colors.shimmerHighlightColor()
//            )
//
//            if (placeholder != 0) {
//                +PlaceholderPlugin.Failure(painterResource(id = placeholder))
//            }
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
