package com.tweener.czan._internal.kotlinextensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.SharedFlow

/**
 * @author Vivien Mahe
 * @since 26/08/2023
 */

@Composable
inline fun <T> SharedFlow<T>.subscribe(crossinline action: (T) -> Unit) {
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(this) {
        lifecycleOwner.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            this@subscribe.collect { action(it) }
        }
    }
}
