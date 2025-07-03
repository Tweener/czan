package demo

import ButtonDemo
import androidx.compose.runtime.Composable
import demo.box.BoxWithAnimatedBorderDemo
import demo.checkbox.CheckboxDemo
import demo.chip.ChipDemo

/**
 * @author Vivien Mahe
 * @since 30/06/2025
 */

@Composable
fun Demo(demoId: String? = null) {
    when (demoId) {
        "box" -> BoxWithAnimatedBorderDemo()
        "button" -> ButtonDemo()
        "checkbox" -> CheckboxDemo()
        "chip" -> ChipDemo()
        else -> Unit // Nothing to display for unknown demoId
    }
}
