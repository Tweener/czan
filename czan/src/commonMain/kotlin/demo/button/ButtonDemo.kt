/**
 * @author Vivien Mahe
 * @since 15/10/2024
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.button.ButtonLoadingStyle
import com.tweener.czan.designsystem.atom.button.ButtonSize
import com.tweener.czan.preview.CzanThemePreview

@Composable
fun ButtonDemo(
    modifier: Modifier = Modifier,
) {
    CzanThemePreview {
        Box(
            modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center,
        ) {
            Button(
                text = "Enabled",
                enabled = true,
                size = ButtonSize.SMALL,
                loadingStyle = ButtonLoadingStyle.BOUNCE,
            )
        }
    }
}
