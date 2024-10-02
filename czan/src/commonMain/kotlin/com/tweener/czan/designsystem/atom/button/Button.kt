package com.tweener.czan.designsystem.atom.button

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

/**
 * @author Vivien Mahe
 * @since 24/08/2023
 */

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: StringResource? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    loading: Boolean = false,
    loadingStyle: ButtonLoadingStyle = ButtonLoadingStyle.FADE,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text?.let { stringResource(resource = it) },
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        loading = loading,
        loadingStyle = loadingStyle,
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    loading: Boolean = false,
    loadingStyle: ButtonLoadingStyle = ButtonLoadingStyle.FADE,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text,
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        loading = loading,
        loadingStyle = loadingStyle,
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: StringResource? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    loading: Boolean = false,
    loadingStyle: ButtonLoadingStyle = ButtonLoadingStyle.FADE,
    leadingIcon: DrawableResource? = null,
    trailingIcon: DrawableResource? = null,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text?.let { stringResource(resource = it) },
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        loading = loading,
        loadingStyle = loadingStyle,
        leadingIcon = leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), resource = it, contentDescription = null) } },
        trailingIcon = trailingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), resource = it, contentDescription = null) } },
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    loading: Boolean = false,
    loadingStyle: ButtonLoadingStyle = ButtonLoadingStyle.FADE,
    leadingIcon: DrawableResource? = null,
    trailingIcon: DrawableResource? = null,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text,
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        loading = loading,
        loadingStyle = loadingStyle,
        leadingIcon = leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), resource = it, contentDescription = null) } },
        trailingIcon = trailingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), resource = it, contentDescription = null) } },
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: StringResource? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    loading: Boolean = false,
    loadingStyle: ButtonLoadingStyle = ButtonLoadingStyle.FADE,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text?.let { stringResource(resource = it) },
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        loading = loading,
        loadingStyle = loadingStyle,
        leadingIcon = leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
        trailingIcon = trailingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    loading: Boolean = false,
    loadingStyle: ButtonLoadingStyle = ButtonLoadingStyle.FADE,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text,
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        loading = loading,
        loadingStyle = loadingStyle,
        leadingIcon = leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
        trailingIcon = trailingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
        onClick = onClick,
    )
}

@Composable
private fun CzanButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    loading: Boolean = false,
    loadingStyle: ButtonLoadingStyle = ButtonLoadingStyle.FADE,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    val contentPadding = when {
        text != null -> {
            when {
                leadingIcon != null -> size.contentWithLeadingIconPadding
                trailingIcon != null -> size.contentWithTrailingIconPadding
                else -> size.contentPadding
            }
        }

        else -> size.contentPadding
    }

    Button(
        modifier = modifier.height(size.height),
        enabled = enabled,
        onClick = { if (loading.not()) onClick?.invoke() },
        contentPadding = contentPadding,
        shape = size.shape,
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = if (outlined) Color.Transparent else style.containerColor,
            contentColor = if (outlined) style.containerColor else style.contentColor,
            disabledContainerColor = style.disabledContainerColor,
            disabledContentColor = style.disabledContentColor
        ),
        border = if (outlined) BorderStroke(1.dp, style.containerColor) else null
    ) {
        val loadingAlpha by animateFloatAsState(targetValue = if (loading) 1f else 0f)

        Box(contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier.graphicsLayer { alpha = 1 - loadingAlpha },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (leadingIcon != null) {
                    leadingIcon()

                    if (text != null) {
                        Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
                    }
                }

                if (text != null) {
                    Text(
                        text = text,
                        style = size.textStyle,
                        fontWeight = fontWeight,
                    )
                }

                if (trailingIcon != null) {
                    if (text != null) {
                        Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
                    }

                    trailingIcon()
                }
            }

            ButtonLoadingContent(
                modifier = Modifier.fillMaxHeight().graphicsLayer { alpha = loadingAlpha },
                contentColor = if (outlined) style.containerColor else style.contentColor,
                size = size,
                loadingStyle = loadingStyle,
            )
        }
    }
}

@Composable
private fun ButtonLoadingContent(
    contentColor: Color,
    size: ButtonSize,
    loadingStyle: ButtonLoadingStyle,
    modifier: Modifier = Modifier,
) {
    val translationYDelta = with(LocalDensity.current) { size.loadingDotYTranslation.toPx() }
    val animatableDots = List(ButtonDefaults.NumberOfDots) { remember { Animatable(0f) } }

    // Create animation for each dot
    animatableDots.forEachIndexed { index, animatable ->
        LaunchedEffect(animatable) {
            delay(index * 100L) // Add delay between each animation

            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = when (loadingStyle) {
                            ButtonLoadingStyle.BOUNCE -> ButtonDefaults.BounceAnimationDurationMills
                            ButtonLoadingStyle.FADE -> ButtonDefaults.FadeAnimationDurationMills
                        }
                    ),
                    repeatMode = RepeatMode.Reverse,
                ),
            )
        }
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(size.loadingDotGap),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        animatableDots.map { it.value }.forEach { animationValue ->
            Box(
                Modifier
                    .size(size.loadingDotSize)
                    .graphicsLayer {
                        when (loadingStyle) {
                            ButtonLoadingStyle.BOUNCE -> translationY = -animationValue * translationYDelta
                            ButtonLoadingStyle.FADE -> alpha = animationValue
                        }
                    }
                    .clip(shape = CircleShape)
                    .background(color = contentColor),
            )
        }
    }
}


object ButtonDefaults {

    const val NumberOfDots = 3
    const val FadeAnimationDurationMills = 600
    const val BounceAnimationDurationMills = DefaultDurationMillis

}
