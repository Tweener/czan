package com.tweener.czan.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * @author Vivien Mahe
 * @since 26/09/2023
 */

@Composable
fun colorResource(colorLight: Color, colorDark: Color = Color.Unspecified) =
    if (isSystemInDarkTheme()) colorDark else colorLight

@Composable
fun CzanTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    lightColorScheme: ColorScheme = MaterialTheme.colorScheme,
    darkColorScheme: ColorScheme? = null,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme && darkColorScheme != null) darkColorScheme else lightColorScheme,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
