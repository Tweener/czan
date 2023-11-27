package com.tweener.czan.android.system

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorInt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

/**
 * Sets the color and icons color for the system bars: the status bar and navigation bar.
 *
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@Composable
fun SystemBarsSystemUI(
    themeType: ThemeType,
    activity: ComponentActivity,
    @ColorInt lightScrim: Int,
    @ColorInt darkScrim: Int,
) {
    val useDarkTheme = shouldUseDarkTheme(themeType = themeType)

    DisposableEffect(themeType) {
        activity.enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = android.graphics.Color.TRANSPARENT,
                darkScrim = android.graphics.Color.TRANSPARENT,
                detectDarkMode = { useDarkTheme }
            ),
            navigationBarStyle = SystemBarStyle.auto(
                lightScrim = lightScrim,
                darkScrim = darkScrim,
                detectDarkMode = { useDarkTheme }
            )
        )
        onDispose {}
    }
}
