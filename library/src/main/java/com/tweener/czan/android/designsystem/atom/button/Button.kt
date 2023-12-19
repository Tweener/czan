package com.tweener.czan.android.designsystem.atom.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.tweener.czan.android.designsystem.atom.text.Text
import com.tweener.czan.android.preview.CzanThemePreview
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.android.theme.Size

/**
 * @author Vivien Mahe
 * @since 24/08/2023
 */

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    enabled: Boolean = true,
    outlined: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    val shouldUseIconPadding = (leadingIcon != null || trailingIcon != null) && text != null

    Button(
        modifier = modifier.height(size.height),
        enabled = enabled,
        onClick = { onClick?.invoke() },
        contentPadding = if (shouldUseIconPadding) size.contentWithIconPadding else size.contentPadding,
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
            Icon(
                imageVector = leadingIcon,
                contentDescription = null
            )

            if (text != null) {
                Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
            }
        }

        if (text != null) {
            Text(
                text = text,
                style = size.textStyle
            )
        }

        if (trailingIcon != null) {
            if (text != null) {
                Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
            }

            Icon(
                imageVector = trailingIcon,
                contentDescription = null
            )
        }
    }
}

// region Preview Primary

@UiModePreviews
@Composable
private fun PrimaryButtonRegularEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonSmallEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonRegularWithLeadingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonRegularWithTrailingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonSmallRegularWithLeadingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonSmallRegularWithTrailingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonRegularDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled",
            enabled = false
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonSmallRegularDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonRegularWithLeadingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonRegularWithTrailingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonSmallRegularWithLeadingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonSmallRegularWithTrailingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonRegularOutlinedEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true,
            outlined = true
        )
    }
}

// endregion Preview Primary

// region Preview Secondary

@PreviewLightDark
@Composable
private fun SecondaryButtonRegularEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true,
            style = ButtonStyle.SECONDARY
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonSmallEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonRegularWithLeadingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonRegularWithTrailingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonSmallRegularWithLeadingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonSmallRegularWithTrailingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonRegularDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled",
            enabled = false,
            style = ButtonStyle.SECONDARY
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonSmallRegularDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonRegularWithLeadingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonRegularWithTrailingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonSmallRegularWithLeadingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun SecondaryButtonSmallRegularWithTrailingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

// endregion Preview Secondary

// region Preview Tertiary

@PreviewLightDark
@Composable
private fun TertiaryButtonRegularEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true,
            style = ButtonStyle.TERTIARY
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonSmallEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonRegularWithLeadingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonRegularWithTrailingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonSmallRegularWithLeadingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonSmallRegularWithTrailingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonRegularDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled",
            enabled = false,
            style = ButtonStyle.TERTIARY
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonSmallRegularDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonRegularWithLeadingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonRegularWithTrailingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonSmallRegularWithLeadingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun TertiaryButtonSmallRegularWithTrailingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

// endregion Preview Tertiary

// region Preview Error

@PreviewLightDark
@Composable
private fun ErrorButtonRegularEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true,
            style = ButtonStyle.ERROR
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonSmallEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonRegularWithLeadingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonRegularWithTrailingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonSmallRegularWithLeadingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonSmallRegularWithTrailingIconEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonRegularDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled",
            enabled = false,
            style = ButtonStyle.ERROR
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonSmallRegularDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonRegularWithLeadingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonRegularWithTrailingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonSmallRegularWithLeadingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorButtonSmallRegularWithTrailingIconDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

// endregion Preview Error
