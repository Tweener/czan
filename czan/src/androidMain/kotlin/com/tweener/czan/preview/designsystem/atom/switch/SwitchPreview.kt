package com.tweener.czan.preview.designsystem.atom.switch

import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.switch.Switch
import com.tweener.czan.designsystem.atom.switch.SwitchStyle
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

// region Preview Primary

@UiModePreviews
@Composable
private fun SwitchPrimaryCheckedPreview() {
    CzanThemePreview {
        Switch(checked = true)
    }
}

@UiModePreviews
@Composable
private fun SwitchPrimaryNotCheckedPreview() {
    CzanThemePreview {
        Switch(checked = false)
    }
}

// endregion Preview Primary

// region Preview Secondary

@UiModePreviews
@Composable
private fun SwitchSecondaryCheckedPreview() {
    CzanThemePreview {
        Switch(checked = true, style = SwitchStyle.SECONDARY)
    }
}

@UiModePreviews
@Composable
private fun SwitchSecondaryNotCheckedPreview() {
    CzanThemePreview {
        Switch(checked = false, style = SwitchStyle.SECONDARY)
    }
}

// endregion Preview Secondary

// region Preview Tertiary

@UiModePreviews
@Composable
private fun SwitchTertiaryCheckedPreview() {
    CzanThemePreview {
        Switch(checked = true, style = SwitchStyle.TERTIARY)
    }
}

@UiModePreviews
@Composable
private fun SwitchTertiaryNotCheckedPreview() {
    CzanThemePreview {
        Switch(checked = false, style = SwitchStyle.TERTIARY)
    }
}

// endregion Preview Tertiary
