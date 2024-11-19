package com.tweener.czan._internal.kotlinextensions

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

fun String.applySpanStyle(spanStyle: SpanStyle, vararg substrings: String): AnnotatedString {
    val spanStyles = substrings.toList().map { text ->
        with(this.indexOf(text)) {
            AnnotatedString.Range(
                item = spanStyle,
                start = this,
                end = this + text.length
            )
        }
    }

    return AnnotatedString(text = this, spanStyles = spanStyles)
}

/**
 * Applies a [FontWeight.Bold] to the given [substrings] to be found in this String.
 */
fun String.bold(vararg substrings: String): AnnotatedString =
    applySpanStyle(spanStyle = SpanStyle(fontWeight = FontWeight.Bold), substrings = substrings)

/**
 * Applies a [FontStyle.Italic] to the given [substrings] to be found in this String.
 */
fun String.italic(vararg substrings: String): AnnotatedString =
    applySpanStyle(spanStyle = SpanStyle(fontStyle = FontStyle.Italic), substrings = substrings)

