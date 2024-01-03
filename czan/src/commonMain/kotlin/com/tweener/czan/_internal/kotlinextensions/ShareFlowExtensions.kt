package com.tweener.czan._internal.kotlinextensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.SharedFlow

/**
 * @author Vivien Mahe
 * @since 26/08/2023
 */

@Composable
inline fun <T> SharedFlow<T>.subscribe(crossinline action: (T) -> Unit) {
    with(this) {
        LaunchedEffect(this) {
            this@with.collect { action.invoke(it) }
        }
    }
}
