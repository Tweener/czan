package com.tweener.czan.preview.designsystem.atom.bars

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.tweener.czan.designsystem.atom.bars.CenterAlignedTopAppBar
import com.tweener.czan.designsystem.atom.bars.SimpleTopBar
import com.tweener.czan.designsystem.atom.bars.TopBarDefaults
import com.tweener.czan.designsystem.atom.bars.TopBarWithBackButton
import com.tweener.czan.designsystem.atom.bars.TopBarWithCloseButton
import com.tweener.czan.designsystem.atom.bars.TopBarWithCustomIcon
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import io.github.tweener.czan.generated.resources.Res
import io.github.tweener.czan.generated.resources.email

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
            textStyle = MaterialTheme.typography.titleLarge,
            colors = TopBarDefaults.colors(
                containerColor = Color.Red.copy(alpha = 0.3f),
                titleColor = Color.Green,
            ),
        )
    }
}

@UiModePreviews
@Composable
private fun SimpleTopBarPreview() {
    CzanThemePreview {
        SimpleTopBar(
            title = "App name",
            textStyle = MaterialTheme.typography.titleLarge,
        )
    }
}

@UiModePreviews
@Composable
private fun SimpleTopBarWithCustomIconPreview() {
    CzanThemePreview {
        TopBarWithCustomIcon(
            title = "App name",
            textStyle = MaterialTheme.typography.titleLarge,
            navigationIcon = Res.drawable.email,
        )
    }
}

@UiModePreviews
@Composable
private fun TopBarWithBackButtonPreview() {
    CzanThemePreview {
        TopBarWithBackButton(
            title = "Title",
            textStyle = MaterialTheme.typography.titleLarge,
            colors = TopBarDefaults.colors(
                containerColor = Color.Red.copy(alpha = 0.3f),
                titleColor = Color.Blue,
            ),
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
