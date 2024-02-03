package com.tweener.czan.preview.designsystem.atom.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.button.ButtonSize
import com.tweener.czan.designsystem.atom.button.ButtonStyle
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

// region Preview Primary

@UiModePreviews
@Composable
private fun PrimaryButtonBigEnabledPreview() {
    CzanThemePreview {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.BIG,
        )
    }
}

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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
@Composable
private fun PrimaryButtonRegularDisabledPreview() {
    CzanThemePreview {
        Button(
            text = "Disabled",
            enabled = false
        )
    }
}

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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

@UiModePreviews
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
