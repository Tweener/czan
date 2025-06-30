import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import demo.Demo
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.url.URLSearchParams

/**
 * @author Vivien Mahe
 * @since 15/10/2024
 */

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val iFrameParams = URLSearchParams(document.location?.search)
    val id = iFrameParams.get("id")

    onWasmReady {
        CanvasBasedWindow(canvasElementId = "ComposeTarget") { Demo(demoId = id) }
    }
}
