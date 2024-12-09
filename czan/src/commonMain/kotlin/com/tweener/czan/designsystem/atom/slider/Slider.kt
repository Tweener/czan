package com.tweener.czan.designsystem.atom.slider

/**
 * @author Vivien Mahe
 * @since 25/10/2024
 */

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Slider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    colors: SliderColors = SliderDefaults.sliderColors(),
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
) {
    androidx.compose.material3.Slider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        colors = androidx.compose.material3.SliderDefaults.colors(
            thumbColor = colors.thumbColor(),
            activeTrackColor = colors.activeTrackColor(),
            inactiveTrackColor = colors.inactiveTrackColor(),
        ),
        interactionSource = remember { MutableInteractionSource() },
    )
}

object SliderDefaults {

    @Composable
    fun sliderColors(
        thumbColor: Color = MaterialTheme.colorScheme.primary,
        activeTrackColor: Color = MaterialTheme.colorScheme.primary,
        inactiveTrackColor: Color = MaterialTheme.colorScheme.outline,
    ): SliderColors = SliderColors(
        thumbColor = thumbColor,
        activeTrackColor = activeTrackColor,
        inactiveTrackColor = inactiveTrackColor,
    )
}

@Immutable
class SliderColors internal constructor(
    private val thumbColor: Color,
    private val activeTrackColor: Color,
    private val inactiveTrackColor: Color,
) {
    @Composable
    internal fun thumbColor(): Color = thumbColor

    @Composable
    internal fun activeTrackColor(): Color = activeTrackColor

    @Composable
    internal fun inactiveTrackColor(): Color = inactiveTrackColor
}
