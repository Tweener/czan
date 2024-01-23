package com.tweener.czan.designsystem.atom.box

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 12/01/2024
 */

@Composable
fun BoxWithAnimatedBorder(
    modifier: Modifier = Modifier,
    borderColors: List<Color> = emptyList(),
    borderWidth: Dp = 1.dp,
    roundedCorners: Dp = Size.Padding.Default,
    contentPadding: PaddingValues = PaddingValues(Size.Padding.Default),
    onCardClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Repeat angle"
    )

    val brush =
        if (borderColors.isNotEmpty()) Brush.sweepGradient(borderColors)
        else Brush.sweepGradient(listOf(Color.Gray, Color.White))

    Surface(
        modifier = modifier.clickable { onCardClick?.invoke() },
        shape = RoundedCornerShape(roundedCorners)
    ) {
        Surface(
            modifier = Modifier
                .clipToBounds()
                .fillMaxWidth()
                .padding(borderWidth)
                .drawWithContent {
                    rotate(angle) {
                        drawCircle(
                            brush = brush,
                            radius = size.width,
                            blendMode = BlendMode.SrcIn,
                        )
                    }
                    drawContent()
                },
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(roundedCorners - 1.dp)
        ) {
            Box(modifier = Modifier.padding(contentPadding)) { content() }
        }
    }
}
