package demo.slider

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.slider.Slider
import com.tweener.czan.designsystem.atom.slider.SliderDefaults
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.roundToInt

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun SliderDemo() {
    var basicSliderValue by remember { mutableFloatStateOf(0.5f) }
    var rangeSliderValue by remember { mutableFloatStateOf(25f) }
    var stepSliderValue by remember { mutableFloatStateOf(5f) }
    var colorSliderValue by remember { mutableFloatStateOf(0.7f) }

    CzanThemePreview {
        PreviewBox {
            Section(title = "Basic Slider") {
                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = basicSliderValue,
                    onValueChange = { basicSliderValue = it }
                )
                
                Text(
                    text = "Value: ${(basicSliderValue * 100).roundToInt()}%",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Section(title = "Slider with Custom Range") {
                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = rangeSliderValue,
                    onValueChange = { rangeSliderValue = it },
                    valueRange = 0f..100f
                )
                
                Text(
                    text = "Temperature: ${rangeSliderValue.roundToInt()}°C",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Section(title = "Slider with Steps") {
                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = stepSliderValue,
                    onValueChange = { stepSliderValue = it },
                    valueRange = 0f..10f,
                    steps = 9
                )
                
                Text(
                    text = "Rating: ${stepSliderValue.roundToInt()}/10",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Section(title = "Custom Color Slider") {
                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = colorSliderValue,
                    onValueChange = { colorSliderValue = it },
                    colors = SliderDefaults.sliderColors(
                        thumbColor = Color.Red,
                        activeTrackColor = Color.Red,
                        inactiveTrackColor = Color.Red.copy(alpha = 0.3f)
                    )
                )
                
                Text(
                    text = "Volume: ${(colorSliderValue * 100).roundToInt()}%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Red
                )
            }

            Section(title = "Disabled Slider") {
                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = 0.3f,
                    onValueChange = { },
                    enabled = false
                )
                
                Text(
                    text = "Disabled at 30%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }

            Section(title = "Multiple Sliders") {
                var redValue by remember { mutableFloatStateOf(0.8f) }
                var greenValue by remember { mutableFloatStateOf(0.6f) }
                var blueValue by remember { mutableFloatStateOf(0.4f) }
                
                Text(
                    text = "RGB Color Mixer",
                    style = MaterialTheme.typography.titleSmall
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = redValue,
                    onValueChange = { redValue = it },
                    colors = SliderDefaults.sliderColors(
                        thumbColor = Color.Red,
                        activeTrackColor = Color.Red
                    )
                )
                Text(
                    text = "Red: ${(redValue * 255).roundToInt()}",
                    style = MaterialTheme.typography.bodySmall
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = greenValue,
                    onValueChange = { greenValue = it },
                    colors = SliderDefaults.sliderColors(
                        thumbColor = Color.Green,
                        activeTrackColor = Color.Green
                    )
                )
                Text(
                    text = "Green: ${(greenValue * 255).roundToInt()}",
                    style = MaterialTheme.typography.bodySmall
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = blueValue,
                    onValueChange = { blueValue = it },
                    colors = SliderDefaults.sliderColors(
                        thumbColor = Color.Blue,
                        activeTrackColor = Color.Blue
                    )
                )
                Text(
                    text = "Blue: ${(blueValue * 255).roundToInt()}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview
@Composable
private fun SliderDemoPreview() {
    CzanThemePreview {
        SliderDemo()
    }
}