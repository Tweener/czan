package com.tweener.czan.preview.designsystem.molecule.keyboard.numeric

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.molecule.keyboard.numeric.ExpandableNumericKeyboard
import com.tweener.czan.designsystem.molecule.keyboard.numeric.NumericKeyboardDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 23/04/2024
 */

@UiModePreviews
@Composable
private fun ExpandableNumericKeyboardPreview() {
    CzanThemePreview {
        var number by remember { mutableStateOf("") }

        Column {
            Text(text = "Number: $number")

            ExpandableNumericKeyboard(
                modifier = Modifier.fillMaxWidth(),
                colors = NumericKeyboardDefaults.colors(keyColor = Color.Gray),
                maxDecimals = 2,
                allowDecimals = true,
                onNumberUpdated = { number = it },
            )
        }
    }
}
