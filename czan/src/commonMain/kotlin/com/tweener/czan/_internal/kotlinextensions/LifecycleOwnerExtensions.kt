package com.tweener.czan._internal.kotlinextensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.tweener.czan._internal.rememberScreenStateObserver
import com.tweener.kmpkit.kotlinextensions.now
import com.tweener.kmpkit.kotlinextensions.toEpochMilliseconds
import kotlinx.datetime.LocalDateTime

/**
 * @author Vivien Mahe
 * @since 21/01/2025
 */

/**
 * Observes lifecycle events within a Composable and executes corresponding callbacks when events occur.
 *
 * This function provides a way to listen to lifecycle changes inside a Composable,
 * similar to `LifecycleObserver`, and is useful for managing UI state and resources.
 *
 * ### Example Usage:
 * ```
 * @Composable
 * fun MyScreen() {
 *     OnLifecycleEvents(
 *         onResume = { println("Screen resumed!") },
 *         onPause = { println("Screen paused!") }
 *     )
 * }
 * ```
 *
 * @param onCreate Callback invoked when the lifecycle event `ON_CREATE` occurs.
 * @param onStart Callback invoked when the lifecycle event `ON_START` occurs.
 * @param onResume Callback invoked when the lifecycle event `ON_RESUME` occurs.
 * @param onPause Callback invoked when the lifecycle event `ON_PAUSE` occurs.
 * @param onStop Callback invoked when the lifecycle event `ON_STOP` occurs.
 * @param onDestroy Callback invoked when the lifecycle event `ON_DESTROY` occurs.
 * @param onAny Callback invoked when any lifecycle event occurs.
 */
@Composable
fun OnLifecycleEvents(
    onCreate: (() -> Unit)? = null,
    onStart: (() -> Unit)? = null,
    onResume: (() -> Unit)? = null,
    onPause: (() -> Unit)? = null,
    onStop: (() -> Unit)? = null,
    onDestroy: (() -> Unit)? = null,
    onAny: (() -> Unit)? = null
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> onCreate?.invoke()
                Lifecycle.Event.ON_START -> onStart?.invoke()
                Lifecycle.Event.ON_RESUME -> onResume?.invoke()
                Lifecycle.Event.ON_PAUSE -> onPause?.invoke()
                Lifecycle.Event.ON_STOP -> onStop?.invoke()
                Lifecycle.Event.ON_DESTROY -> onDestroy?.invoke()
                Lifecycle.Event.ON_ANY -> onAny?.invoke()
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }
}


/**
 * Observes app visibility changes, combining both lifecycle events and screen state changes.
 * This handles two scenarios:
 * 1. App goes to background and returns (lifecycle events)
 * 2. Screen locks/unlocks while app is in foreground (screen state events)
 *
 * The callbacks are debounced to prevent duplicate calls when both events fire in quick succession.
 *
 * Note: This does NOT detect navigation between screens within your app (e.g., HomeScreen → MontageScreen).
 * It only detects when the app becomes visible/invisible to the user at the system level.
 *
 * @param onAppForegrounded Callback invoked when the app becomes visible to the user (foreground or screen unlock)
 * @param onAppBackgrounded Callback invoked when the app becomes invisible to the user (background or screen lock) (optional)
 */
@Composable
fun ObserveAppVisibility(
    onAppForegrounded: () -> Unit,
    onAppBackgrounded: (() -> Unit)? = null,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val screenStateObserver = rememberScreenStateObserver()
    val debounceDelayMs = 500L // Debounce: only trigger if more than 500ms since last call. This prevents duplicate calls when both lifecycle and screen state events fire

    DisposableEffect(lifecycleOwner) {
        var isInForeground = lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)
        var lastForegroundedTimestamp = 0L
        var lastBackgroundedTimestamp = 0L

        fun triggerForegrounded() {
            val now = LocalDateTime.now().toEpochMilliseconds()

            if (now - lastForegroundedTimestamp > debounceDelayMs) {
                lastForegroundedTimestamp = now
                onAppForegrounded()
            }
        }

        fun triggerBackgrounded() {
            onAppBackgrounded?.let {
                val now = LocalDateTime.now().toEpochMilliseconds()

                if (now - lastBackgroundedTimestamp > debounceDelayMs) {
                    lastBackgroundedTimestamp = now
                    it()
                }
            }
        }

        val lifecycleObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    isInForeground = true
                    triggerForegrounded()
                }

                Lifecycle.Event.ON_PAUSE -> {
                    isInForeground = false
                    triggerBackgrounded()
                }

                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)

        screenStateObserver.observeScreenState(
            onScreenOn = {
                // Only trigger if app is already in foreground (screen unlock scenario)
                if (isInForeground) {
                    triggerForegrounded()
                }
            },
            onScreenOff = {
                // Only trigger if app is in foreground (screen lock scenario)
                if (isInForeground) {
                    triggerBackgrounded()
                }
            }
        )

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
            screenStateObserver.stopObserving()
        }
    }
}
