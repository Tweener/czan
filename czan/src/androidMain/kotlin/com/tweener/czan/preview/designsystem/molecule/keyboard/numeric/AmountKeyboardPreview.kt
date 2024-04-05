package com.tweener.czan.preview.designsystem.molecule.keyboard.numeric

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.molecule.keyboard.numeric.NumericKeyboard
import com.tweener.czan.designsystem.molecule.keyboard.numeric.NumericKeyboardDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 04/04/2024
 */

@UiModePreviews
@Composable
private fun NumericKeyboardWithDigitsPreview() {
    CzanThemePreview {
        var number by remember { mutableStateOf("") }

        Column {
            Text(text = "Number: $number")

            NumericKeyboard(
                modifier = Modifier.fillMaxWidth(),
                colors = NumericKeyboardDefaults.colors(keyColor = Color.Gray),
                allowDigits = true,
                onNumberUpdated = { number = it },
            )
        }
    }
}

@UiModePreviews
@Composable
private fun NumericKeyboardWithoutDigitsPreview() {
    CzanThemePreview {
        var number by remember { mutableStateOf("") }

        Column {
            Text(text = "Number: $number")

            NumericKeyboard(
                modifier = Modifier.fillMaxWidth(),
                colors = NumericKeyboardDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    keyColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                ),
                allowDigits = false,
                onNumberUpdated = { number = it },
            )
        }
    }
}
