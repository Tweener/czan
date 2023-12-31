package com.tweener.czan.android.designsystem.atom.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.imageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.placeholder.PlaceholderPlugin
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin
import com.tweener.czan.android.theme.CzanUiDefaults

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
    @DrawableRes resourceId: Int,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
    contentDescription: String? = null,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = resourceId),
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
    @DrawableRes placeholder: Int = 0,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
    imageSize: ImageSize? = null,
    circleCrop: Boolean = false,
) {
    GlideImage(
        modifier = modifier,
        imageModel = { imageUrl },
        imageOptions = ImageOptions(contentScale = contentScale, alignment = alignment),
        requestOptions = {
            var requestOptions = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)

            if (imageSize != null) {
                requestOptions = requestOptions.override(imageSize.width, imageSize.height)
            }

            if (circleCrop) {
                requestOptions = requestOptions.circleCrop()
            }

            requestOptions
        },
        previewPlaceholder = placeholder,
        component = imageComponent {
            +ShimmerPlugin(
                baseColor = colors.shimmerBaseColor(),
                highlightColor = colors.shimmerHighlightColor()
            )

            if (placeholder != 0) {
                +PlaceholderPlugin.Failure(painterResource(id = placeholder))
            }
        }
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
