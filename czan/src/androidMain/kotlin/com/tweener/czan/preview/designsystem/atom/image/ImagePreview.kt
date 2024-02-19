package com.tweener.czan.preview.designsystem.atom.image

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.czan.designsystem.atom.image.Image
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import io.github.tweener.czan.generated.resources.Res
import io.github.tweener.czan.generated.resources.profile_header_background
import org.jetbrains.compose.resources.ExperimentalResourceApi

/**
 * @author Vivien Mahe
 * @since 01/01/2024
 */

@OptIn(ExperimentalResourceApi::class)
@UiModePreviews
@Composable
private fun ImageFromResourcePreview() {
    CzanThemePreview {
        Image(
            modifier = Modifier.fillMaxSize(),
            resource = Res.drawable.profile_header_background,
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
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
