package demo

import ButtonDemo
import androidx.compose.runtime.Composable
import demo.bars.BarsDemo
import demo.box.BoxWithAnimatedBorderDemo
import demo.checkbox.CheckboxDemo
import demo.chip.ChipDemo
import demo.dialog.DialogDemo
import demo.icon.IconDemo
import demo.image.ImageDemo
import demo.line.LineDemo
import demo.radiobutton.RadioButtonDemo
import demo.scaffold.ScaffoldDemo
import demo.searchinput.SearchInputDemo
import demo.slider.SliderDemo
import demo.snackbar.SnackbarDemo
import demo.switch.SwitchDemo
import demo.text.TextDemo
import demo.textfield.TextFieldDemo

/**
 * @author Vivien Mahe
 * @since 30/06/2025
 */

@Composable
fun Demo(demoId: String? = null) {
    when (demoId) {
        "bars" -> BarsDemo()
        "box" -> BoxWithAnimatedBorderDemo()
        "button" -> ButtonDemo()
        "checkbox" -> CheckboxDemo()
        "chip" -> ChipDemo()
        "dialog" -> DialogDemo()
        "icon" -> IconDemo()
        "image" -> ImageDemo()
        "line" -> LineDemo()
        "radiobutton" -> RadioButtonDemo()
        "scaffold" -> ScaffoldDemo()
        "searchinput" -> SearchInputDemo()
        "slider" -> SliderDemo()
        "snackbar" -> SnackbarDemo()
        "switch" -> SwitchDemo()
        "text" -> TextDemo()
        "textfield" -> TextFieldDemo()
        else -> Unit // Nothing to display for unknown demoId
    }
}
