package com.tweener.czan.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Multi-preview annotation that represents light and dark UI modes. Add this annotation to a composable to render both light and dark UI modes.
 *
 * @author Vivien Mahe
 * @since 23/08/2023
 */
@Preview(name = "Light mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, backgroundColor = 0xFFFFFF)
@Preview(name = "Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 0x000000)
annotation class UiModePreviews
