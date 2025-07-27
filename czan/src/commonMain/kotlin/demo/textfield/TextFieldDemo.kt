package demo.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import com.tweener.czan.designsystem.atom.textfield.TextField
import com.tweener.czan.designsystem.atom.textfield.TextFieldSize
import com.tweener.czan.designsystem.atom.textfield.TextFieldType
import com.tweener.czan.preview.CzanThemePreview
import demo._internal.PreviewBox
import demo._internal.Section
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @author Vivien Mahe
 * @since 27/07/2025
 */

@Composable
fun TextFieldDemo() {
    var basicText by remember { mutableStateOf("") }
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var searchText by remember { mutableStateOf("") }
    var numberText by remember { mutableStateOf("") }
    var multilineText by remember { mutableStateOf("") }

    CzanThemePreview {
        PreviewBox {
            Section(title = "Basic Text Fields") {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = basicText,
                    label = "Basic Text Field",
                    placeholderText = "Enter text here...",
                    onValueChanged = { basicText = it }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Disabled Text Field",
                    label = "Disabled",
                    enabled = false,
                    onValueChanged = { }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Pre-filled Text Field",
                    label = "With Initial Value",
                    onValueChanged = { }
                )
            }

            Section(title = "Different Input Types") {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = emailText,
                    label = "Email Address",
                    placeholderText = "example@email.com",
                    type = TextFieldType.EMAIL,
                    imeAction = ImeAction.Next,
                    onValueChanged = { emailText = it }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = passwordText,
                    label = "Password",
                    placeholderText = "Enter your password",
                    type = TextFieldType.PASSWORD_HIDDEN,
                    imeAction = ImeAction.Done,
                    onValueChanged = { passwordText = it }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = searchText,
                    label = "Search",
                    placeholderText = "Search for items...",
                    type = TextFieldType.SEARCH,
                    imeAction = ImeAction.Search,
                    onValueChanged = { searchText = it }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = numberText,
                    label = "Phone Number",
                    placeholderText = "+1 (555) 123-4567",
                    type = TextFieldType.NUMBER,
                    imeAction = ImeAction.Done,
                    onValueChanged = { numberText = it }
                )
            }

            Section(title = "Different Sizes") {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    label = "Small Text Field",
                    placeholderText = "Small size",
                    size = TextFieldSize.SMALL,
                    onValueChanged = { }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    label = "Regular Text Field",
                    placeholderText = "Regular size",
                    size = TextFieldSize.REGULAR,
                    onValueChanged = { }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    label = "Large Text Field",
                    placeholderText = "Large size",
                    size = TextFieldSize.BIG,
                    onValueChanged = { }
                )
            }

            Section(title = "Multiline Text Field") {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = multilineText,
                    label = "Description",
                    placeholderText = "Enter a detailed description here...",
                    singleLine = false,
                    capitalization = KeyboardCapitalization.Sentences,
                    imeAction = ImeAction.Default,
                    onValueChanged = { multilineText = it }
                )
            }

            Section(title = "Capitalization Examples") {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    label = "No Capitalization",
                    placeholderText = "all lowercase",
                    capitalization = KeyboardCapitalization.None,
                    onValueChanged = { }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    label = "Word Capitalization",
                    placeholderText = "First Letter Of Each Word",
                    capitalization = KeyboardCapitalization.Words,
                    onValueChanged = { }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    label = "Sentence Capitalization",
                    placeholderText = "First letter of sentences",
                    capitalization = KeyboardCapitalization.Sentences,
                    onValueChanged = { }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    label = "All Characters",
                    placeholderText = "ALL UPPERCASE",
                    capitalization = KeyboardCapitalization.Characters,
                    onValueChanged = { }
                )
            }

            Section(title = "Without Labels") {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    placeholderText = "First name",
                    onValueChanged = { }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    placeholderText = "Last name",
                    onValueChanged = { }
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    placeholderText = "Company (optional)",
                    onValueChanged = { }
                )
            }
        }
    }
}

@Preview
@Composable
private fun TextFieldDemoPreview() {
    CzanThemePreview {
        TextFieldDemo()
    }
}