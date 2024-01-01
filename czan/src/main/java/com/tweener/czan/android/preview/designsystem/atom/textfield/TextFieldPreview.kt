package com.tweener.czan.android.preview.designsystem.atom.textfield

import androidx.compose.runtime.Composable
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.textfield.TextField
import com.tweener.czan.designsystem.atom.textfield.TextFieldType
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun TextFieldTextEnabledPlaceholderPreview() {
    CzanThemePreview {
        TextField(
            text = "",
            label = "Label",
            placeholderText = "Enter something",
            type = TextFieldType.TEXT
        )
    }
}

@UiModePreviews
@Composable
private fun TextFieldTextEnabledPreview() {
    CzanThemePreview {
        TextField(
            text = "Text field",
            label = "Label",
            placeholderText = "Enter something",
            type = TextFieldType.TEXT
        )
    }
}

@UiModePreviews
@Composable
private fun TextFieldTextDisabledPreview() {
    CzanThemePreview {
        TextField(
            text = "Text field",
            label = "Label",
            type = TextFieldType.TEXT,
            enabled = false
        )
    }
}

@UiModePreviews
@Composable
private fun TextFieldPasswordVisibleEnabledPreview() {
    CzanThemePreview {
        TextField(
            text = "Text field",
            label = "Label",
            type = TextFieldType.PASSWORD_VISIBLE
        )
    }
}

@UiModePreviews
@Composable
private fun TextFieldPasswordVisibleDisabledPreview() {
    CzanThemePreview {
        TextField(
            text = "Text field",
            label = "Label",
            type = TextFieldType.PASSWORD_VISIBLE,
            enabled = false
        )
    }
}

@UiModePreviews
@Composable
private fun TextFieldPasswordHiddenEnabledPreview() {
    CzanThemePreview {
        TextField(
            text = "Text field",
            label = "Label",
            type = TextFieldType.PASSWORD_HIDDEN
        )
    }
}

@UiModePreviews
@Composable
private fun TextFieldPasswordHiddenDisabledPreview() {
    CzanThemePreview {
        TextField(
            text = "Text field",
            label = "Label",
            type = TextFieldType.PASSWORD_HIDDEN,
            enabled = false
        )
    }
}

@UiModePreviews
@Composable
private fun TextFieldSearchEnabledPreview() {
    CzanThemePreview {
        TextField(
            text = "Text field",
            label = "Label",
            type = TextFieldType.SEARCH
        )
    }
}

@UiModePreviews
@Composable
private fun TextFieldSearchDisabledPreview() {
    CzanThemePreview {
        TextField(
            text = "Text field",
            label = "Label",
            type = TextFieldType.SEARCH,
            enabled = false
        )
    }
}
