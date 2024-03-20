package com.tweener.czan._internal.kotlinextensions

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight

/**
 * Applies a [FontWeight.Bold] to the given [substrings] to be found in this String.
 *
 * @author Vivien Mahe
 * @since 19/03/2024
 */
fun String.bold(
    vararg substrings: String
): AnnotatedString {
    val spanStyles = substrings.toList().map { text ->
        with(this.indexOf(text)) {
            AnnotatedString.Range(
                item = SpanStyle(fontWeight = FontWeight.Bold),
                start = this,
                end = this + text.length
            )
        }
    }

    return AnnotatedString(text = this, spanStyles = spanStyles)
}
