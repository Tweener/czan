package com.tweener.czan.android.preview.designsystem.atom.bars

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.bars.CenterAlignedTopAppBar
import com.tweener.czan.designsystem.atom.bars.SimpleTopBar
import com.tweener.czan.designsystem.atom.bars.TopBarWithBackButton
import com.tweener.czan.designsystem.atom.bars.TopBarWithCloseButton
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun TopLevelScreenTopBarPreview() {
    CzanThemePreview {
        CenterAlignedTopAppBar(
            title = "App name",
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
}

@UiModePreviews
@Composable
private fun SimpleTopBarPreview() {
    CzanThemePreview {
        SimpleTopBar(
            title = "App name",
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
}

@UiModePreviews
@Composable
private fun TopBarWithBackButtonPreview() {
    CzanThemePreview {
        TopBarWithBackButton(
            title = "Title",
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
}

@UiModePreviews
@Composable
private fun TopBarWithCloseButtonPreview() {
    CzanThemePreview {
        TopBarWithCloseButton(
            title = "Title",
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
}
