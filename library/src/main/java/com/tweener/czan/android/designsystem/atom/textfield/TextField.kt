package com.tweener.czan.android.designsystem.atom.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.tweener.czan.android.designsystem.atom.text.Text
import com.tweener.czan.android.designsystem.atom.textfield.TextFieldDefaults.applyBorder
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.android.theme.CzanTheme
import com.tweener.czan.android.theme.CzanUiDefaults

/**
 * @author Vivien Mahe
 * @since 26/08/2023
 */

@Composable
fun TextField(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge, // Used for both text and placeholder
    label: String? = null,
    placeholderText: String? = null,
    type: TextFieldType = TextFieldType.TEXT,
    enabled: Boolean = true,
    singleLine: Boolean = false,
    imeAction: ImeAction = ImeAction.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChanged: ((String) -> Unit)? = null,
) {
    var inputValue by remember { mutableStateOf(text) }
    var inputType by remember { mutableStateOf(type) }
    var hasFocus by remember { mutableStateOf(false) }
    var visualTransformation by remember { mutableStateOf(VisualTransformation.None) }

    LaunchedEffect(inputType) {
        visualTransformation = inputType.visualTransformation
    }

    val inputValueChanged: (String) -> Unit = {
        inputValue = it
        onValueChanged?.invoke(inputValue)
    }

    TextField(
        modifier = modifier
            .onFocusChanged { focusState -> hasFocus = focusState.isFocused }
            .applyBorder(hasFocus = hasFocus),
        value = inputValue,
        placeholder = placeholderText?.let { { Text(it, style = textStyle) } },
        onValueChange = { inputValueChanged(it) },
        label = label?.let { { Text(it) } },
        enabled = enabled,
        textStyle = textStyle,
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        keyboardOptions = inputType.keyboardOptions.copy(imeAction = imeAction),
        keyboardActions = keyboardActions,
        shape = TextFieldDefaults.shape(),
        leadingIcon = inputType.leadingIcon?.let { { Icon(imageVector = it, contentDescription = null) } },
        trailingIcon = inputType.trailingIcon?.let {
            {
                IconButton(onClick = {
                    when (inputType) {
                        TextFieldType.PASSWORD_VISIBLE -> inputType = TextFieldType.PASSWORD_HIDDEN
                        TextFieldType.PASSWORD_HIDDEN -> inputType = TextFieldType.PASSWORD_VISIBLE
                        TextFieldType.SEARCH -> inputValueChanged("")
                        else -> Unit // Nothing to do for the other types
                    }
                }) {
                    Icon(imageVector = it, contentDescription = null)
                }
            }
        },
        colors = TextFieldDefaults.textFieldColors()
    )
}

@Composable
fun TextField(
    text: TextFieldValue,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge, // Used for both text and placeholder
    label: String? = null,
    placeholderText: String? = null,
    type: TextFieldType = TextFieldType.TEXT,
    enabled: Boolean = true,
    singleLine: Boolean = false,
    imeAction: ImeAction = ImeAction.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChanged: ((TextFieldValue) -> Unit)? = null
) {
    var inputType by remember { mutableStateOf(type) }
    var hasFocus by remember { mutableStateOf(false) }
    var visualTransformation by remember { mutableStateOf(VisualTransformation.None) }

    LaunchedEffect(inputType) {
        visualTransformation = inputType.visualTransformation
    }

    TextField(
        modifier = modifier
            .onFocusChanged { focusState -> hasFocus = focusState.isFocused }
            .applyBorder(hasFocus = hasFocus),
        value = text,
        placeholder = placeholderText?.let { { Text(it, style = textStyle) } },
        onValueChange = { if (text != it) onValueChanged?.invoke(it) },
        label = label?.let { { Text(it) } },
        enabled = enabled,
        textStyle = textStyle,
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        keyboardOptions = inputType.keyboardOptions.copy(imeAction = imeAction),
        keyboardActions = keyboardActions,
        shape = TextFieldDefaults.shape(),
        leadingIcon = inputType.leadingIcon?.let { { Icon(imageVector = it, contentDescription = null) } },
        trailingIcon = inputType.trailingIcon?.let {
            {
                IconButton(onClick = {
                    when (inputType) {
                        TextFieldType.PASSWORD_VISIBLE -> inputType = TextFieldType.PASSWORD_HIDDEN
                        TextFieldType.PASSWORD_HIDDEN -> inputType = TextFieldType.PASSWORD_VISIBLE
                        else -> Unit // Nothing to do for the other types
                    }
                }) {
                    Icon(imageVector = it, contentDescription = null)
                }
            }
        },
        colors = TextFieldDefaults.textFieldColors()
    )
}

private object TextFieldDefaults {

    @Composable
    fun Modifier.applyBorder(hasFocus: Boolean) =
        this.border(
            width = if (hasFocus) 2.dp else 1.dp,
            color = if (hasFocus) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.outlineVariant,
            shape = shape()
        )

    @Composable
    fun shape() = MaterialTheme.shapes.extraLarge

    @Composable
    fun textFieldColors() = androidx.compose.material3.TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.surface,
        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = CzanUiDefaults.uiDisabledAlpha()),
        focusedTextColor = MaterialTheme.colorScheme.onBackground,
        unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
        disabledTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = CzanUiDefaults.uiDisabledAlpha()),
        focusedLabelColor = MaterialTheme.colorScheme.outline,
        unfocusedLabelColor = MaterialTheme.colorScheme.outline,
        disabledLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = CzanUiDefaults.uiDisabledAlpha()),
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = CzanUiDefaults.uiDisabledAlpha()),
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = CzanUiDefaults.uiDisabledAlpha()),
        disabledPlaceholderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = CzanUiDefaults.uiDisabledAlpha()),
    )
}

@UiModePreviews
@Composable
private fun TextFieldTextEnabledPlaceholderPreview() {
    CzanTheme {
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
    CzanTheme {
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
    CzanTheme {
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
    CzanTheme {
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
    CzanTheme {
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
    CzanTheme {
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
    CzanTheme {
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
    CzanTheme {
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
    CzanTheme {
        TextField(
            text = "Text field",
            label = "Label",
            type = TextFieldType.SEARCH,
            enabled = false
        )
    }
}
