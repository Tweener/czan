package com.tweener.czan.preview.designsystem.atom.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.tweener.czan.designsystem.atom.bars.NavigationBar
import com.tweener.czan.designsystem.atom.bars.NavigationBarDefaults
import com.tweener.czan.designsystem.atom.bars.NavigationBarItem
import com.tweener.czan.designsystem.atom.bars.NavigationBarItemDefaults
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
            NavigationBarItem(label = "Favorites", selected = false, icon = Icons.Default.Favorite, onClick = {})
            NavigationBarItem(label = "Profile", selected = false, icon = Icons.Default.Person, onClick = {})
        }
    }
}

@UiModePreviews
@Composable
private fun NavigationBarColorsPreview() {
    CzanThemePreview {
        val itemColors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Red,
            unselectedIconColor = Color.Gray,
            selectedTextColor = Color.Red,
            unselectedTextColor = Color.Gray,
            indicatorColor = Color.Blue.copy(alpha = 0.3f),
        )

        NavigationBar(
            colors = NavigationBarDefaults.colors(containerColor = Color.Red.copy(alpha = 0.3f)),
        ) {
            NavigationBarItem(label = "Home", selected = true, icon = Icons.Default.Home, onClick = {}, colors = itemColors)
            NavigationBarItem(label = "Favorites", selected = false, icon = Icons.Default.Favorite, onClick = {}, colors = itemColors)
            NavigationBarItem(label = "Profile", selected = false, icon = Icons.Default.Person, onClick = {}, colors = itemColors)
        }
    }
}
