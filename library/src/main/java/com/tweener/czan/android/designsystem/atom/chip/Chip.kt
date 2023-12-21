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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.android.designsystem.atom.image.Image
import com.tweener.czan.android.designsystem.atom.text.Text
import com.tweener.czan.android.preview.CzanThemePreview
import com.tweener.czan.android.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 18/12/2023
 */

@Composable
fun Chip(
    title: String,
    modifier: Modifier = Modifier,
    leadingIconVector: ImageVector? = null,
    colors: ChipColors = ChipDefaults.chipColors(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    size: Dp = ChipDefaults.Size,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        title = title,
        colors = colors,
        textStyle = textStyle,
        size = size,
        canBeDeleted = canBeDeleted,
        onDismiss = onDismiss,
        leadingIcon = {
            leadingIconVector?.let {
                Image(
                    modifier = Modifier
                        .size(size)
                        .clip(CircleShape)
                        .background(colors.leadingIconBackgroundColor()),
                    imageVector = it,
                    colorFilter = ColorFilter.tint(color = colors.leadingIconColor()),
                    contentDescription = "Chip leading icon",
                )
            }
        },
    )
}

@Composable
fun Chip(
    title: String,
    modifier: Modifier = Modifier,
    leadingIconBitmap: ImageBitmap? = null,
    colors: ChipColors = ChipDefaults.chipColors(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    size: Dp = ChipDefaults.Size,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        title = title,
        colors = colors,
        textStyle = textStyle,
        size = size,
        canBeDeleted = canBeDeleted,
        onDismiss = onDismiss,
        leadingIcon = {
            leadingIconBitmap?.let {
                Image(
                    modifier = Modifier
                        .size(size)
                        .clip(CircleShape)
                        .background(colors.leadingIconBackgroundColor()),
                    bitmap = it,
                    colorFilter = ColorFilter.tint(color = colors.leadingIconColor()),
                    contentDescription = "Chip leading icon",
                )
            }
        },
    )
}

@Composable
fun Chip(
    title: String,
    modifier: Modifier = Modifier,
    leadingIconUrl: String? = null,
    colors: ChipColors = ChipDefaults.chipColors(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    size: Dp = ChipDefaults.Size,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        title = title,
        colors = colors,
        textStyle = textStyle,
        size = size,
        canBeDeleted = canBeDeleted,
        onDismiss = onDismiss,
        leadingIcon = {
            leadingIconUrl?.let {
                Image(
                    modifier = Modifier
                        .size(size)
                        .clip(CircleShape)
                        .background(colors.leadingIconBackgroundColor()),
                    imageUrl = it,
                )
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputChip(
    title: String,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    colors: ChipColors = ChipDefaults.chipColors(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
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
                style = textStyle,
            )
        },
        selected = false,
        shape = MaterialTheme.shapes.extraLarge,
        colors = InputChipDefaults.inputChipColors(
            containerColor = colors.containerColor(),
            disabledContainerColor = colors.disabledContainerColor(),
            labelColor = colors.labelColor(),
            disabledLabelColor = colors.disabledLabelColor(),
        ),
        border = InputChipDefaults.inputChipBorder(
            borderColor = colors.borderColor(),
            borderWidth = 1.dp
        ),
        leadingIcon = { leadingIcon?.invoke() },
        trailingIcon = {
            if (canBeDeleted) {
                Icon(
                    modifier = Modifier.size(size),
                    imageVector = Icons.Default.Close,
                    contentDescription = "Chip delete icon",
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
        disabledLabelColor: Color = MaterialTheme.colorScheme.onSurface,
        borderColor: Color = MaterialTheme.colorScheme.outline,
        leadingIconColor: Color = MaterialTheme.colorScheme.primary,
        leadingIconBackgroundColor: Color = MaterialTheme.colorScheme.background
    ): ChipColors = ChipColors(
        containerColor = containerColor,
        disabledContainerColor = disabledContainerColor,
        labelColor = labelColor,
        disabledLabelColor = disabledLabelColor,
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
    private val disabledLabelColor: Color,
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
    internal fun disabledLabelColor(): Color = disabledLabelColor

    @Composable
    internal fun borderColor(): Color = borderColor

    @Composable
    internal fun leadingIconColor(): Color = leadingIconColor

    @Composable
    internal fun leadingIconBackgroundColor(): Color = leadingIconBackgroundColor
}

@UiModePreviews
@Composable
private fun ChipNoLeadingIconAndNotDeletablePreview() {
    CzanThemePreview {
        Chip(
            title = "Chip title",
            leadingIconVector = null,
            canBeDeleted = false
        )
    }
}

@UiModePreviews
@Composable
private fun ChipLeadingIconAndNotDeletablePreview() {
    CzanThemePreview {
        Chip(
            title = "Chip title",
            leadingIconVector = Icons.Filled.Person,
            canBeDeleted = false
        )
    }
}

@UiModePreviews
@Composable
private fun ChipNoLeadingIconAndDeletablePreview() {
    CzanThemePreview {
        Chip(
            title = "Chip title",
            leadingIconVector = null,
            canBeDeleted = true
        )
    }
}

@UiModePreviews
@Composable
private fun ChipLeadingIconAndDeletablePreview() {
    CzanThemePreview {
        Chip(
            title = "Chip title",
            leadingIconVector = Icons.Filled.Person,
            canBeDeleted = true,
            textStyle = MaterialTheme.typography.bodyLarge
        )
    }
}
