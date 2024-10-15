package com.tweener.czan.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveTheme
import io.github.alexzhirkevich.cupertino.adaptive.CupertinoThemeSpec
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import io.github.alexzhirkevich.cupertino.adaptive.MaterialThemeSpec

/**
 * @author Vivien Mahe
 * @since 26/09/2023
 */

@Composable
fun colorResource(colorLight: Color, colorDark: Color = Color.Unspecified) =
    if (isSystemInDarkTheme()) colorDark else colorLight

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun CzanTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    lightColorScheme: ColorScheme = MaterialTheme.colorScheme,
    darkColorScheme: ColorScheme? = null,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) {
    AdaptiveTheme(
        material = MaterialThemeSpec(
            colorScheme = if (darkTheme && darkColorScheme != null) darkColorScheme else lightColorScheme,
            typography = typography,
            shapes = shapes,
        ),
        cupertino = CupertinoThemeSpec(
            colorScheme = if (darkTheme && darkColorScheme != null) mapDarkColorSchemeToCupertino(darkColorScheme) else mapLightColorSchemeToCupertino(lightColorScheme),
            shapes = mapShapesToCupertino(materialShapes = shapes),
        ),
        content = content,
    )
}

@Composable
private fun mapLightColorSchemeToCupertino(materialColorScheme: ColorScheme) = io.github.alexzhirkevich.cupertino.theme.lightColorScheme(
    accent = materialColorScheme.primary,
//    label = materialColorScheme.onPrimary,
//    secondaryLabel = materialColorScheme.onSecondary,
//    tertiaryLabel = materialColorScheme.onTertiary,
    // Define the color mapping between Material and Cupertino for light colors
)

@Composable
private fun mapDarkColorSchemeToCupertino(materialColorScheme: ColorScheme) = io.github.alexzhirkevich.cupertino.theme.darkColorScheme(
    accent = materialColorScheme.primary,
//    label = materialColorScheme.onPrimary,
//    secondaryLabel = materialColorScheme.onSecondary,
//    tertiaryLabel = materialColorScheme.onTertiary,
    // Define the color mapping between Material and Cupertino for light colors
)

@Composable
private fun mapShapesToCupertino(materialShapes: Shapes) = io.github.alexzhirkevich.cupertino.theme.Shapes(
    extraSmall = materialShapes.extraSmall,
    small = materialShapes.small,
    medium = materialShapes.medium,
    large = materialShapes.large,
    extraLarge = materialShapes.extraLarge,
)
