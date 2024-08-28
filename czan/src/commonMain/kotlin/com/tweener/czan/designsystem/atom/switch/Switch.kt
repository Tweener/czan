package com.tweener.czan.designsystem.atom.switch

/**
 * @author Vivien Mahe
 * @since 31/12/2023
 */

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveSwitch
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

/**
 * @author Vivien Mahe
 * @since 29/08/2023
 */

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun Switch(
    modifier: Modifier = Modifier,
    style: SwitchStyle = SwitchStyle.PRIMARY,
    checked: Boolean = false,
    onCheckedChange: ((Boolean) -> Unit)? = null
) {
    val iconVector = if (checked) Icons.Outlined.Check else Icons.Outlined.Close

    AdaptiveSwitch(
        modifier = modifier,
        checked = checked,
        onCheckedChange = { onCheckedChange?.invoke(it) },
        thumbContent = {
            Icon(
                modifier = Modifier.size(SwitchDefaults.IconSize),
                imageVector = iconVector,
                contentDescription = null,
            )
        },
        adaptation = {
            material {
                colors = SwitchDefaults.colors(
                    checkedThumbColor = style.checkedThumbColor,
                    uncheckedThumbColor = style.uncheckedThumbColor,
                    checkedTrackColor = style.checkedTrackColor,
                    uncheckedTrackColor = style.uncheckedTrackColor,
                    checkedIconColor = style.checkedIconColor,
                    uncheckedIconColor = style.uncheckedIconColor,
                )
            }
        },
    )
}
