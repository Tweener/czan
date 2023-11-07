package com.tweener.cezanne.android.component.searchinput

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tweener.cezanne.android.component.textfield.TextField
import com.tweener.cezanne.android.component.textfield.TextFieldType
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.theme.CezanneTheme

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

@UiModePreviews
@Composable
private fun SearchInputPreview() {
    CezanneTheme {
        SearchInput(
            placeholderText = "Search mood or category"
        )
    }
}
