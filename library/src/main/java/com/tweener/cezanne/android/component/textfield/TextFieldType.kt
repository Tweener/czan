package com.tweener.cezanne.android.component.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
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
    SEARCH;

    val leadingIcon: ImageVector?
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            TEXT -> null
            NUMBER -> null
            EMAIL -> null
            PASSWORD_VISIBLE -> null
            PASSWORD_HIDDEN -> null
            SEARCH -> Icons.Default.Search
        }

    val trailingIcon: ImageVector?
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            TEXT -> null
            NUMBER -> null
            EMAIL -> null
            PASSWORD_VISIBLE -> Icons.Outlined.VisibilityOff
            PASSWORD_HIDDEN -> Icons.Outlined.Visibility
            SEARCH -> Icons.Default.Close
        }

    val visualTransformation: VisualTransformation
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            TEXT -> VisualTransformation.None
            NUMBER -> VisualTransformation.None
            EMAIL -> VisualTransformation.None
            PASSWORD_VISIBLE -> VisualTransformation.None
            PASSWORD_HIDDEN -> PasswordVisualTransformation()
            SEARCH -> VisualTransformation.None
        }

    val keyboardOptions: KeyboardOptions
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            TEXT -> KeyboardOptions.Default
            NUMBER -> KeyboardOptions(keyboardType = KeyboardType.Number)
            EMAIL -> KeyboardOptions(keyboardType = KeyboardType.Email)
            PASSWORD_VISIBLE -> KeyboardOptions.Default
            PASSWORD_HIDDEN -> KeyboardOptions(keyboardType = KeyboardType.Password)
            SEARCH -> KeyboardOptions.Default
        }
}
