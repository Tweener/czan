package com.tweener.czan.android.preview.designsystem.atom.chip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.chip.Chip
import com.tweener.czan.designsystem.atom.chip.ChipDefaults
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun ChipNoLeadingIconAndNotDeletablePreview() {
    CzanThemePreview {
        Chip(
            title = "Chip title",
            leadingIconVector = null,
            canBeDeleted = false
        )
    }
}

@UiModePreviews
@Composable
private fun ChipLeadingIconAndNotDeletableAndSelectedPreview() {
    CzanThemePreview {
        Chip(
            title = "Chip title",
            leadingIconVector = Icons.Filled.AccountCircle,
            canBeDeleted = false,
            selected = true,
        )
    }
}

@UiModePreviews
@Composable
private fun ChipNoLeadingIconAndDeletablePreview() {
    CzanThemePreview {
        Chip(
            title = "Chip title",
            leadingIconVector = null,
            canBeDeleted = true
        )
    }
}

@UiModePreviews
@Composable
private fun ChipLeadingIconAndDeletablePreview() {
    CzanThemePreview {
        Chip(
            title = "Chip title",
            leadingIconVector = Icons.Filled.Person,
            canBeDeleted = true,
            textStyle = MaterialTheme.typography.titleMedium,
            colors = ChipDefaults.chipColors(
                leadingIconBackgroundColor = Color.Gray,
                leadingIconBorderColor = Color.Red
            ),
            sizes = ChipDefaults.chipSizes(
                iconsSize = 32.dp,
                iconBorderWidth = 1.dp,
                iconPadding = 3.dp,
            ),
            contentPadding = PaddingValues(vertical = 12.dp),
        )
    }
}
