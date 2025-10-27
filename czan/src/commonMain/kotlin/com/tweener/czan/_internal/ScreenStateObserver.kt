package com.tweener.czan._internal

import androidx.compose.runtime.Composable

/**
 * Observer for screen state changes (screen on/off events).
 * On Android, this listens to ACTION_SCREEN_ON and ACTION_SCREEN_OFF broadcasts.
 * On iOS, this listens to UIApplicationDidBecomeActive and UIApplicationWillResignActive notifications.
 *
 * @author Vivien Mahe
 * @since 27/10/2025
 */
interface ScreenStateObserver {
    fun observeScreenState(onScreenOn: () -> Unit, onScreenOff: () -> Unit)
    fun stopObserving()
}

@Composable
expect fun rememberScreenStateObserver(): ScreenStateObserver
