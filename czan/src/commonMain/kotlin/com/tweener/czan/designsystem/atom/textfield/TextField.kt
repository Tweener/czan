package com.tweener.czan.designsystem.atom.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.atom.textfield.TextFieldDefaults.applyBorder
import com.tweener.czan.theme.CzanUiDefaults

/**
 * @author Vivien Mahe
 * @since 26/08/2023
 */

@Composable
fun TextField(
    text: String,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholderText: String? = null,
    size: TextFieldSize = TextFieldSize.REGULAR,
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
            .height(size.height)
            .onFocusChanged { focusState -> hasFocus = focusState.isFocused }
            .applyBorder(hasFocus = hasFocus, shape = size.shape),
        value = inputValue,
        placeholder = placeholderText?.let { { Text(it, style = size.textStyle) } },
        onValueChange = { inputValueChanged(it) },
        label = label?.let { { Text(it) } },
        enabled = enabled,
        textStyle = size.textStyle,
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        keyboardOptions = inputType.keyboardOptions.copy(imeAction = imeAction),
        keyboardActions = keyboardActions,
        shape = size.shape,
        leadingIcon = inputType.leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
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
                    Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null)
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
    label: String? = null,
    placeholderText: String? = null,
    size: TextFieldSize = TextFieldSize.REGULAR,
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
            .height(size.height)
            .onFocusChanged { focusState -> hasFocus = focusState.isFocused }
            .applyBorder(hasFocus = hasFocus, shape = size.shape),
        value = text,
        placeholder = placeholderText?.let { { Text(it, style = size.textStyle) } },
        onValueChange = { if (text != it) onValueChanged?.invoke(it) },
        label = label?.let { { Text(it) } },
        enabled = enabled,
        textStyle = size.textStyle,
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        keyboardOptions = inputType.keyboardOptions.copy(imeAction = imeAction),
        keyboardActions = keyboardActions,
        shape = size.shape,
        leadingIcon = inputType.leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
        trailingIcon = inputType.trailingIcon?.let {
            {
                IconButton(onClick = {
                    when (inputType) {
                        TextFieldType.PASSWORD_VISIBLE -> inputType = TextFieldType.PASSWORD_HIDDEN
                        TextFieldType.PASSWORD_HIDDEN -> inputType = TextFieldType.PASSWORD_VISIBLE
                        else -> Unit // Nothing to do for the other types
                    }
                }) {
                    Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null)
                }
            }
        },
        colors = TextFieldDefaults.textFieldColors()
    )
}

private object TextFieldDefaults {

    @Composable
    fun Modifier.applyBorder(hasFocus: Boolean, shape: Shape = shape()) =
        this.border(
            width = if (hasFocus) 2.dp else 1.dp,
            color = if (hasFocus) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.outlineVariant,
            shape = shape
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
