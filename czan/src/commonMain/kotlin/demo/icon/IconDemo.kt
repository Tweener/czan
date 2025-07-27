package demo.icon

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import demo._internal.SectionFlowContent
import io.github.tweener.czan.generated.resources.Res
import io.github.tweener.czan.generated.resources.apple_logo
import io.github.tweener.czan.generated.resources.chevron_left
import io.github.tweener.czan.generated.resources.chevron_right
import io.github.tweener.czan.generated.resources.email
import io.github.tweener.czan.generated.resources.google_logo
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun IconDemo() {
    CzanThemePreview {
        PreviewBox {
            Section(title = "Material Icons") {
                SectionFlowContent {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Person",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }

            Section(title = "Custom Tinted Icons") {
                SectionFlowContent {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        tint = Color.Red,
                        contentDescription = "Red Favorite"
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        tint = Color.Yellow,
                        contentDescription = "Yellow Star"
                    )
                    Icon(
                        imageVector = Icons.Default.Home,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = "Primary Home"
                    )
                    Icon(
                        imageVector = Icons.Default.Settings,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = "Secondary Settings"
                    )
                }
            }

            Section(title = "Different Sizes") {
                SectionFlowContent {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Small Star",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Medium Star",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Large Star",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        modifier = Modifier.size(48.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Extra Large Star",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }

            Section(title = "Resource Icons") {
                SectionFlowContent {
                    Icon(
                        resource = Res.drawable.chevron_left,
                        contentDescription = "Chevron Left",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        resource = Res.drawable.chevron_right,
                        contentDescription = "Chevron Right",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        resource = Res.drawable.email,
                        contentDescription = "Email",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        resource = Res.drawable.apple_logo,
                        contentDescription = "Apple Logo",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                    Icon(
                        resource = Res.drawable.google_logo,
                        contentDescription = "Google Logo",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }

            Section(title = "Tinted Resource Icons") {
                SectionFlowContent {
                    Icon(
                        resource = Res.drawable.chevron_left,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = "Primary Chevron Left",
                    )
                    Icon(
                        resource = Res.drawable.chevron_right,
                        tint = MaterialTheme.colorScheme.error,
                        contentDescription = "Error Chevron Right",
                    )
                    Icon(
                        resource = Res.drawable.email,
                        tint = Color.Blue,
                        contentDescription = "Blue Email",
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun IconDemoPreview() {
    CzanThemePreview {
        IconDemo()
    }
}
