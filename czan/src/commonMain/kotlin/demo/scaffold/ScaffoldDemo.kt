package demo.scaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.bars.NavigationBar
import com.tweener.czan.designsystem.atom.bars.NavigationBarItem
import com.tweener.czan.designsystem.atom.bars.SimpleTopBar
import com.tweener.czan.designsystem.atom.bars.TopBarAction
import com.tweener.czan.designsystem.atom.button.FloatingActionButton
import com.tweener.czan.designsystem.atom.scaffold.Scaffold
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.CzanThemePreview
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun ScaffoldDemo() {
    var selectedNavItem by remember { mutableIntStateOf(0) }

    CzanThemePreview {
        Scaffold(
            topBar = {
                SimpleTopBar(
                    title = "Scaffold Demo",
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
            },
            navigationBar = {
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
            },
            floatingActionButton = {
                FloatingActionButton(
                    icon = Icons.Default.Add,
                    onClick = { }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Scaffold Content Area",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = "This is the main content area of the Scaffold.",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "Selected tab: ${getTabName(selectedNavItem)}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

private fun getTabName(index: Int): String {
    return when (index) {
        0 -> "Home"
        1 -> "Search"
        2 -> "Profile"
        3 -> "Settings"
        else -> "Unknown"
    }
}

@Preview
@Composable
private fun ScaffoldDemoPreview() {
    CzanThemePreview {
        ScaffoldDemo()
    }
}