package com.tweener.czan.designsystem.atom.radiobutton

/**
 * @author Vivien Mahe
 * @since 16/01/2025
 */

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.theme.CzanUiDefaults

@Composable
fun RadioButton(
    checked: Boolean,
    modifier: Modifier = Modifier,
    colors: RadioButtonColors = RadioButtonDefaults.colors(),
    onCheckedChange: ((Boolean) -> Unit)? = null,
) {
    IconToggleButton(
        modifier = modifier,
        checked = checked,
        onCheckedChange = { onCheckedChange?.invoke(it) },
        colors = IconButtonDefaults.iconToggleButtonColors(
            containerColor = colors.containerColor(),
            contentColor = colors.contentColor(),
            checkedContainerColor = colors.checkedContainerColor(),
            checkedContentColor = colors.checkedContentColor(),
            disabledContainerColor = colors.disabledContainerColor(),
            disabledContentColor = colors.disabledContentColor(),
        ),
    ) {
        Icon(
            imageVector = if (checked) Icons.Default.CheckCircle else Icons.Outlined.Circle,
        )
    }
}

object RadioButtonDefaults {

    @Composable
    fun colors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        checkedContainerColor: Color = Color.Unspecified,
        checkedContentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = contentColor.copy(alpha = CzanUiDefaults.uiDisabledAlpha()),
    ): RadioButtonColors = RadioButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        checkedContainerColor = checkedContainerColor,
        checkedContentColor = checkedContentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
    )
}


@Immutable
class RadioButtonColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
    private val checkedContainerColor: Color,
    private val checkedContentColor: Color,
    private val disabledContainerColor: Color,
    private val disabledContentColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun contentColor(): Color = contentColor

    @Composable
    internal fun checkedContainerColor(): Color = checkedContainerColor

    @Composable
    internal fun checkedContentColor(): Color = checkedContentColor

    @Composable
    internal fun disabledContainerColor(): Color = disabledContainerColor

    @Composable
    internal fun disabledContentColor(): Color = disabledContentColor
}
