package demo.switch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tweener.czan.designsystem.atom.switch.Switch
import com.tweener.czan.designsystem.atom.switch.SwitchStyle
import com.tweener.czan.designsystem.atom.switch.SwitchWithText
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
fun SwitchDemo() {
    var primarySwitchChecked by remember { mutableStateOf(true) }
    var secondarySwitchChecked by remember { mutableStateOf(false) }
    var tertiarySwitchChecked by remember { mutableStateOf(true) }
    var enabledSwitchChecked by remember { mutableStateOf(true) }
    var textSwitchChecked by remember { mutableStateOf(false) }

    CzanThemePreview {
        PreviewBox {
            Section(title = "Styles") {
                SectionFlowContent {
                    Switch(
                        style = SwitchStyle.PRIMARY,
                        checked = primarySwitchChecked,
                        onCheckedChange = { primarySwitchChecked = it }
                    )

                    Switch(
                        style = SwitchStyle.SECONDARY,
                        checked = secondarySwitchChecked,
                        onCheckedChange = { secondarySwitchChecked = it }
                    )

                    Switch(
                        style = SwitchStyle.TERTIARY,
                        checked = tertiarySwitchChecked,
                        onCheckedChange = { tertiarySwitchChecked = it }
                    )
                }
            }

            Section(title = "States") {
                SectionFlowContent {
                    Switch(
                        checked = enabledSwitchChecked,
                        enabled = true,
                        onCheckedChange = { enabledSwitchChecked = it }
                    )

                    Switch(
                        checked = true,
                        enabled = false,
                        onCheckedChange = null
                    )

                    Switch(
                        checked = false,
                        enabled = false,
                        onCheckedChange = null
                    )
                }
            }

            Section(title = "Switch with Text") {
                SwitchWithText(
                    text = "Enable notifications",
                    checked = textSwitchChecked,
                    onCheckedChange = { textSwitchChecked = it }
                )

                SwitchWithText(
                    text = "Dark mode (disabled)",
                    checked = true,
                    onCheckedChange = null
                )
            }
        }
    }
}

@Preview
@Composable
private fun SwitchDemoPreview() {
    CzanThemePreview {
        SwitchDemo()
    }
}