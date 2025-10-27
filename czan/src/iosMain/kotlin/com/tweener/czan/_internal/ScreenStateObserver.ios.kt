package com.tweener.czan._internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import platform.Foundation.NSNotificationCenter
import platform.UIKit.UIApplicationDidBecomeActiveNotification
import platform.UIKit.UIApplicationWillResignActiveNotification
import platform.darwin.NSObjectProtocol

/**
 * iOS implementation of ScreenStateObserver.
 * Listens to UIApplicationDidBecomeActive and UIApplicationWillResignActive notifications.
 *
 * @author Vivien Mahe
 * @since 27/10/2025
 */
class IosScreenStateObserver : ScreenStateObserver {

    private var activeObserver: NSObjectProtocol? = null
    private var resignObserver: NSObjectProtocol? = null

    override fun observeScreenState(onScreenOn: () -> Unit, onScreenOff: () -> Unit) {
        val notificationCenter = NSNotificationCenter.defaultCenter

        activeObserver = notificationCenter.addObserverForName(
            name = UIApplicationDidBecomeActiveNotification,
            `object` = null,
            queue = null
        ) { _ -> onScreenOn() }

        resignObserver = notificationCenter.addObserverForName(
            name = UIApplicationWillResignActiveNotification,
            `object` = null,
            queue = null
        ) { _ -> onScreenOff() }
    }

    override fun stopObserving() {
        val notificationCenter = NSNotificationCenter.defaultCenter
        activeObserver?.let { notificationCenter.removeObserver(it) }
        resignObserver?.let { notificationCenter.removeObserver(it) }
        activeObserver = null
        resignObserver = null
    }
}

@Composable
actual fun rememberScreenStateObserver(): ScreenStateObserver = remember { IosScreenStateObserver() }
