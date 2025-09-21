import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.compose.ui.window.ComposeViewport

/**
 * @author Vivien Mahe
 * @since 15/10/2024
 */

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(content = { ButtonDemo() })
}
