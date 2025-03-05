package com.tweener.czan._internal.kotlinextensions

import androidx.annotation.FloatRange
import androidx.compose.ui.graphics.Color

/**
 * @author Vivien Mahe
 * @since 17/09/2024
 */

/**
 * Parses a hexadecimal color string and returns a [Color] object.
 *
 * The input color string can optionally start with a '#' character. It must contain either 6 (RGB) or 8 (ARGB) hexadecimal digits.
 * If the string contains only 6 digits, the alpha channel is set to fully opaque (255).
 *
 * @param hexColor A string representing the color in hexadecimal format (e.g., "#RRGGBB", "RRGGBB", "#AARRGGBB", or "AARRGGBB").
 * @return A [Color] object representing the parsed color.
 * @throws IllegalArgumentException if the input string has an invalid length (neither 6 nor 8 characters, excluding the optional '#').
 *
 * ```
 * - "#RRGGBB" or "RRGGBB" (6 digits): Adds an alpha channel of 255 (opaque).
 * - "#AARRGGBB" or "AARRGGBB" (8 digits): Uses the specified alpha channel.
 * ```
 */
fun Color.Companion.parseColor(hexColor: String): Color {
    val colorHEX = if (hexColor[0] == '#') hexColor.substring(1) else hexColor

    // Add alpha if the input is in the 6-digit format
    val colorARGB = when (colorHEX.length) {
        6 -> "FF$colorHEX".toLong(16) // Prepend 'FF' for fully opaque alpha
        8 -> colorHEX.toLong(16)      // Use the 8-digit ARGB directly
        else -> throw IllegalArgumentException("Unknown color format")
    }

    return Color(
        alpha = (colorARGB.shr(24) and 0xFF).toInt(),
        red = (colorARGB.shr(16) and 0xFF).toInt(),
        green = (colorARGB.shr(8) and 0xFF).toInt(),
        blue = (colorARGB.shr(0) and 0xFF).toInt(),
    )
}

/**
 * Darkens the color by the specified factor, where 0.0 is the darkest and 1.0 is the original color.
 */
inline fun Color.darken(@FloatRange(from = 0.0, to = 1.0) factor: Float = 1f): Color =
    copy(
        red = red * factor,
        green = green * factor,
        blue = blue * factor,
        alpha = alpha,
    )
