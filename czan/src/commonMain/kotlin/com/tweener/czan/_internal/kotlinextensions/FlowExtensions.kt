package com.tweener.czan._internal.kotlinextensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

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

@Composable
expect fun <T> StateFlow<T>.collectAsStateMultiplatform(
    context: CoroutineContext = EmptyCoroutineContext,
): State<T>
