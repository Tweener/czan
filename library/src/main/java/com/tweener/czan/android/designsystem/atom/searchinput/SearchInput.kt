package com.tweener.czan.android.designsystem.atom.searchinput

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.tweener.czan.android.designsystem.atom.textfield.TextField
import com.tweener.czan.android.designsystem.atom.textfield.TextFieldType
import com.tweener.czan.android.theme.CzanTheme

/**
 * @author Vivien Mahe
 * @since 07/11/2023
 */

@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    placeholderText: String? = null,
    onQueryChanged: ((String) -> Unit)? = null,
) {
    var query by remember { mutableStateOf("") }

    TextField(
        modifier = modifier.fillMaxWidth(),
        text = query,
        placeholderText = placeholderText,
        type = TextFieldType.SEARCH,
        singleLine = true,
        onValueChanged = {
            query = it
            onQueryChanged?.invoke(it)
        }
    )
}

@PreviewLightDark
@Composable
private fun SearchInputPreview() {
    CzanTheme {
        SearchInput(
            placeholderText = "Search mood or category"
        )
    }
}
