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
 * Example usage:
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
        var lastIndex = 0

        substrings.forEach { substring ->
            val startIndex = this@applySpanStyle.indexOf(substring)

            if (startIndex != -1) {
                // Append text before the styled substring
                append(this@applySpanStyle.substring(lastIndex, startIndex))

                withLink(
                    link = LinkAnnotation.Clickable(
                        tag = substring,
                        styles = TextLinkStyles(spanStyle),
                        linkInteractionListener = { link -> onClick?.invoke(link) }),
                ) {
                    append(substring)
                }

                lastIndex = startIndex + substring.length
            }
        }

        // Append remaining text after the last styled substring
        append(this@applySpanStyle.substring(lastIndex, this@applySpanStyle.length))
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

