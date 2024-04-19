package com.tweener.czan.designsystem.atom.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.text.Text

/**
 * @author Vivien Mahe
 * @since 19/04/2024
 */

@Composable
fun Checkbox(
    checked: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String? = null,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    colors: CheckboxColors = CheckboxDefaults.colors(),
    contentPadding: Dp = 0.dp,
    onCheckedChange: ((Boolean) -> Unit)? = null,
) {
    var isChecked by remember { mutableStateOf(checked) }
    val onCheckedChanged: ((Boolean) -> Unit) = {
        isChecked = it
        onCheckedChange?.invoke(it)
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(contentPadding),
    ) {
        Checkbox(
            checked = isChecked,
            enabled = enabled,
            colors = androidx.compose.material3.CheckboxDefaults.colors(
                checkedColor = colors.checkedColor(),
                uncheckedColor = colors.uncheckedColor(),
                checkmarkColor = colors.checkmarkColor(),
                disabledCheckedColor = colors.disabledCheckedColor(),
                disabledUncheckedColor = colors.disabledUncheckedColor(),
                disabledIndeterminateColor = colors.disabledIndeterminateColor(),
            ),
            onCheckedChange = { onCheckedChanged(it) },
        )

        text?.let {
            Text(
                modifier = Modifier.clickable { onCheckedChanged(isChecked.not()) },
                text = it,
                style = textStyle,
                color = colors.contentColor(),
            )
        }
    }
}

object CheckboxDefaults {

    @Composable
    fun colors(
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        checkedColor: Color = Color.Unspecified,
        uncheckedColor: Color = Color.Unspecified,
        checkmarkColor: Color = Color.Unspecified,
        disabledCheckedColor: Color = Color.Unspecified,
        disabledUncheckedColor: Color = Color.Unspecified,
        disabledIndeterminateColor: Color = Color.Unspecified,
    ): CheckboxColors = CheckboxColors(
        contentColor = contentColor,
        checkedColor = checkedColor,
        uncheckedColor = uncheckedColor,
        checkmarkColor = checkmarkColor,
        disabledCheckedColor = disabledCheckedColor,
        disabledUncheckedColor = disabledUncheckedColor,
        disabledIndeterminateColor = disabledIndeterminateColor,
    )
}

@Immutable
class CheckboxColors internal constructor(
    private val contentColor: Color,
    private val checkedColor: Color,
    private val uncheckedColor: Color,
    private val checkmarkColor: Color,
    private val disabledCheckedColor: Color,
    private val disabledUncheckedColor: Color,
    private val disabledIndeterminateColor: Color,
) {
    @Composable
    internal fun contentColor(): Color = contentColor

    @Composable
    internal fun checkedColor(): Color = checkedColor

    @Composable
    internal fun uncheckedColor(): Color = uncheckedColor

    @Composable
    internal fun checkmarkColor(): Color = checkmarkColor

    @Composable
    internal fun disabledCheckedColor(): Color = disabledCheckedColor

    @Composable
    internal fun disabledUncheckedColor(): Color = disabledUncheckedColor

    @Composable
    internal fun disabledIndeterminateColor(): Color = disabledIndeterminateColor
}
