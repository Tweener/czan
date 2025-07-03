package demo

import ButtonDemo
import androidx.compose.runtime.Composable
import demo.box.BoxWithAnimatedBorderDemo
import demo.checkbox.CheckboxDemo

/**
 * @author Vivien Mahe
 * @since 30/06/2025
 */

@Composable
fun Demo(demoId: String? = null) {
    when (demoId) {
        "boxwithanimatedborder" -> BoxWithAnimatedBorderDemo()
        "button" -> ButtonDemo()
        "checkbox" -> CheckboxDemo()
        else -> Unit // Nothing to display for unknown demoId
    }
}
