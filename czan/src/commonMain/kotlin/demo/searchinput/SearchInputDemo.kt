package demo.searchinput

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.searchinput.SearchInput
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun SearchInputDemo() {
    var searchQuery1 by remember { mutableStateOf("") }
    var searchQuery2 by remember { mutableStateOf("") }
    var searchQuery3 by remember { mutableStateOf("") }

    CzanThemePreview {
        PreviewBox {
            Section(title = "Basic Search Input") {
                SearchInput(
                    modifier = Modifier.fillMaxWidth(),
                    placeholderText = "Search...",
                    onQueryChanged = { searchQuery1 = it }
                )
                
                if (searchQuery1.isNotEmpty()) {
                    Text(
                        text = "Query: $searchQuery1",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            Section(title = "Search with Custom Placeholder") {
                SearchInput(
                    modifier = Modifier.fillMaxWidth(),
                    placeholderText = "Search for products, brands, or categories...",
                    onQueryChanged = { searchQuery2 = it }
                )
                
                if (searchQuery2.isNotEmpty()) {
                    Text(
                        text = "Searching for: $searchQuery2",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            Section(title = "Search with Query Counter") {
                SearchInput(
                    modifier = Modifier.fillMaxWidth(),
                    placeholderText = "Type to search...",
                    onQueryChanged = { searchQuery3 = it }
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Character count: ${searchQuery3.length}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                if (searchQuery3.length >= 3) {
                    Text(
                        text = "✓ Ready to search",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                } else if (searchQuery3.isNotEmpty()) {
                    Text(
                        text = "Type at least 3 characters",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            Section(title = "Multiple Search Inputs") {
                SearchInput(
                    modifier = Modifier.fillMaxWidth(),
                    placeholderText = "Search users...",
                    onQueryChanged = { }
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                SearchInput(
                    modifier = Modifier.fillMaxWidth(),
                    placeholderText = "Search messages...",
                    onQueryChanged = { }
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                SearchInput(
                    modifier = Modifier.fillMaxWidth(),
                    placeholderText = "Search files...",
                    onQueryChanged = { }
                )
            }
        }
    }
}

@Preview
@Composable
private fun SearchInputDemoPreview() {
    CzanThemePreview {
        SearchInputDemo()
    }
}