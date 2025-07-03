package demo.checkbox

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.checkbox.Checkbox
import com.tweener.czan.designsystem.atom.checkbox.CheckboxDefaults
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import demo._internal.SectionFlowContent
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 30/06/2025
 */

@Composable
fun CheckboxDemo() {
    CzanThemePreview {
        PreviewBox {
            Section(title = "Basic Checkbox") {
                SectionFlowContent {
                    Checkbox(checked = true)
                    Checkbox(checked = false)
                }
            }

            Section(title = "Checkbox with Text") {
                Checkbox(
                    text = "This checkbox is checked",
                    checked = true,
                )

                Checkbox(
                    text = "This checkbox is not checked",
                    checked = false,
                )
            }

            Section(title = "Checkbox with custom properties") {
                Checkbox(
                    checked = true,
                    text = "This is a checked checkbox with text",
                    textStyle = MaterialTheme.typography.titleLarge,
                    colors = CheckboxDefaults.colors(
                        contentColor = MaterialTheme.colorScheme.primary,
                        checkedColor = Color.LightGray,
                        checkmarkColor = Color.Red,
                    ),
                    contentPadding = 8.dp,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ButtonDemoPreview() {
    CzanThemePreview {
        CheckboxDemo()
    }
}
