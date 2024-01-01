package com.tweener.czan.android.preview.designsystem.atom.switch

import androidx.compose.runtime.Composable
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.switch.Switch
import com.tweener.czan.designsystem.atom.switch.SwitchStyle
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

// region Preview Primary

@UiModePreviews
@Composable
private fun SwitchPrimaryCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = true)
    }
}

@UiModePreviews
@Composable
private fun SwitchPrimaryNotCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = false)
    }
}

// endregion Preview Primary

// region Preview Secondary

@UiModePreviews
@Composable
private fun SwitchSecondaryCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = true, style = SwitchStyle.SECONDARY)
    }
}

@UiModePreviews
@Composable
private fun SwitchSecondaryNotCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = false, style = SwitchStyle.SECONDARY)
    }
}

// endregion Preview Secondary

// region Preview Tertiary

@UiModePreviews
@Composable
private fun SwitchTertiaryCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = true, style = SwitchStyle.TERTIARY)
    }
}

@UiModePreviews
@Composable
private fun SwitchTertiaryNotCheckedPreview() {
    CzanThemePreview {
        Switch(isChecked = false, style = SwitchStyle.TERTIARY)
    }
}

// endregion Preview Tertiary
