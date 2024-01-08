package com.tweener.czan.designsystem.atom.text

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    color: Color = Color.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    lines: Int? = null,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
) {
    var textValue = text

    Text(
        modifier = modifier,
        text = textValue,
        color = color,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = lines ?: maxLines,
        minLines = lines ?: minLines,
        style = style,
        onTextLayout = { textLayoutResult ->
            lines?.let { exactLines ->
                val linesDiff = exactLines - textLayoutResult.lineCount
                if (linesDiff > 0) {
                    textValue = text.addEmptyLines(linesDiff)
                }
            }
        }
    )
}

@Composable
fun Text(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    color: Color = Color.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    lines: Int? = null,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    inlineContent: Map<String, InlineTextContent> = mapOf(),
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = lines ?: maxLines,
        minLines = lines ?: minLines,
        style = style,
        inlineContent = inlineContent,
    )
}

private fun String.addEmptyLines(lines: Int) = this + "\n ".repeat(lines)
