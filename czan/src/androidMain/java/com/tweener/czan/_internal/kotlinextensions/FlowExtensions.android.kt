package com.tweener.czan._internal.kotlinextensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.StateFlow

/**
 * @author Vivien Mahe
 * @since 03/01/2024
 */

@Composable
actual fun <T> StateFlow<T>.collectAsStateMultiplatform(
    context: CoroutineContext,
): State<T> = collectAsStateWithLifecycle(context = context)
