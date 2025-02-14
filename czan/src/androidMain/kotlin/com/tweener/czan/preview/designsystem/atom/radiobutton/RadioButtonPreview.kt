package com.tweener.czan.preview.designsystem.atom.radiobutton

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.tweener.czan.designsystem.atom.radiobutton.RadioButton
import com.tweener.czan.designsystem.atom.radiobutton.RadioButtonDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 16/01/2025
 */

@UiModePreviews
@Composable
private fun RadioButtonCheckedPreview() {
    CzanThemePreview {
        RadioButton(
            checked = true,
            colors = RadioButtonDefaults.colors(
                containerColor = Color.Red,
                contentColor = Color.Blue,
                checkedContainerColor = Color.Green,
                checkedContentColor = Color.Yellow,
            ),
        )
    }
}

@UiModePreviews
@Composable
private fun RadioButtonNotCheckedPreview() {
    CzanThemePreview {
        RadioButton(
            checked = false,
            colors = RadioButtonDefaults.colors(
                containerColor = Color.Red,
                contentColor = Color.Blue,
                checkedContainerColor = Color.Green,
                checkedContentColor = Color.Yellow,
            ),
        )
    }
}
