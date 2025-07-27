package demo.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.button.ButtonStyle
import com.tweener.czan.designsystem.atom.scaffold.Scaffold
import com.tweener.czan.designsystem.atom.snackbar.Snackbar
import com.tweener.czan.designsystem.atom.snackbar.SnackbarDefaults
import com.tweener.czan.designsystem.atom.snackbar.rememberSnackbarHostState
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.CzanThemePreview
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun SnackbarDemo() {
    val snackbarHostState = rememberSnackbarHostState()
    val scope = rememberCoroutineScope()

    CzanThemePreview {
        Scaffold(
            snackbarHost = {
                Snackbar(
                    hostState = snackbarHostState,
                    colors = SnackbarDefaults.snackbarColors()
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
            ) {
                Text(
                    text = "Snackbar Demo",
                    style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
                )
                
                Text(
                    text = "Click the buttons below to show different types of snackbars",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
                )

                Button(
                    text = "Show Simple Snackbar",
                    style = ButtonStyle.PRIMARY,
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "This is a simple snackbar message"
                            )
                        }
                    }
                )

                Button(
                    text = "Show Snackbar with Action",
                    style = ButtonStyle.SECONDARY,
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Message sent",
                                actionLabel = "Undo"
                            )
                        }
                    }
                )

                Button(
                    text = "Show Long Message",
                    style = ButtonStyle.TERTIARY,
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "This is a much longer snackbar message that demonstrates how text wraps in the snackbar component",
                                actionLabel = "Dismiss"
                            )
                        }
                    }
                )

                Button(
                    text = "Show Error Snackbar",
                    style = ButtonStyle.ERROR,
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Error: Failed to save changes",
                                actionLabel = "Retry"
                            )
                        }
                    }
                )

                Button(
                    text = "Show Success Snackbar",
                    style = ButtonStyle.PRIMARY,
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "✓ Changes saved successfully",
                                actionLabel = "View"
                            )
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun SnackbarDemoPreview() {
    CzanThemePreview {
        SnackbarDemo()
    }
}