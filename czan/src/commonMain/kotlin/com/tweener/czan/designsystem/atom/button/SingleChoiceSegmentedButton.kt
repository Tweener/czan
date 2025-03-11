package com.tweener.czan.designsystem.atom.button

/**
 * @author Vivien Mahe
 * @since 10/03/2025
 */

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.tweener.czan.designsystem.atom.text.Text

@Composable
fun SingleChoiceSegmentedButton(
    options: List<String>,
    modifier: Modifier = Modifier,
    selectedOption: Int = 0,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    colors: SegmentedButtonColors = SegmentedButtonDefaults.colors(),
    onOptionSelected: (Int) -> Unit,
) {
    var selectedIndex by rememberSaveable { mutableIntStateOf(selectedOption.coerceIn(0, options.size - 1)) }

    SingleChoiceSegmentedButtonRow(modifier = modifier) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = androidx.compose.material3.SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                onClick = { selectedIndex = index; onOptionSelected(index) },
                selected = index == selectedIndex,
                icon = {},
                label = { Text(text = label, style = textStyle) },
                colors = androidx.compose.material3.SegmentedButtonDefaults.colors(
                    activeContainerColor = colors.activeContainerColor(),
                    activeContentColor = colors.activeContentColor(),
                    activeBorderColor = colors.activeBorderColor(),
                    inactiveContainerColor = colors.inactiveContainerColor(),
                    inactiveContentColor = colors.inactiveContentColor(),
                    inactiveBorderColor = colors.inactiveBorderColor(),
                ),
            )
        }
    }
}

object SegmentedButtonDefaults {

    @Composable
    fun colors(
        activeContainerColor: Color = MaterialTheme.colorScheme.primaryContainer,
        activeContentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        activeBorderColor: Color = MaterialTheme.colorScheme.outline,
        inactiveContainerColor: Color = MaterialTheme.colorScheme.background,
        inactiveContentColor: Color = MaterialTheme.colorScheme.onBackground,
        inactiveBorderColor: Color = MaterialTheme.colorScheme.outline,
    ): SegmentedButtonColors = SegmentedButtonColors(
        activeContainerColor = activeContainerColor,
        activeContentColor = activeContentColor,
        activeBorderColor = activeBorderColor,
        inactiveContainerColor = inactiveContainerColor,
        inactiveContentColor = inactiveContentColor,
        inactiveBorderColor = inactiveBorderColor,
    )
}

@Immutable
class SegmentedButtonColors internal constructor(
    private val activeContainerColor: Color,
    private val activeContentColor: Color,
    private val activeBorderColor: Color,
    private val inactiveContainerColor: Color,
    private val inactiveContentColor: Color,
    private val inactiveBorderColor: Color,
) {
    @Composable
    internal fun activeContainerColor(): Color = activeContainerColor

    @Composable
    internal fun activeContentColor(): Color = activeContentColor

    @Composable
    internal fun activeBorderColor(): Color = activeBorderColor

    @Composable
    internal fun inactiveContainerColor(): Color = inactiveContainerColor

    @Composable
    internal fun inactiveContentColor(): Color = inactiveContentColor

    @Composable
    internal fun inactiveBorderColor(): Color = inactiveBorderColor
}
