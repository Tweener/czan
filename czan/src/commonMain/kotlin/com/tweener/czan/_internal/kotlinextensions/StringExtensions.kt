package com.tweener.czan._internal.kotlinextensions

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withLink
import com.tweener.czan.designsystem.atom.text.Text

/**
 * Applies a given [SpanStyle] to specified substrings within the main string, returning an [AnnotatedString].
 * This method is useful for styling clickable text segments in a [Text] composable.
 *
 * ### Example usage:
 * ```
 * val text = "Read the Terms and Privacy Policy."
 * val styledText = text.applySpanStyle(
 *     spanStyle = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline),
 *     substrings = listOf("Terms", "Privacy Policy"),
 *     onClick = { link ->
 *         when (link) {
 *             is LinkAnnotation.Clickable -> {
 *                 when (link.tag) {
 *                     "Terms" -> println("Terms Clicked!")
 *                     "Privacy Policy" -> println("Privacy Policy Clicked!")
 *                 }
 *             }
 *         }
 *     }
 * )
 * ```
 *
 * @param spanStyle The [SpanStyle] to apply to the specified substrings.
 * @param substrings The list of substrings that should be styled.
 * @param onClick An optional callback that is triggered when a styled substring is clicked, providing a [LinkAnnotation].
 * @return An [AnnotatedString] with the specified substrings styled.
 */
fun String.applySpanStyle(spanStyle: SpanStyle, substrings: List<String>, onClick: ((LinkAnnotation) -> Unit)? = null): AnnotatedString =
    buildAnnotatedString {
        var currentIndex = 0
        val originalText = this@applySpanStyle

        // Iterate over all substring occurrences while rebuilding the text
        while (currentIndex < originalText.length) {
            // Find the next matching substring
            val nextSubstring = substrings.minByOrNull { substring ->
                val index = originalText.indexOf(substring, currentIndex)
                if (index == -1) Int.MAX_VALUE else index
            }

            val startIndex = nextSubstring?.let { originalText.indexOf(it, currentIndex) } ?: -1

            if (nextSubstring != null && startIndex != -1) {
                // Append text before the found substring (keeping original style)
                append(originalText.substring(currentIndex, startIndex))

                val endIndex = startIndex + nextSubstring.length

                if (onClick != null) {
                    withLink(
                        link = LinkAnnotation.Clickable(
                            tag = nextSubstring,
                            styles = TextLinkStyles(spanStyle),
                            linkInteractionListener = { link -> onClick.invoke(link) }
                        )
                    ) {
                        append(nextSubstring)
                    }
                } else {
                    addStyle(spanStyle, startIndex, endIndex)
                    append(nextSubstring)
                }

                currentIndex = endIndex
            } else {
                // Append remaining text
                append(originalText.substring(currentIndex))
                break
            }
        }
    }

/**
 * Applies a given [SpanStyle] to specified substrings within an [AnnotatedString], allowing for chaining of multiple styles without overriding previous ones.
 *
 * ### Example usage:
 * ```
 * val annotatedText = AnnotatedString("Read the Terms and Privacy Policy.")
 * val styledText = annotatedText.applySpanStyle(
 *     spanStyle = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline),
 *     substrings = listOf("Terms", "Privacy Policy"),
 * )
 * ```
 *
 * ### Chaining Example:
 * ```
 * val styledText = AnnotatedString("Renewal canceled. Expires on February 20, 2025.")
 *     .applySpanStyle(SpanStyle(fontWeight = FontWeight.Bold), listOf("February 20, 2025"))
 *     .applySpanStyle(SpanStyle(color = Color.Red), listOf("Renewal canceled"))
 * ```
 *
 * @param spanStyle The [SpanStyle] to apply to the specified substrings.
 * @param substrings The list of substrings that should be styled.
 * @return A new [AnnotatedString] with the specified substrings styled.
 */
fun AnnotatedString.applySpanStyle(spanStyle: SpanStyle, substrings: List<String>): AnnotatedString =
    buildAnnotatedString {
        append(this@applySpanStyle) // Preserve existing styles

        substrings.forEach { substring ->
            val startIndex = this@applySpanStyle.text.indexOf(substring)

            if (startIndex != -1) {
                addStyle(
                    style = spanStyle,
                    start = startIndex,
                    end = startIndex + substring.length
                )
            }
        }
    }

/**
 * Applies a [FontWeight.Bold] to the given [substrings] to be found in this String.
 */
fun String.bold(substrings: List<String>): AnnotatedString =
    applySpanStyle(spanStyle = SpanStyle(fontWeight = FontWeight.Bold), substrings = substrings)

/**
 * Applies a [FontStyle.Italic] to the given [substrings] to be found in this String.
 */
fun String.italic(substrings: List<String>): AnnotatedString =
    applySpanStyle(spanStyle = SpanStyle(fontStyle = FontStyle.Italic), substrings = substrings)

