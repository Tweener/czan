package com.tweener.czan.preview.designsystem.atom.line

/**
 * @author Vivien Mahe
 * @since 24/10/2024
 */

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.line.DashedLine
import com.tweener.czan.designsystem.atom.line.LineDefaults
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

@UiModePreviews
@Composable
fun DashedLinePreview() {
    CzanThemePreview {
        DashedLine(
            modifier = Modifier
                .width(200.dp)
                .height(10.dp),
            colors = LineDefaults.lineColors(
                strokeColor = MaterialTheme.colorScheme.primary
            ),
            sizes = LineDefaults.lineSizes(
                dashOn = 10.dp,
                dashOff = 2.dp,
                strokeWidth = 4.dp,
            ),
        )
    }
}
