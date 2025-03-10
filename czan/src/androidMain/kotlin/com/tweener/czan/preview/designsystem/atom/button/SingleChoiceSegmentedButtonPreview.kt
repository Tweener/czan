package com.tweener.czan.preview.designsystem.atom.button

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.button.SegmentedButtonDefaults
import com.tweener.czan.designsystem.atom.button.SingleChoiceSegmentedButton
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 10/03/2025
 */

@UiModePreviews
@Composable
private fun SingleChoiceSegmentedButton2ChoicesPreview() {
    CzanThemePreview {
        SingleChoiceSegmentedButton(
            options = listOf("Day", "Week"),
            selectedOption = 0,
            onOptionSelected = {},
        )
    }
}

@UiModePreviews
@Composable
private fun SingleChoiceSegmentedButton3ChoicesPreview() {
    CzanThemePreview {
        SingleChoiceSegmentedButton(
            options = listOf("Day", "Week", "Month"),
            selectedOption = 1,
            onOptionSelected = {},
            textStyle = MaterialTheme.typography.titleMedium,
            colors = SegmentedButtonDefaults.colors(
                activeContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                activeContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                inactiveContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                inactiveContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            )
        )
    }
}
