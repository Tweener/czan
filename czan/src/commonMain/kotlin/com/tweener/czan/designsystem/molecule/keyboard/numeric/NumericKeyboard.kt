package com.tweener.czan.designsystem.molecule.keyboard.numeric

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan._internal.kotlinextensions.clickableRipple
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 04/04/2024
 */

@Composable
fun NumericKeyboard(
    onNumberUpdated: (String) -> Unit,
    modifier: Modifier = Modifier,
    value: String = "",
    maxDecimals: Int = Int.MAX_VALUE,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    colors: NumericKeyboardColors = NumericKeyboardDefaults.colors(),
    sizes: NumericKeyboardSizes = NumericKeyboardDefaults.sizes(),
    allowDecimals: Boolean = true,
    decimalsSeparator: String = ".",
) {
    val keys = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    val key0 = "0"
    var number by remember { mutableStateOf(value) }

    LaunchedEffect(number) {
        try {
            // Make sure there is always a dot as a decimals separator so converting this string to a Double is possible
            var correctAmount = number.replace(decimalsSeparator, ".")

            // Make sure the requirement for the maximum number of digits is met
            if (correctAmount.contains(decimalsSeparator)) {
                val digits = correctAmount.substring(correctAmount.indexOf(decimalsSeparator))
                if (digits.length > maxDecimals + 1) correctAmount = correctAmount.dropLast(1)
            }

            number = correctAmount

            onNumberUpdated(correctAmount)
        } catch (throwable: Throwable) {
            // newValue is empty, so we don't do anything
        }
    }

    val onAddCharacter: (String) -> Unit = { character ->
        // Allow only one decimals separator
        if (character != decimalsSeparator || number.contains(decimalsSeparator).not()) {
            number += character
        }
    }
    val onRemoveCharacter: () -> Unit = {
        number = number.dropLast(1) // Remove last character
        if (number.lastOrNull()?.toString() == decimalsSeparator) number = number.dropLast(1) // Remove decimals separator if it's the last character
    }

    LazyVerticalGrid(
        modifier = modifier.background(colors.containerColor()),
        columns = GridCells.Fixed(count = 3),
        verticalArrangement = Arrangement.spacedBy(sizes.keysPadding()),
        horizontalArrangement = Arrangement.spacedBy(sizes.keysPadding()),
    ) {
        items(keys) { key -> TextKey(text = key, textStyle = textStyle, colors = colors, sizes = sizes) { onAddCharacter(key) } }

        item {
            when (allowDecimals) {
                true -> TextKey(text = decimalsSeparator, textStyle = textStyle, colors = colors, sizes = sizes) { onAddCharacter(decimalsSeparator) }
                false -> Spacer(modifier = Modifier.fillMaxWidth())
            }
        }
        item { TextKey(text = key0, textStyle = textStyle, colors = colors, sizes = sizes) { onAddCharacter(key0) } }

        item { IconKey(icon = Icons.AutoMirrored.Filled.ArrowBack, colors = colors, sizes = sizes) { onRemoveCharacter() } }
    }
}

@Composable
private fun TextKey(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    colors: NumericKeyboardColors = NumericKeyboardDefaults.colors(),
    sizes: NumericKeyboardSizes = NumericKeyboardDefaults.sizes(),
    onClick: () -> Unit,
) {
    Key(
        modifier = modifier,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
    ) {
        Text(
            modifier = modifier,
            text = text,
            color = colors.contentColor(),
            style = textStyle,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
private fun IconKey(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    colors: NumericKeyboardColors = NumericKeyboardDefaults.colors(),
    sizes: NumericKeyboardSizes = NumericKeyboardDefaults.sizes(),
    onClick: () -> Unit,
) {
    Key(
        modifier = modifier,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = icon,
            tint = colors.contentColor(),
        )
    }
}


@Composable
private fun Key(
    modifier: Modifier = Modifier,
    colors: NumericKeyboardColors = NumericKeyboardDefaults.colors(),
    sizes: NumericKeyboardSizes = NumericKeyboardDefaults.sizes(),
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .height(sizes.keyHeight())
            .clip(shape = MaterialTheme.shapes.extraSmall)
            .background(colors.keyColor())
            .clickableRipple(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

object NumericKeyboardDefaults {

    val KeysPadding: Dp = Size.Padding.ExtraSmall
    val KeyHeight: Dp = 54.dp

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        contentColor: Color = MaterialTheme.colorScheme.onSurface,
        keyColor: Color = Color.Unspecified,
    ): NumericKeyboardColors = NumericKeyboardColors(
        containerColor = containerColor,
        contentColor = contentColor,
        keyColor = keyColor,
    )

    @Composable
    fun sizes(
        keysPadding: Dp = KeysPadding,
        keyHeight: Dp = KeyHeight,
    ): NumericKeyboardSizes = NumericKeyboardSizes(
        keysPadding = keysPadding,
        keyHeight = keyHeight,
    )
}

@Immutable
class NumericKeyboardColors internal constructor(
    private val contentColor: Color,
    private val containerColor: Color,
    private val keyColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun contentColor(): Color = contentColor

    @Composable
    internal fun keyColor(): Color = keyColor
}

@Immutable
class NumericKeyboardSizes internal constructor(
    private val keysPadding: Dp,
    private val keyHeight: Dp,
) {
    @Composable
    internal fun keysPadding(): Dp = keysPadding

    @Composable
    internal fun keyHeight(): Dp = keyHeight
}
