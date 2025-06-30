/**
 * @author Vivien Mahe
 * @since 15/10/2024
 */

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.button.ButtonLoadingStyle
import com.tweener.czan.designsystem.atom.button.ButtonSize
import com.tweener.czan.designsystem.atom.button.ButtonStyle
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.theme.Size
import demo._internal.PreviewBox
import demo._internal.Section
import demo._internal.SectionFlowContent
import io.github.tweener.czan.generated.resources.Res
import io.github.tweener.czan.generated.resources.chevron_left
import io.github.tweener.czan.generated.resources.chevron_right
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ButtonDemo(
    modifier: Modifier = Modifier,
) {
    CzanThemePreview {
        PreviewBox(modifier = modifier) {
            Section(title = "Styles") {
                SectionFlowContent {
                    Button(
                        text = "Primary",
                        style = ButtonStyle.PRIMARY,
                        size = ButtonSize.REGULAR,
                    )

                    Button(
                        text = "Secondary",
                        style = ButtonStyle.SECONDARY,
                        size = ButtonSize.REGULAR,
                    )

                    Button(
                        text = "Tertiary",
                        style = ButtonStyle.TERTIARY,
                        size = ButtonSize.REGULAR,
                    )
                }

                Spacer(modifier = Modifier.padding(vertical = Size.Padding.Small))

                SectionFlowContent {
                    Button(
                        text = "On Primary",
                        style = ButtonStyle.ON_PRIMARY,
                        size = ButtonSize.REGULAR,
                    )

                    Button(
                        text = "On Secondary",
                        style = ButtonStyle.ON_SECONDARY,
                        size = ButtonSize.REGULAR,
                    )

                    Button(
                        text = "On Tertiary",
                        style = ButtonStyle.ON_TERTIARY,
                        size = ButtonSize.REGULAR,
                    )
                }

                Spacer(modifier = Modifier.padding(vertical = Size.Padding.Small))

                SectionFlowContent {
                    Button(
                        text = "Error",
                        style = ButtonStyle.ERROR,
                        size = ButtonSize.REGULAR,
                    )
                }
            }

            Section(title = "Sizes") {
                SectionFlowContent {
                    Button(
                        text = "Small",
                        style = ButtonStyle.PRIMARY,
                        size = ButtonSize.SMALL,
                    )

                    Button(
                        text = "Regular",
                        style = ButtonStyle.PRIMARY,
                        size = ButtonSize.REGULAR,
                    )

                    Button(
                        text = "Big",
                        style = ButtonStyle.PRIMARY,
                        size = ButtonSize.BIG,
                    )
                }
            }

            Section(title = "States") {
                SectionFlowContent {
                    Button(
                        text = "Enabled",
                        enabled = true,
                        style = ButtonStyle.PRIMARY,
                        size = ButtonSize.REGULAR,
                    )

                    Button(
                        text = "Disabled",
                        enabled = false,
                        style = ButtonStyle.PRIMARY,
                        size = ButtonSize.REGULAR,
                    )

                    Button(
                        text = "Outlined",
                        enabled = true,
                        outlined = true,
                        style = ButtonStyle.PRIMARY,
                        size = ButtonSize.REGULAR,
                        loadingStyle = ButtonLoadingStyle.BOUNCE,
                    )

                    Button(
                        text = "Loading",
                        enabled = true,
                        loading = true,
                        style = ButtonStyle.PRIMARY,
                        size = ButtonSize.REGULAR,
                        loadingStyle = ButtonLoadingStyle.FADE,
                    )
                }
            }

            Section(title = "Icons") {
                SectionFlowContent {
                    Button(
                        text = "Leading Icon",
                        leadingIcon = Res.drawable.chevron_left,
                    )

                    Button(
                        text = "Trailing Icon",
                        trailingIcon = Res.drawable.chevron_right,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ButtonDemoPreview() {
    CzanThemePreview {
        ButtonDemo()
    }
}
