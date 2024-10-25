package com.tweener.czan.designsystem.atom.slider

/**
 * @author Vivien Mahe
 * @since 25/10/2024
 */

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveSlider
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

@OptIn(ExperimentalAdaptiveApi::class)
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
    AdaptiveSlider(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        adaptation = {
            material {
                this.colors = androidx.compose.material3.SliderDefaults.colors(
                    thumbColor = colors.thumbColor(),
                    activeTrackColor = colors.activeTrackColor(),
                    inactiveTrackColor = colors.inactiveTrackColor(),
                )
            }
        },
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
