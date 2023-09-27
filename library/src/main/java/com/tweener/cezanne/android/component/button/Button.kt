package com.tweener.cezanne.android.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
    icon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    Button(
        modifier = modifier.height(size.height),
        enabled = enabled,
        onClick = { onClick?.invoke() },
        contentPadding = if (icon != null && text != null) size.contentWithIconPadding else size.contentPadding,
        shape = size.shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (outlined) Color.Transparent else style.containerColor,
            contentColor = if (outlined) style.containerColor else style.contentColor,
            disabledContainerColor = style.disabledContainerColor,
            disabledContentColor = style.disabledContentColor
        ),
        border = if (outlined) BorderStroke(1.dp, style.containerColor) else null
    ) {
        if (icon != null) {
            val endPadding = if (text != null) Size.Padding.ExtraSmall else 0.dp

            Icon(
                modifier = Modifier.padding(end = endPadding),
                imageVector = icon,
                contentDescription = null
            )
        }

        if (text != null) {
            Text(
                text = text,
                style = size.textStyle
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
private fun PrimaryButtonRegularWithIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            icon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            icon = Icons.Rounded.Add
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
private fun PrimaryButtonRegularWithIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            icon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            icon = Icons.Rounded.Add
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
private fun SecondaryButtonRegularWithIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.SECONDARY,
            icon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            icon = Icons.Rounded.Add
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
private fun SecondaryButtonRegularWithIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.SECONDARY,
            icon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            icon = Icons.Rounded.Add
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
private fun TertiaryButtonRegularWithIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.TERTIARY,
            icon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            icon = Icons.Rounded.Add
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
private fun TertiaryButtonRegularWithIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.TERTIARY,
            icon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            icon = Icons.Rounded.Add
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
private fun ErrorButtonRegularWithIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.ERROR,
            icon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithIconEnabledPreview() {
    CezanneTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            icon = Icons.Rounded.Add
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
private fun ErrorButtonRegularWithIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.ERROR,
            icon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithIconDisabledPreview() {
    CezanneTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            icon = Icons.Rounded.Add
        )
    }
}

// endregion Preview Error
