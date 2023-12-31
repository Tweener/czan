package com.tweener.czan.android.designsystem.atom.switch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.tweener.czan.android.designsystem.atom.text.Text
import com.tweener.czan.android.preview.CzanThemePreview
import com.tweener.czan.android.theme.Size

/**
 * @author Vivien Mahe
 * @since 26/08/2023
 */

@Composable
fun SwitchWithText(
    text: String,
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    onCheckedChange: ((Boolean) -> Unit)? = null
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.padding(horizontal = Size.Padding.Default))

        Switch(
            isChecked = isChecked,
            onCheckedChange = { onCheckedChange?.invoke(it) },
        )
    }
}

@PreviewLightDark
@Composable
private fun SwitchWithTextCheckedPreview() {
    CzanThemePreview {
        SwitchWithText(text = "Switch checked with text", isChecked = true)
    }
}

@PreviewLightDark
@Composable
private fun SwitchWithTextNotCheckedPreview() {
    CzanThemePreview {
        SwitchWithText(text = "Switch not checked with text", isChecked = false)
    }
}
