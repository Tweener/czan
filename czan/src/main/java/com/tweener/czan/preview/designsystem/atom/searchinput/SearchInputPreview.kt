package com.tweener.czan.preview.designsystem.atom.searchinput

import androidx.compose.runtime.Composable
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.searchinput.SearchInput
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun SearchInputPreview() {
    CzanThemePreview {
        SearchInput(
            placeholderText = "Search mood or category"
        )
    }
}
