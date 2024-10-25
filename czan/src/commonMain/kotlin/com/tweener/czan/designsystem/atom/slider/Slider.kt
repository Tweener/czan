package com.tweener.czan.designsystem.atom.slider

/**
 * @author Vivien Mahe
 * @since 25/10/2024
 */

import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveSlider
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun Slider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    style: SliderStyle = SliderStyle.PRIMARY,
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
                colors = SliderDefaults.colors(
                    thumbColor = style.thumbColor,
                    activeTrackColor = style.activeTrackColor,
                    inactiveTrackColor = style.inactiveTrackColor,
                )
            }
        },
    )
}
