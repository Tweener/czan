package com.tweener.czan.designsystem.atom.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

/**
 * @author Vivien Mahe
 * @since 24/08/2023
 */

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: StringResource? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text?.let { stringResource(resource = it) },
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text,
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: StringResource? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    leadingIcon: DrawableResource? = null,
    trailingIcon: DrawableResource? = null,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text?.let { stringResource(resource = it) },
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        leadingIcon = leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), resource = it, contentDescription = null) } },
        trailingIcon = trailingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), resource = it, contentDescription = null) } },
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    leadingIcon: DrawableResource? = null,
    trailingIcon: DrawableResource? = null,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text,
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        leadingIcon = leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), resource = it, contentDescription = null) } },
        trailingIcon = trailingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), resource = it, contentDescription = null) } },
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: StringResource? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text?.let { stringResource(resource = it) },
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        leadingIcon = leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
        trailingIcon = trailingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
        onClick = onClick,
    )
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    CzanButton(
        modifier = modifier,
        text = text,
        size = size,
        style = style,
        fontWeight = fontWeight,
        enabled = enabled,
        outlined = outlined,
        leadingIcon = leadingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
        trailingIcon = trailingIcon?.let { { Icon(modifier = Modifier.size(size.iconSize), imageVector = it, contentDescription = null) } },
        onClick = onClick,
    )
}

@Composable
private fun CzanButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    fontWeight: FontWeight = FontWeight.Normal,
    enabled: Boolean = true,
    outlined: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    val contentPadding = when {
        text != null -> {
            when {
                leadingIcon != null -> size.contentWithLeadingIconPadding
                trailingIcon != null -> size.contentWithTrailingIconPadding
                else -> size.contentPadding
            }
        }

        else -> size.contentPadding
    }

    Button(
        modifier = modifier.height(size.height),
        enabled = enabled,
        onClick = { onClick?.invoke() },
        contentPadding = contentPadding,
        shape = size.shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (outlined) Color.Transparent else style.containerColor,
            contentColor = if (outlined) style.containerColor else style.contentColor,
            disabledContainerColor = style.disabledContainerColor,
            disabledContentColor = style.disabledContentColor
        ),
        border = if (outlined) BorderStroke(1.dp, style.containerColor) else null
    ) {
        if (leadingIcon != null) {
            leadingIcon()

            if (text != null) {
                Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
            }
        }

        if (text != null) {
            Text(
                text = text,
                style = size.textStyle,
                fontWeight = fontWeight,
            )
        }

        if (trailingIcon != null) {
            if (text != null) {
                Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
            }

            trailingIcon()
        }
    }
}
