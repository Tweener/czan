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
import com.tweener.czan.designsystem.atom.line.HorizontalDashedLine
import com.tweener.czan.designsystem.atom.line.LineDefaults
import com.tweener.czan.designsystem.atom.line.VerticalDashedLine
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews

@UiModePreviews
@Composable
fun HorizontalDashedLinePreview() {
    CzanThemePreview {
        HorizontalDashedLine(
            modifier = Modifier.width(200.dp),
            colors = LineDefaults.lineColors(
                strokeColor = MaterialTheme.colorScheme.primary
            ),
            sizes = LineDefaults.lineSizes(
                dashOn = 10.dp,
                dashOff = 2.dp,
                thickness = 2.dp,
            ),
        )
    }
}

@UiModePreviews
@Composable
fun VerticalDashedLinePreview() {
    CzanThemePreview {
        VerticalDashedLine(
            modifier = Modifier.height(200.dp),
            colors = LineDefaults.lineColors(
                strokeColor = MaterialTheme.colorScheme.primary
            ),
            sizes = LineDefaults.lineSizes(
                dashOn = 10.dp,
                dashOff = 2.dp,
                thickness = 8.dp,
            ),
        )
    }
}
