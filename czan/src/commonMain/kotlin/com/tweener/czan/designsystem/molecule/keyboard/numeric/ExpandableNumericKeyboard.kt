package com.tweener.czan.designsystem.molecule.keyboard.numeric

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.tweener.czan._internal.kotlinextensions.clickableRipple
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 23/04/2024
 */

@Composable
fun ExpandableNumericKeyboard(
    onNumberUpdated: (String) -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    expandedButtonText: String = "Hide",
    collapsedButtonText: String = "Show",
    value: String = "",
    maxDecimals: Int = Int.MAX_VALUE,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    colors: NumericKeyboardColors = NumericKeyboardDefaults.colors(),
    sizes: NumericKeyboardSizes = NumericKeyboardDefaults.sizes(),
    allowDecimals: Boolean = true,
    decimalsSeparator: String = ".",
    onKeyboardVisibilityChanged: ((Boolean) -> Unit)? = null,
) {
    var showContent by remember { mutableStateOf(expanded) }
    val buttonText = if (showContent) expandedButtonText else collapsedButtonText
    val iconRotation by animateFloatAsState(targetValue = if (showContent) 180f else 0f)

    LaunchedEffect(expanded) {
        showContent = expanded
    }

    LaunchedEffect(showContent) {
        onKeyboardVisibilityChanged?.invoke(showContent)
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickableRipple { showContent = !showContent }
                .padding(horizontal = Size.Padding.Default, vertical = Size.Padding.Tiny),
            contentAlignment = Alignment.CenterEnd,
        ) {
            Row(
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.medium)
                    .background(colors.buttonColor())
                    .padding(start = 12.dp, end = 4.dp, top = 6.dp, bottom = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = buttonText,
                    style = MaterialTheme.typography.bodySmall,
                    color = colors.buttonContentColor(),
                )

                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .rotate(iconRotation),
                    imageVector = Icons.Default.ExpandLess,
                    tint = colors.buttonContentColor(),
                )
            }
        }

        AnimatedVisibility(visible = showContent) {
            NumericKeyboard(
                modifier = Modifier.fillMaxWidth(),
                onNumberUpdated = onNumberUpdated,
                value = value,
                maxDecimals = maxDecimals,
                textStyle = textStyle,
                colors = colors,
                sizes = sizes,
                allowDecimals = allowDecimals,
                decimalsSeparator = decimalsSeparator,
            )
        }
    }
}
