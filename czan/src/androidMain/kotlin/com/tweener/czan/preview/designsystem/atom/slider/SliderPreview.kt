package com.tweener.czan.preview.designsystem.atom.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.tweener.czan.designsystem.atom.slider.Slider
import com.tweener.czan.designsystem.atom.slider.SliderDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 25/10/2024
 */

@UiModePreviews
@Composable
private fun SliderPrimaryCheckedPreview() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    CzanThemePreview {
        Column {
            Slider(
                value = 4f,
                valueRange = 0f..10f,
                onValueChange = { sliderPosition = it },
                colors = SliderDefaults.sliderColors(
                    thumbColor = Color.Blue,
                    activeTrackColor = Color.Red,
                    inactiveTrackColor = Color.Green,
                ),
            )

            Text(text = "Slider value: $sliderPosition")
        }
    }
}
