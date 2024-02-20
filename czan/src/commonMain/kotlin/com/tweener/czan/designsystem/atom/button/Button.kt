package com.tweener.czan.designsystem.atom.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveButton
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

/**
 * @author Vivien Mahe
 * @since 24/08/2023
 */

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    enabled: Boolean = true,
    outlined: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    val shouldUseIconPadding = (leadingIcon != null || trailingIcon != null) && text != null

    AdaptiveButton(
        modifier = modifier.height(size.height),
        enabled = enabled,
        onClick = { onClick?.invoke() },
        adaptation = {
            material {
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (outlined) Color.Transparent else style.containerColor,
                    contentColor = if (outlined) style.containerColor else style.contentColor,
                    disabledContainerColor = style.disabledContainerColor,
                    disabledContentColor = style.disabledContentColor
                )
                shape = size.shape
                contentPadding = if (shouldUseIconPadding) size.contentWithIconPadding else size.contentPadding
            }
            cupertino { }
        },
        border = if (outlined) BorderStroke(1.dp, style.containerColor) else null
    ) {
        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null
            )

            if (text != null) {
                Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
            }
        }

        if (text != null) {
            Text(
                text = text,
                style = size.textStyle
            )
        }

        if (trailingIcon != null) {
            if (text != null) {
                Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
            }

            Icon(
                imageVector = trailingIcon,
                contentDescription = null
            )
        }
    }
}
