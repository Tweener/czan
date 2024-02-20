package com.tweener.czan.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveTheme
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import io.github.alexzhirkevich.cupertino.adaptive.Theme

/**
 * @author Vivien Mahe
 * @since 26/09/2023
 */

expect fun determineTheme(): Theme

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun CzanTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    theme: Theme = determineTheme(),
    lightColorScheme: ColorScheme = MaterialTheme.colorScheme,
    darkColorScheme: ColorScheme? = null,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) {
    AdaptiveTheme(
        material = {
            MaterialTheme(
                colorScheme = if (darkTheme && darkColorScheme != null) darkColorScheme else lightColorScheme,
                typography = typography,
                shapes = shapes,
                content = content
            )
        },
        target = theme,
        content = content,
    )
}
