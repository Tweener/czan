package com.tweener.czan.designsystem.atom.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

/**
 * @author Vivien Mahe
 * @since 26/08/2023
 */
enum class TextFieldType {
    TEXT,
    NUMBER,
    EMAIL,
    PASSWORD_VISIBLE,
    PASSWORD_HIDDEN,
    SEARCH,
    DROPDOWN;

    val leadingIcon: ImageVector?
        get() = when (this) {
            TEXT -> null
            NUMBER -> null
            EMAIL -> null
            PASSWORD_VISIBLE -> null
            PASSWORD_HIDDEN -> null
            SEARCH -> Icons.Default.Search
            DROPDOWN -> null
        }

    val trailingIcon: ImageVector?
        get() = when (this) {
            TEXT -> null
            NUMBER -> null
            EMAIL -> null
            PASSWORD_VISIBLE -> Icons.Outlined.VisibilityOff
            PASSWORD_HIDDEN -> Icons.Outlined.Visibility
            SEARCH -> Icons.Default.Close
            DROPDOWN -> Icons.Default.ArrowDropDown
        }

    val visualTransformation: VisualTransformation
        get() = when (this) {
            TEXT -> VisualTransformation.None
            NUMBER -> VisualTransformation.None
            EMAIL -> VisualTransformation.None
            PASSWORD_VISIBLE -> VisualTransformation.None
            PASSWORD_HIDDEN -> PasswordVisualTransformation()
            SEARCH -> VisualTransformation.None
            DROPDOWN -> VisualTransformation.None
        }

    val keyboardOptions: KeyboardOptions
        get() = when (this) {
            TEXT -> KeyboardOptions.Default
            NUMBER -> KeyboardOptions(keyboardType = KeyboardType.Number)
            EMAIL -> KeyboardOptions(keyboardType = KeyboardType.Email)
            PASSWORD_VISIBLE -> KeyboardOptions.Default
            PASSWORD_HIDDEN -> KeyboardOptions(keyboardType = KeyboardType.Password)
            SEARCH -> KeyboardOptions.Default
            DROPDOWN -> KeyboardOptions.Default
        }
}
