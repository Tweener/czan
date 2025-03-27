package com.tweener.czan.designsystem.atom.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Vivien Mahe
 * @since 27/03/2025
 */

@Composable
fun HighlightedText(
    text: String,
    highlights: List<String>,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    color: Color = Color.Unspecified,
    highlightContainerColor: Color = MaterialTheme.colorScheme.primary,
    highlightContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null,
    cornerRadius: Dp = 4.dp
) {
    val parts = mutableListOf<AnnotatedPart>()
    var currentIndex = 0
    val sortedHighlights = highlights.sortedBy { text.indexOf(it) }

    for (highlight in sortedHighlights) {
        val start = text.indexOf(highlight, currentIndex)
        if (start == -1) continue
        if (start > currentIndex) {
            parts.add(AnnotatedPart(text.substring(currentIndex, start), false))
        }
        parts.add(AnnotatedPart(highlight, true))
        currentIndex = start + highlight.length
    }

    if (currentIndex < text.length) {
        parts.add(AnnotatedPart(text.substring(currentIndex), false))
    }

    val content: @Composable (String, Color) -> Unit = { value, textColor ->
        Text(
            text = value,
            color = textColor,
            style = style,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            textAlign = textAlign,
        )
    }

    Row(modifier = modifier) {
        parts.forEach { part ->
            if (part.highlighted) {
                Box(
                    modifier = Modifier
                        .background(color = highlightContainerColor, shape = RoundedCornerShape(cornerRadius))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    content(part.text, highlightContentColor)
                }
            } else {
                content(part.text, color)
            }
        }
    }
}

private data class AnnotatedPart(val text: String, val highlighted: Boolean)
