package com.tweener.czan.designsystem.atom.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.theme.Size
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

/**
 * @author Vivien Mahe
 * @since 20/04/2024
 */

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LeadingIconText(
    text: String,
    icon: DrawableResource,
    modifier: Modifier = Modifier,
    contentPadding: Dp = Size.Padding.Small,
    iconSize: Dp = 24.dp,
    iconTint: Color = Color.Unspecified,
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
    LeadingIconText(
        modifier = modifier,
        text = text,
        icon = {
            Icon(
                modifier = Modifier.size(iconSize),
                resource = icon,
                tint = iconTint,
            )
        },
        contentPadding = contentPadding,
        style = style,
        color = color,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = overflow,
        lines = lines,
        maxLines = maxLines,
        minLines = minLines,
    )
}

@Composable
fun LeadingIconText(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    contentPadding: Dp = Size.Padding.Small,
    iconSize: Dp = 24.dp,
    iconTint: Color = Color.Unspecified,
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
    LeadingIconText(
        modifier = modifier,
        text = text,
        icon = {
            Icon(
                modifier = Modifier.size(iconSize),
                imageVector = icon,
                tint = iconTint,
            )
        },
        contentPadding = contentPadding,
        style = style,
        color = color,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = overflow,
        lines = lines,
        maxLines = maxLines,
        minLines = minLines,
    )
}

@Composable
private fun LeadingIconText(
    text: String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: Dp = Size.Padding.Small,
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
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(contentPadding),
    ) {
        icon()

        Text(
            text = text,
            color = color,
            style = style,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            lines = lines,
            maxLines = maxLines,
            minLines = minLines,
        )
    }
}
