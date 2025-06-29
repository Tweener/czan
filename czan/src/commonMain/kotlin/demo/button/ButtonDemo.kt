/**
 * @author Vivien Mahe
 * @since 15/10/2024
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.button.ButtonLoadingStyle
import com.tweener.czan.designsystem.atom.button.ButtonSize
import com.tweener.czan.designsystem.atom.button.ButtonStyle
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.theme.Size
import demo._internal.Section
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ButtonDemo(
    modifier: Modifier = Modifier,
) {
    CzanThemePreview {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(Size.Padding.Default),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(Size.Padding.Default),
            ) {
                Section(title = "Styles") {
                    Row(horizontalArrangement = Arrangement.spacedBy(Size.Padding.Default)) {
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

                    Spacer(modifier = Modifier.padding(vertical = Size.Padding.ExtraSmall))

                    Row(horizontalArrangement = Arrangement.spacedBy(Size.Padding.Default)) {
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

                    Spacer(modifier = Modifier.padding(vertical = Size.Padding.ExtraSmall))

                    Row(horizontalArrangement = Arrangement.spacedBy(Size.Padding.Default)) {
                        Button(
                            text = "Error",
                            style = ButtonStyle.ERROR,
                            size = ButtonSize.REGULAR,
                        )
                    }
                }

                Section(title = "Sizes") {
                    Row(horizontalArrangement = Arrangement.spacedBy(Size.Padding.Default)) {
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
                    Row(horizontalArrangement = Arrangement.spacedBy(Size.Padding.Default)) {
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
                    }
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
