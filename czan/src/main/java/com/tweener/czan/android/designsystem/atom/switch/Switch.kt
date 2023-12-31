package com.tweener.czan.android.designsystem.atom.switch

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.tweener.czan.android.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 29/08/2023
 */

@Composable
fun Switch(
    modifier: Modifier = Modifier,
    style: SwitchStyle = SwitchStyle.PRIMARY,
    isChecked: Boolean = false,
    onCheckedChange: ((Boolean) -> Unit)? = null
) {
    var checked by remember { mutableStateOf(isChecked) }
    val iconVector = if (checked) Icons.Outlined.Check else Icons.Outlined.Close

    Switch(
        modifier = modifier,
        checked = checked,
        onCheckedChange = {
            checked = it
            onCheckedChange?.invoke(it)
        },
        thumbContent = {
            Icon(
                modifier = Modifier.size(SwitchDefaults.IconSize),
                imageVector = iconVector,
                contentDescription = null,
            )
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = style.checkedThumbColor,
            uncheckedThumbColor = style.uncheckedThumbColor,
            checkedTrackColor = style.checkedTrackColor,
            uncheckedTrackColor = style.uncheckedTrackColor,
            checkedIconColor = style.checkedIconColor,
            uncheckedIconColor = style.uncheckedIconColor,
        )
    )
}

// region Preview Primary

@PreviewLightDark
@Composable
private fun SwitchPrimaryCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = true)
    }
}

@PreviewLightDark
@Composable
private fun SwitchPrimaryNotCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = false)
    }
}

// endregion Preview Primary

// region Preview Secondary

@PreviewLightDark
@Composable
private fun SwitchSecondaryCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = true, style = SwitchStyle.SECONDARY)
    }
}

@PreviewLightDark
@Composable
private fun SwitchSecondaryNotCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = false, style = SwitchStyle.SECONDARY)
    }
}

// endregion Preview Secondary

// region Preview Tertiary

@PreviewLightDark
@Composable
private fun SwitchTertiaryCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = true, style = SwitchStyle.TERTIARY)
    }
}

@PreviewLightDark
@Composable
private fun SwitchTertiaryNotCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = false, style = SwitchStyle.TERTIARY)
    }
}

// endregion Preview Tertiary
