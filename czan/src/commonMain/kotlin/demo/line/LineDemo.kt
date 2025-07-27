package demo.line

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.line.HorizontalDashedLine
import com.tweener.czan.designsystem.atom.line.LineDefaults
import com.tweener.czan.designsystem.atom.line.VerticalDashedLine
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
fun LineDemo() {
    CzanThemePreview {
        PreviewBox {
            Section(title = "Horizontal Dashed Lines") {
                HorizontalDashedLine(
                    modifier = Modifier.fillMaxWidth()
                )

                HorizontalDashedLine(
                    modifier = Modifier.fillMaxWidth(),
                    colors = LineDefaults.lineColors(
                        strokeColor = MaterialTheme.colorScheme.secondary
                    )
                )

                HorizontalDashedLine(
                    modifier = Modifier.fillMaxWidth(),
                    colors = LineDefaults.lineColors(
                        strokeColor = Color.Red
                    ),
                    sizes = LineDefaults.lineSizes(
                        thickness = 2.dp
                    )
                )

                HorizontalDashedLine(
                    modifier = Modifier.fillMaxWidth(),
                    colors = LineDefaults.lineColors(
                        strokeColor = MaterialTheme.colorScheme.tertiary
                    ),
                    sizes = LineDefaults.lineSizes(
                        dashOn = 8.dp,
                        dashOff = 8.dp,
                        thickness = 3.dp
                    )
                )

                HorizontalDashedLine(
                    modifier = Modifier.fillMaxWidth(),
                    colors = LineDefaults.lineColors(
                        strokeColor = Color.Blue
                    ),
                    sizes = LineDefaults.lineSizes(
                        dashOn = 12.dp,
                        dashOff = 4.dp,
                        thickness = 1.dp
                    )
                )
            }

            Section(title = "Vertical Dashed Lines") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Left Content"
                    )

                    VerticalDashedLine(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        colors = LineDefaults.lineColors(
                            strokeColor = MaterialTheme.colorScheme.primary
                        )
                    )

                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Middle Content"
                    )

                    VerticalDashedLine(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        colors = LineDefaults.lineColors(
                            strokeColor = MaterialTheme.colorScheme.secondary
                        ),
                        sizes = LineDefaults.lineSizes(
                            thickness = 2.dp
                        )
                    )

                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Right Content"
                    )
                }
            }

            Section(title = "Custom Dash Patterns") {
                HorizontalDashedLine(
                    modifier = Modifier.fillMaxWidth(),
                    colors = LineDefaults.lineColors(
                        strokeColor = MaterialTheme.colorScheme.error
                    ),
                    sizes = LineDefaults.lineSizes(
                        dashOn = 2.dp,
                        dashOff = 2.dp,
                        thickness = 1.dp
                    )
                )

                HorizontalDashedLine(
                    modifier = Modifier.fillMaxWidth(),
                    colors = LineDefaults.lineColors(
                        strokeColor = Color.Green
                    ),
                    sizes = LineDefaults.lineSizes(
                        dashOn = 16.dp,
                        dashOff = 8.dp,
                        thickness = 4.dp
                    )
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    VerticalDashedLine(
                        modifier = Modifier.width(50.dp),
                        colors = LineDefaults.lineColors(
                            strokeColor = Color.Magenta
                        ),
                        sizes = LineDefaults.lineSizes(
                            dashOn = 6.dp,
                            dashOff = 3.dp,
                            thickness = 3.dp
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun LineDemoPreview() {
    CzanThemePreview {
        LineDemo()
    }
}