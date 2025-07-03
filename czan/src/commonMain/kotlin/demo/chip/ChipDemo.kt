package demo.chip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.chip.Chip
import com.tweener.czan.designsystem.atom.chip.ChipDefaults
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import demo._internal.SectionFlowContent

/**
 * @author Vivien Mahe
 * @since 03/07/2025
 */

@Composable
fun ChipDemo() {
    CzanThemePreview {
        PreviewBox {
            Section(title = "Basic Chip") {
                Chip(
                    title = "Chip title",
                    leadingIconVector = null,
                    canBeDeleted = false,
                )
            }

            Section(title = "Chip with Leading Icon") {
                Chip(
                    title = "Chip title",
                    leadingIconVector = Icons.Filled.Person,
                    canBeDeleted = false
                )
            }

            Section(title = "Chip deletable") {
                Chip(
                    title = "Chip title",
                    leadingIconVector = null,
                    canBeDeleted = true,
                )
            }

            Section(title = "Chip with Leading icon & deletable") {
                SectionFlowContent {
                    Chip(
                        title = "Chip title",
                        leadingIconVector = Icons.Filled.Person,
                        canBeDeleted = true,
                    )

                    Chip(
                        title = "Chip customized",
                        leadingIconVector = Icons.Filled.Person,
                        canBeDeleted = true,
                        textStyle = MaterialTheme.typography.titleMedium,
                        colors = ChipDefaults.chipColors(
                            leadingIconBackgroundColor = Color.Gray,
                            leadingIconBorderColor = Color.Red
                        ),
                        sizes = ChipDefaults.chipSizes(
                            iconsSize = 32.dp,
                            iconBorderWidth = 1.dp,
                            iconPadding = 3.dp,
                        ),
                        contentPadding = PaddingValues(vertical = 12.dp),
                    )
                }
            }
        }
    }
}
