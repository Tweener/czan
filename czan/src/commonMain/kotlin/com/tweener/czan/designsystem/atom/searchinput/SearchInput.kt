package com.tweener.czan.designsystem.atom.searchinput

/**
 * @author Vivien Mahe
 * @since 31/12/2023
 */

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tweener.czan.designsystem.atom.textfield.TextField
import com.tweener.czan.designsystem.atom.textfield.TextFieldType

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
