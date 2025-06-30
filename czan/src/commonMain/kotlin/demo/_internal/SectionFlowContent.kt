package demo._internal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 30/06/2025
 */

@Composable
internal fun SectionFlowContent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Size.Padding.Default),
        verticalArrangement = Arrangement.spacedBy(Size.Padding.ExtraSmall),
    ) {
        content()
    }
}
