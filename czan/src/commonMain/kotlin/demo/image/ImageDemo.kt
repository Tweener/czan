package demo.image

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.image.Image
import com.tweener.czan.designsystem.atom.image.ImageSize
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import demo._internal.SectionFlowContent
import io.github.tweener.czan.generated.resources.Res
import io.github.tweener.czan.generated.resources.profile_header_background
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun ImageDemo() {
    CzanThemePreview {
        PreviewBox {
            Section(title = "Vector Images") {
                SectionFlowContent {
                    Image(
                        modifier = Modifier.size(48.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star Icon"
                    )
                    Image(
                        modifier = Modifier.size(48.dp),
                        imageVector = Icons.Default.Star,
                        colorFilter = ColorFilter.tint(Color.Red),
                        contentDescription = "Red Star Icon"
                    )
                    Image(
                        modifier = Modifier.size(48.dp),
                        imageVector = Icons.Default.Star,
                        colorFilter = ColorFilter.tint(Color.Blue),
                        contentDescription = "Blue Star Icon"
                    )
                }
            }

            Section(title = "Resource Images") {
                SectionFlowContent {
                    Image(
                        modifier = Modifier.size(64.dp),
                        resource = Res.drawable.profile_header_background,
                        contentDescription = "Profile Background"
                    )
                    Image(
                        modifier = Modifier.size(64.dp),
                        resource = Res.drawable.profile_header_background,
                        contentScale = ContentScale.Fit,
                        contentDescription = "Profile Background Fit"
                    )
                    Image(
                        modifier = Modifier.size(64.dp),
                        resource = Res.drawable.profile_header_background,
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Profile Background Fill"
                    )
                }
            }

            Section(title = "Different Sizes") {
                SectionFlowContent {
                    Image(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Small Star"
                    )
                    Image(
                        modifier = Modifier.size(48.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Medium Star"
                    )
                    Image(
                        modifier = Modifier.size(64.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Large Star"
                    )
                    Image(
                        modifier = Modifier.size(80.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Extra Large Star"
                    )
                }
            }

            Section(title = "Network Images") {
                SectionFlowContent {
                    Image(
                        modifier = Modifier.size(80.dp),
                        imageUrl = "https://picsum.photos/200/200?random=1",
                        placeholderRes = Res.drawable.profile_header_background,
                        imageSize = ImageSize(200, 200)
                    )
                    Image(
                        modifier = Modifier.size(80.dp),
                        imageUrl = "https://picsum.photos/200/200?random=2",
                        placeholderRes = Res.drawable.profile_header_background,
                        imageSize = ImageSize(200, 200),
                        circleCrop = true
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ImageDemoPreview() {
    CzanThemePreview {
        ImageDemo()
    }
}