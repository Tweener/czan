package com.tweener.czan._internal.kotlinextensions

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.core.graphics.toColorInt

/**
 * @author Vivien Mahe
 * @since 02/09/2023
 */

val String.toColor
    get() = Color("#$this".toColorInt())

val Color.toHex
    get() = run {
        val red = Integer.toHexString(this.toArgb().red).toStringComponent()
        val green = Integer.toHexString(this.toArgb().green).toStringComponent()
        val blue = Integer.toHexString(this.toArgb().blue).toStringComponent()

        "$red$green$blue"
    }

private fun String.toStringComponent() =
    this.let { if (it.length == 1) "0${it}" else it }
