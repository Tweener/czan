package com.tweener.czan.preview.designsystem.atom.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.czan.designsystem.atom.bars.NavigationBar
import com.tweener.czan.designsystem.atom.bars.NavigationBarItem
import com.tweener.czan.designsystem.atom.scaffold.Scaffold
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 20/02/2024
 */

@UiModePreviews
@Composable
private fun ScaffoldPreview() {
    CzanThemePreview {
        Scaffold(
            navigationBar = {
                NavigationBar {
                    NavigationBarItem(label = "Home", selected = true, icon = Icons.Default.Home, onClick = {})
                    NavigationBarItem(label = "Favorites", selected = true, icon = Icons.Default.Favorite, onClick = {})
                    NavigationBarItem(label = "Profile", selected = true, icon = Icons.Default.Person, onClick = {})
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .consumeWindowInsets(innerPadding)
                    .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)),
            ) {
                Text(text = "This is a text")
            }
        }
    }
}
