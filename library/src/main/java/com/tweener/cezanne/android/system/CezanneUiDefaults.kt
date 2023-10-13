package com.tweener.cezanne.android.system

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * @author Vivien Mahe
 * @since 26/09/2023
 */

object CezanneUiDefaults {

    fun uiDisabledAlpha(): Float = 0.38f

    object TopBar {

        val backgroundColor: Color @Composable get() = MaterialTheme.colorScheme.primary

        val contentColor: Color @Composable get() = MaterialTheme.colorScheme.onPrimary
    }

    object ProgressBar {

        val color: Color @Composable get() = MaterialTheme.colorScheme.primaryContainer

        val selectedColor: Color @Composable get() = MaterialTheme.colorScheme.primary
    }
}
