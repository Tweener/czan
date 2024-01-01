package com.tweener.czan.android.preview.designsystem.atom.image

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.designsystem.atom.image.Image
import com.tweener.czan.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@UiModePreviews
@Composable
private fun ImageFromUrlPreview() {
    CzanThemePreview {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageUrl = "https://images.pexels.com/photos/2223082/pexels-photo-2223082.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        )
    }
}
