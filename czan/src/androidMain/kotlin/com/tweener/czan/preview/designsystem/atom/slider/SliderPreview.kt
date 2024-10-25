package com.tweener.czan.preview.designsystem.atom.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tweener.czan.designsystem.atom.slider.Slider
import com.tweener.czan.designsystem.atom.slider.SliderStyle
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 25/10/2024
 */

// region Preview Primary

@UiModePreviews
@Composable
private fun SliderPrimaryCheckedPreview() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    CzanThemePreview {
        Column {
            Slider(
                value = 0f,
                valueRange = 0f..10f,
                onValueChange = { sliderPosition = it }
            )

            Text(text = "Slider value: $sliderPosition")
        }
    }
}

// endregion Preview Primary

// region Preview Secondary

@UiModePreviews
@Composable
private fun SliderSecondaryCheckedPreview() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    CzanThemePreview {
        Column {
            Slider(
                style = SliderStyle.SECONDARY,
                value = 4f,
                valueRange = 0f..10f,
                onValueChange = { sliderPosition = it }
            )

            Text(text = "Slider value: $sliderPosition")
        }
    }
}

// endregion Preview Secondary

// region Preview Tertiary

@UiModePreviews
@Composable
private fun SliderTertiaryCheckedPreview() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    CzanThemePreview {
        Column {
            Slider(
                style = SliderStyle.TERTIARY,
                value = 10f,
                valueRange = 0f..10f,
                onValueChange = { sliderPosition = it }
            )

            Text(text = "Slider value: $sliderPosition")
        }
    }
}

// endregion Preview Tertiary
