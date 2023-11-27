package com.tweener.czan.android.component.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.android.theme.CzanTheme

/**
 * @author Vivien Mahe
 * @since 11/10/2023
 */

@Composable
fun OutlineText(
    text: String,
    modifier: Modifier = Modifier,
    outlineOffset: Dp = 2.dp,
    style: TextStyle = LocalTextStyle.current,
    color: Color = Color.Unspecified,
    outlineColor: Color = Color.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    lines: Int? = null,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
) {
    Box(modifier = modifier) {
        Text(
            modifier = Modifier.offset(x = outlineOffset, y = outlineOffset),
            text = text,
            color = color,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = lines ?: maxLines,
            minLines = lines ?: minLines,
            style = style,
        )

        // Outline
        Text(
            text = text,
            color = outlineColor,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = lines ?: maxLines,
            minLines = lines ?: minLines,
            style = style,
        )
    }
}

@UiModePreviews
@Composable
private fun OutlineTextPreview() {
    CzanTheme {
        OutlineText(
            text = "This is an outline text",
            color = Color.Black,
            outlineColor = Color.White,
            outlineOffset = 4.dp
        )
    }
}
