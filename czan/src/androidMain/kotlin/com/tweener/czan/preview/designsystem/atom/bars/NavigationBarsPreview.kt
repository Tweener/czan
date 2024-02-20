package com.tweener.czan.preview.designsystem.atom.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.bars.NavigationBar
import com.tweener.czan.designsystem.atom.bars.NavigationBarItem
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 20/02/2024
 */

@UiModePreviews
@Composable
private fun NavigationBarPreview() {
    CzanThemePreview {
        NavigationBar {
            NavigationBarItem(label = "Home", selected = true, icon = Icons.Default.Home, onClick = {})
            NavigationBarItem(label = "Favorites", selected = true, icon = Icons.Default.Favorite, onClick = {})
            NavigationBarItem(label = "Profile", selected = true, icon = Icons.Default.Person, onClick = {})
        }
    }
}
