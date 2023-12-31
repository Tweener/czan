package com.tweener.czan._internal.kotlinextensions

import androidx.compose.ui.Modifier

/**
 * @author Vivien Mahe
 * @since 31/12/2023
 */

inline fun Modifier.conditional(
    condition: Boolean,
    ifTrue: Modifier.() -> Modifier,
    ifFalse: Modifier.() -> Modifier = { this },
): Modifier =
    if (condition) {
        then(ifTrue(Modifier))
    } else {
        then(ifFalse(Modifier))
    }
