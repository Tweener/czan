package demo.bars

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.bars.CenterAlignedTopAppBar
import com.tweener.czan.designsystem.atom.bars.NavigationBar
import com.tweener.czan.designsystem.atom.bars.NavigationBarItem
import com.tweener.czan.designsystem.atom.bars.SimpleTopBar
import com.tweener.czan.designsystem.atom.bars.TopBarAction
import com.tweener.czan.designsystem.atom.bars.TopBarWithBackButton
import com.tweener.czan.designsystem.atom.bars.TopBarWithCloseButton
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun BarsDemo() {
    var selectedNavItem by remember { mutableIntStateOf(0) }

    CzanThemePreview {
        PreviewBox {
            Section(title = "Top App Bars") {
                SimpleTopBar(
                    title = "Simple Top Bar",
                    textStyle = MaterialTheme.typography.titleLarge,
                    actions = {
                        TopBarAction(
                            icon = Icons.Default.Search,
                            onClick = { },
                            contentDescription = "Search"
                        )
                        TopBarAction(
                            icon = Icons.Default.Settings,
                            onClick = { },
                            contentDescription = "Settings"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                CenterAlignedTopAppBar(
                    title = "Center Aligned Top Bar",
                    textStyle = MaterialTheme.typography.titleLarge,
                    actions = {
                        TopBarAction(
                            icon = Icons.Default.Add,
                            onClick = { },
                            contentDescription = "Add"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TopBarWithBackButton(
                    title = "Top Bar with Back Button",
                    textStyle = MaterialTheme.typography.titleLarge,
                    onBackClicked = { },
                    actions = {
                        TopBarAction(
                            icon = Icons.Default.Settings,
                            onClick = { },
                            contentDescription = "Settings"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TopBarWithCloseButton(
                    title = "Top Bar with Close Button",
                    textStyle = MaterialTheme.typography.titleLarge,
                    onBackClicked = { },
                    actions = {
                        TopBarAction(
                            icon = Icons.Default.Add,
                            onClick = { },
                            contentDescription = "Add"
                        )
                    }
                )
            }

            Section(title = "Navigation Bar") {
                NavigationBar {
                    NavigationBarItem(
                        icon = Icons.Default.Home,
                        selected = selectedNavItem == 0,
                        onClick = { selectedNavItem = 0 },
                        label = "Home"
                    )
                    NavigationBarItem(
                        icon = Icons.Default.Search,
                        selected = selectedNavItem == 1,
                        onClick = { selectedNavItem = 1 },
                        label = "Search"
                    )
                    NavigationBarItem(
                        icon = Icons.Default.Person,
                        selected = selectedNavItem == 2,
                        onClick = { selectedNavItem = 2 },
                        label = "Profile"
                    )
                    NavigationBarItem(
                        icon = Icons.Default.Settings,
                        selected = selectedNavItem == 3,
                        onClick = { selectedNavItem = 3 },
                        label = "Settings"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun BarsDemoPreview() {
    CzanThemePreview {
        BarsDemo()
    }
}