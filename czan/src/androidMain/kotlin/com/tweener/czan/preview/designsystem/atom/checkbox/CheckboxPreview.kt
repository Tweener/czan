package com.tweener.czan.preview.designsystem.atom.checkbox

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.checkbox.Checkbox
import com.tweener.czan.designsystem.atom.checkbox.CheckboxDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 19/04/2024
 */

@UiModePreviews
@Composable
private fun CheckboxNotCheckedNoTextPreview() {
    CzanThemePreview {
        Checkbox(
            checked = false,
        )
    }
}

@UiModePreviews
@Composable
private fun CheckboxCheckedNoTextPreview() {
    CzanThemePreview {
        Checkbox(
            checked = true,
        )
    }
}

@UiModePreviews
@Composable
private fun CheckboxNotCheckedWithTextPreview() {
    CzanThemePreview {
        Checkbox(
            checked = false,
            text = "This is a not-checked checkbox with text",
        )
    }
}

@UiModePreviews
@Composable
private fun CheckboxCheckedWithTextPreview() {
    CzanThemePreview {
        Checkbox(
            checked = true,
            text = "This is a checked checkbox with text",
        )
    }
}

@UiModePreviews
@Composable
private fun CheckboxChangePropertiesPreview() {
    CzanThemePreview {
        Checkbox(
            checked = true,
            text = "This is a checked checkbox with text",
            textStyle = MaterialTheme.typography.titleLarge,
            colors = CheckboxDefaults.colors(
                contentColor = MaterialTheme.colorScheme.primary,
                checkedColor = MaterialTheme.colorScheme.tertiary,
                checkmarkColor = Color.Red,
            ),
            contentPadding = 8.dp,
        )
    }
}
