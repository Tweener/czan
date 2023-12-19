package com.tweener.czan.android.designsystem.atom.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.android.designsystem.atom.text.Text
import com.tweener.czan.android.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 18/12/2023
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(
    title: String,
    modifier: Modifier = Modifier,
    colors: ChipColors = ChipDefaults.chipColors(),
    size: Dp = ChipDefaults.Size,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        onClick = { onDismiss?.invoke() },
        label = {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        selected = false,
        shape = MaterialTheme.shapes.extraLarge,
        colors = InputChipDefaults.inputChipColors(
            containerColor = colors.containerColor(),
            disabledContainerColor = colors.disabledContainerColor(),
            labelColor = colors.labelColor()
        ),
        border = InputChipDefaults.inputChipBorder(
            borderColor = colors.borderColor(),
            borderWidth = 1.dp
        ),
        avatar = {
            Icon(
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape)
                    .background(colors.leadingIconBackgroundColor()),
                imageVector = Icons.Filled.Person,
                tint = colors.leadingIconColor(),
                contentDescription = "Localized description",
            )
        },
        trailingIcon = {
            if (canBeDeleted) {
                Icon(
                    modifier = Modifier.size(size),
                    imageVector = Icons.Default.Close,
                    contentDescription = "Localized description",
                )
            }
        },
    )
}

object ChipDefaults {

    @OptIn(ExperimentalMaterial3Api::class)
    val Size = InputChipDefaults.AvatarSize

    @Composable
    fun chipColors(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        disabledContainerColor: Color = MaterialTheme.colorScheme.surface,
        labelColor: Color = MaterialTheme.colorScheme.onSurface,
        borderColor: Color = MaterialTheme.colorScheme.outline,
        leadingIconColor: Color = MaterialTheme.colorScheme.primary,
        leadingIconBackgroundColor: Color = MaterialTheme.colorScheme.background
    ): ChipColors = ChipColors(
        containerColor = containerColor,
        disabledContainerColor = disabledContainerColor,
        labelColor = labelColor,
        borderColor = borderColor,
        leadingIconColor = leadingIconColor,
        leadingIconBackgroundColor = leadingIconBackgroundColor,
    )
}

@Immutable
class ChipColors internal constructor(
    private val containerColor: Color,
    private val disabledContainerColor: Color,
    private val labelColor: Color,
    private val borderColor: Color,
    private val leadingIconColor: Color,
    private val leadingIconBackgroundColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun disabledContainerColor(): Color = disabledContainerColor

    @Composable
    internal fun labelColor(): Color = labelColor

    @Composable
    internal fun borderColor(): Color = borderColor

    @Composable
    internal fun leadingIconColor(): Color = leadingIconColor

    @Composable
    internal fun leadingIconBackgroundColor(): Color = leadingIconBackgroundColor
}

@PreviewLightDark
@Composable
private fun ChipPreview() {
    CzanThemePreview {
        Chip(
            title = "Chip title",
            canBeDeleted = true
        )
    }
}
