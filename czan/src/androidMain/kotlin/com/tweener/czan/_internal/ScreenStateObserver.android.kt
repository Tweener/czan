package com.tweener.czan._internal

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import kotlin.apply
import kotlin.let

/**
 * Android implementation of ScreenStateObserver.
 * Listens to ACTION_SCREEN_ON and ACTION_SCREEN_OFF broadcasts.
 *
 * @author Vivien Mahe
 * @since 27/10/2025
 */
class AndroidScreenStateObserver(private val context: Context) : ScreenStateObserver {

    private var receiver: BroadcastReceiver? = null

    override fun observeScreenState(onScreenOn: () -> Unit, onScreenOff: () -> Unit) {
        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when (intent?.action) {
                    Intent.ACTION_SCREEN_ON -> onScreenOn()
                    Intent.ACTION_SCREEN_OFF -> onScreenOff()
                }
            }
        }

        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_SCREEN_OFF)
        }

        ContextCompat.registerReceiver(
            context,
            receiver,
            filter,
            ContextCompat.RECEIVER_NOT_EXPORTED
        )
    }

    override fun stopObserving() {
        receiver?.let { context.unregisterReceiver(it) }
        receiver = null
    }
}

@Composable
actual fun rememberScreenStateObserver(): ScreenStateObserver {
    val context = LocalContext.current
    return remember { AndroidScreenStateObserver(context) }
}
