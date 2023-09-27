package com.tweener.cezanne.android.component.googleads

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

/**
 * @author Vivien Mahe
 * @since 20/09/2023
 */

@Composable
fun BannerAd(
    adUnitId: String,
    modifier: Modifier = Modifier,
    adListener: AdListener? = null
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            AdView(context).apply {
                setAdSize(AdSize.BANNER)
                this.adUnitId = adUnitId
                adListener?.let { this.adListener = adListener }

                loadAd(AdRequest.Builder().build())
            }
        },
    )
}
