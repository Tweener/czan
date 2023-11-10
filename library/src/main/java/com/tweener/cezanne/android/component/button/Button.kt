package com.tweener.cezanne.android.component.button

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
import androidx.compose.ui.unit.dp
import com.tweener.cezanne.android.component.text.Text
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.theme.CezanneTheme
import com.tweener.cezanne.android.theme.Size

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
    Button(
        modifier = modifier.height(size.height),
        enabled = enabled,
        onClick = { onClick?.invoke() },
        contentPadding = if (leadingIcon != null && text != null) size.contentWithIconPadding else size.contentPadding,
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
    CezanneTheme {
        Button(
            text = "Enabled",
            enabled = true
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularWithLeadingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularWithTrailingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithLeadingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithTrailingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled",
            enabled = false
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularWithLeadingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularWithTrailingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithLeadingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithTrailingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularOutlinedEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled",
            enabled = true,
            outlined = true
        )
    }
}

// endregion Preview Primary

// region Preview Secondary

@UiModePreviews
@Composable
private fun SecondaryButtonRegularEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled",
            enabled = true,
            style = ButtonStyle.SECONDARY
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularWithLeadingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularWithTrailingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithLeadingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithTrailingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled",
            enabled = false,
            style = ButtonStyle.SECONDARY
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularWithLeadingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularWithTrailingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithLeadingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithTrailingIconDisabledPreview() {
    CezanneTheme {
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

@UiModePreviews
@Composable
private fun TertiaryButtonRegularEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled",
            enabled = true,
            style = ButtonStyle.TERTIARY
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularWithLeadingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularWithTrailingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithLeadingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithTrailingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled",
            enabled = false,
            style = ButtonStyle.TERTIARY
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularWithLeadingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularWithTrailingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithLeadingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithTrailingIconDisabledPreview() {
    CezanneTheme {
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

@UiModePreviews
@Composable
private fun ErrorButtonRegularEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled",
            enabled = true,
            style = ButtonStyle.ERROR
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularWithLeadingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularWithTrailingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithLeadingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithTrailingIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled",
            enabled = false,
            style = ButtonStyle.ERROR
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularWithLeadingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularWithTrailingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithLeadingIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithTrailingIconDisabledPreview() {
    CezanneTheme {
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
