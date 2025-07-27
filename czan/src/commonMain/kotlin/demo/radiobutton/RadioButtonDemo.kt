package demo.radiobutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.radiobutton.RadioButton
import com.tweener.czan.designsystem.atom.radiobutton.RadioButtonDefaults
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import demo._internal.SectionFlowContent
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun RadioButtonDemo() {
    var selectedBasicOption by remember { mutableIntStateOf(0) }
    var selectedColorOption by remember { mutableIntStateOf(0) }
    var selectedTextOption by remember { mutableIntStateOf(0) }

    CzanThemePreview {
        PreviewBox {
            Section(title = "Basic Radio Buttons") {
                SectionFlowContent {
                    RadioButton(
                        checked = true,
                        onCheckedChange = null
                    )
                    RadioButton(
                        checked = false,
                        onCheckedChange = null
                    )
                }
            }

            Section(title = "Radio Button Group") {
                Column {
                    val options = listOf("Option 1", "Option 2", "Option 3")
                    
                    options.forEachIndexed { index, option ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                checked = selectedBasicOption == index,
                                onCheckedChange = { selectedBasicOption = index }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = option,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }

            Section(title = "Custom Colors") {
                Column {
                    val colorOptions = listOf("Red", "Blue", "Green")
                    val colors = listOf(Color.Red, Color.Blue, Color.Green)
                    
                    colorOptions.forEachIndexed { index, option ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                checked = selectedColorOption == index,
                                onCheckedChange = { selectedColorOption = index },
                                colors = RadioButtonDefaults.colors(
                                    contentColor = colors[index],
                                    checkedContentColor = colors[index]
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = option,
                                style = MaterialTheme.typography.bodyLarge,
                                color = colors[index]
                            )
                        }
                    }
                }
            }

            Section(title = "Different Text Styles") {
                Column {
                    val textOptions = listOf("Small Text", "Medium Text", "Large Text")
                    val textStyles = listOf(
                        MaterialTheme.typography.bodySmall,
                        MaterialTheme.typography.bodyMedium,
                        MaterialTheme.typography.bodyLarge
                    )
                    
                    textOptions.forEachIndexed { index, option ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                checked = selectedTextOption == index,
                                onCheckedChange = { selectedTextOption = index }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = option,
                                style = textStyles[index]
                            )
                        }
                    }
                }
            }

            Section(title = "Disabled States") {
                SectionFlowContent {
                    RadioButton(
                        checked = true,
                        onCheckedChange = null,
                        colors = RadioButtonDefaults.colors(
                            disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        )
                    )
                    RadioButton(
                        checked = false,
                        onCheckedChange = null,
                        colors = RadioButtonDefaults.colors(
                            disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun RadioButtonDemoPreview() {
    CzanThemePreview {
        RadioButtonDemo()
    }
}