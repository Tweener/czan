package com.tweener.czan._internal.kotlinextensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

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
 * fun MyScreen(lifecycleOwner: LifecycleOwner) {
 *     lifecycleOwner.onLifecycleEvents(
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
fun LifecycleOwner.onLifecycleEvents(
    onCreate: (() -> Unit)? = null,
    onStart: (() -> Unit)? = null,
    onResume: (() -> Unit)? = null,
    onPause: (() -> Unit)? = null,
    onStop: (() -> Unit)? = null,
    onDestroy: (() -> Unit)? = null,
    onAny: (() -> Unit)? = null
) {
    DisposableEffect(this) {
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

        lifecycle.addObserver(observer)
        onDispose { lifecycle.removeObserver(observer) }
    }
}
