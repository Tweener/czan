package com.tweener.czan.android.preview

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tweener.czan.android.theme.CzanTheme

/**
 * @author Vivien Mahe
 * @since 18/12/2023
 */

@Composable
fun CzanThemePreview(content: @Composable () -> Unit) {
    CzanTheme(
        lightColorScheme = CzanPreviewLightColorScheme,
        darkColorScheme = CzanPreviewDarkColorScheme,
        typography = CzanPreviewTypography,
        shapes = CzanPreviewConesShapes,
        content = content
    )
}

// region Colors

// Light colors
val md_theme_light_primary = Color(0xFF228737)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFF99F6B4)
val md_theme_light_onPrimaryContainer = Color(0xFF00210E)
val md_theme_light_secondary = Color(0xFF4F6353)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFD2E8D4)
val md_theme_light_onSecondaryContainer = Color(0xFF0D1F13)
val md_theme_light_tertiary = Color(0xFF3A646F)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFBEEAF6)
val md_theme_light_onTertiaryContainer = Color(0xFF001F26)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFBFDF7)
val md_theme_light_onBackground = Color(0xFF191C19)
val md_theme_light_surface = Color(0xFFFBFDF7)
val md_theme_light_onSurface = Color(0xFF191C19)
val md_theme_light_surfaceVariant = Color(0xFFDDE5DB)
val md_theme_light_onSurfaceVariant = Color(0xFF414941)
val md_theme_light_outline = Color(0xFF717971)
val md_theme_light_inverseOnSurface = Color(0xFFF0F1EC)
val md_theme_light_inverseSurface = Color(0xFF2E312E)
val md_theme_light_inversePrimary = Color(0xFF7EDA9A)
val md_theme_light_surfaceTint = Color(0xFF228737)
val md_theme_light_outlineVariant = Color(0xFFC1C9BF)
val md_theme_light_scrim = Color(0xFF000000)

val CzanPreviewLightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,
)

// Dark colors
val md_theme_dark_primary = Color(0xFF7EDA9A)
val md_theme_dark_onPrimary = Color(0xFF00391B)
val md_theme_dark_primaryContainer = Color(0xFF00522A)
val md_theme_dark_onPrimaryContainer = Color(0xFF99F6B4)
val md_theme_dark_secondary = Color(0xFFB6CCB8)
val md_theme_dark_onSecondary = Color(0xFF223527)
val md_theme_dark_secondaryContainer = Color(0xFF384B3C)
val md_theme_dark_onSecondaryContainer = Color(0xFFD2E8D4)
val md_theme_dark_tertiary = Color(0xFFA2CEDA)
val md_theme_dark_onTertiary = Color(0xFF02363F)
val md_theme_dark_tertiaryContainer = Color(0xFF214D57)
val md_theme_dark_onTertiaryContainer = Color(0xFFBEEAF6)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF191C19)
val md_theme_dark_onBackground = Color(0xFFE1E3DE)
val md_theme_dark_surface = Color(0xFF191C19)
val md_theme_dark_onSurface = Color(0xFFE1E3DE)
val md_theme_dark_surfaceVariant = Color(0xFF414941)
val md_theme_dark_onSurfaceVariant = Color(0xFFC1C9BF)
val md_theme_dark_outline = Color(0xFF8B938A)
val md_theme_dark_inverseOnSurface = Color(0xFF191C19)
val md_theme_dark_inverseSurface = Color(0xFFE1E3DE)
val md_theme_dark_inversePrimary = Color(0xFF228737)
val md_theme_dark_surfaceTint = Color(0xFF7EDA9A)
val md_theme_dark_outlineVariant = Color(0xFF414941)
val md_theme_dark_scrim = Color(0xFF000000)

val CzanPreviewDarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)

// endregion Colors

// region Typography

val CzanPreviewTypography = Typography(
    labelLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.sp,
        lineHeight = 20.sp,
        fontSize = 12.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.sp,
        lineHeight = 16.sp,
        fontSize = 10.sp
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.sp,
        lineHeight = 16.sp,
        fontSize = 8.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        lineHeight = 22.sp,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        lineHeight = 20.sp,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        lineHeight = 16.sp,
        fontSize = 12.sp
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        lineHeight = 48.sp,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.sp,
        lineHeight = 36.sp,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.sp,
        lineHeight = 32.sp,
        fontSize = 24.sp
    ),
    displayLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        lineHeight = 64.sp,
        fontSize = 57.sp
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        lineHeight = 52.sp,
        fontSize = 45.sp
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        lineHeight = 44.sp,
        fontSize = 36.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        lineHeight = 28.sp,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.sp,
        lineHeight = 24.sp,
        fontSize = 18.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.sp,
        lineHeight = 20.sp,
        fontSize = 16.sp
    )
)

// endregion Typography

// region Shapes

val CzanPreviewConesShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(12.dp),
    extraLarge = RoundedCornerShape(16.dp)
)

// endregion Shapes
