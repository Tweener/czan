package com.tweener.czan.designsystem.atom.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import com.tweener.czan._internal.kotlinextensions.conditional
import com.tweener.czan.designsystem.atom.image.Image
import com.tweener.czan.designsystem.atom.image.ImageDefaults
import com.tweener.czan.designsystem.atom.text.Text
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

/**
 * @author Vivien Mahe
 * @since 18/12/2023
 */

@Composable
fun Chip(
    title: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    colors: ChipColors = ChipDefaults.chipColors(),
    sizes: ChipSizes = ChipDefaults.chipSizes(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    contentPadding: PaddingValues = ChipDefaults.ContentPadding,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        title = title,
        selected = selected,
        colors = colors,
        sizes = sizes,
        textStyle = textStyle,
        contentPadding = contentPadding,
        canBeDeleted = canBeDeleted,
        onDismiss = onDismiss,
    )
}

@Composable
fun Chip(
    title: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    leadingIconVector: ImageVector? = null,
    colors: ChipColors = ChipDefaults.chipColors(),
    sizes: ChipSizes = ChipDefaults.chipSizes(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    contentPadding: PaddingValues = ChipDefaults.ContentPadding,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        title = title,
        selected = selected,
        colors = colors,
        sizes = sizes,
        textStyle = textStyle,
        contentPadding = contentPadding,
        canBeDeleted = canBeDeleted,
        onDismiss = onDismiss,
        leadingIcon = {
            leadingIconVector?.let {
                Image(
                    modifier = Modifier
                        .size(sizes.iconsSize())
                        .clip(CircleShape)
                        .conditional(sizes.iconBorderWidth() > 0.dp, { border(width = sizes.iconBorderWidth(), shape = CircleShape, color = colors.leadingIconBorderColor()) })
                        .background(colors.leadingIconBackgroundColor())
                        .padding(sizes.iconPadding()),
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
    selected: Boolean = false,
    leadingIconBitmap: ImageBitmap? = null,
    colors: ChipColors = ChipDefaults.chipColors(),
    sizes: ChipSizes = ChipDefaults.chipSizes(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    contentPadding: PaddingValues = ChipDefaults.ContentPadding,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        title = title,
        selected = selected,
        colors = colors,
        sizes = sizes,
        textStyle = textStyle,
        contentPadding = contentPadding,
        canBeDeleted = canBeDeleted,
        onDismiss = onDismiss,
        leadingIcon = {
            leadingIconBitmap?.let {
                Image(
                    modifier = Modifier
                        .size(sizes.iconsSize())
                        .clip(CircleShape)
                        .conditional(sizes.iconBorderWidth() > 0.dp, { border(width = sizes.iconBorderWidth(), shape = CircleShape, color = colors.leadingIconBorderColor()) })
                        .background(colors.leadingIconBackgroundColor())
                        .padding(sizes.iconPadding()),
                    bitmap = it,
                    colorFilter = ColorFilter.tint(color = colors.leadingIconColor()),
                    contentDescription = "Chip leading icon",
                )
            }
        },
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Chip(
    title: String,
    placeholderRes: DrawableResource,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    leadingIconUrl: String? = null,
    colors: ChipColors = ChipDefaults.chipColors(),
    sizes: ChipSizes = ChipDefaults.chipSizes(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    contentPadding: PaddingValues = ChipDefaults.ContentPadding,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        title = title,
        selected = selected,
        colors = colors,
        sizes = sizes,
        textStyle = textStyle,
        contentPadding = contentPadding,
        canBeDeleted = canBeDeleted,
        onDismiss = onDismiss,
        leadingIcon = {
            leadingIconUrl
                ?.let {
                    Image(
                        modifier = Modifier
                            .size(sizes.iconsSize())
                            .clip(CircleShape)
                            .conditional(sizes.iconBorderWidth() > 0.dp, { border(width = sizes.iconBorderWidth(), shape = CircleShape, color = colors.leadingIconBorderColor()) })
                            .background(colors.leadingIconBackgroundColor())
                            .padding(sizes.iconPadding()),
                        imageUrl = it,
                        placeholderRes = placeholderRes,
                        colors = ImageDefaults.imageColors(
                            shimmerBaseColor = colors.shimmerBaseColor(),
                            shimmerHighlightColor = colors.shimmerHighlightColor(),
                        ),
                        circleCrop = true,
                    )
                }
                ?: run {
                    Image(
                        modifier = Modifier
                            .size(sizes.iconsSize())
                            .clip(CircleShape)
                            .conditional(sizes.iconBorderWidth() > 0.dp, { border(width = sizes.iconBorderWidth(), shape = CircleShape, color = colors.leadingIconBorderColor()) })
                            .background(colors.leadingIconBackgroundColor())
                            .padding(sizes.iconPadding()),
                        resource = placeholderRes,
                        colorFilter = ColorFilter.tint(color = colors.leadingIconColor()),
                        contentDescription = "Chip leading icon",
                    )
                }
        },
    )
}

@Composable
private fun InputChip(
    title: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    colors: ChipColors = ChipDefaults.chipColors(),
    sizes: ChipSizes = ChipDefaults.chipSizes(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    contentPadding: PaddingValues = ChipDefaults.ContentPadding,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        onClick = { onDismiss?.invoke() },
        label = {
            Text(
                modifier = Modifier.padding(contentPadding),
                text = title,
                style = textStyle,
            )
        },
        selected = selected,
        shape = RoundedCornerShape(sizes.roundedCornerSize()),
        colors = InputChipDefaults.inputChipColors(
            containerColor = colors.containerColor(),
            selectedContainerColor = colors.selectedContainerColor(),
            disabledContainerColor = colors.disabledContainerColor(),
            labelColor = colors.labelColor(),
            disabledLabelColor = colors.disabledLabelColor(),
        ),
        border = InputChipDefaults.inputChipBorder(
            enabled = enabled,
            selected = selected,
            borderColor = colors.borderColor(),
            selectedBorderColor = colors.selectedBorderColor(),
            borderWidth = sizes.borderWidth(),
            selectedBorderWidth = sizes.selectedBorderWidth(),
        ),
        leadingIcon = { leadingIcon?.invoke() },
        trailingIcon = {
            if (canBeDeleted) {
                Icon(
                    modifier = Modifier.size(sizes.iconsSize()),
                    imageVector = Icons.Default.Close,
                    contentDescription = "Chip delete icon",
                )
            }
        },
    )
}

object ChipDefaults {

    val IconsSize = InputChipDefaults.AvatarSize

    private val ChipHorizontalPadding = 0.dp
    private val ChipVerticalPadding = 0.dp

    val ContentPadding = PaddingValues(
        horizontal = ChipHorizontalPadding,
        vertical = ChipVerticalPadding,
    )

    @Composable
    fun chipColors(
        containerColor: Color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f),
        selectedContainerColor: Color = MaterialTheme.colorScheme.primaryContainer,
        disabledContainerColor: Color = MaterialTheme.colorScheme.surface,
        labelColor: Color = MaterialTheme.colorScheme.onSurface,
        disabledLabelColor: Color = MaterialTheme.colorScheme.onSurface,
        borderColor: Color = MaterialTheme.colorScheme.outline,
        selectedBorderColor: Color = MaterialTheme.colorScheme.primary,
        leadingIconColor: Color = MaterialTheme.colorScheme.primary,
        leadingIconBackgroundColor: Color = MaterialTheme.colorScheme.background,
        leadingIconBorderColor: Color = MaterialTheme.colorScheme.primary,
        shimmerBaseColor: Color = Color.Transparent,
        shimmerHighlightColor: Color = Color.Transparent,
    ): ChipColors = ChipColors(
        containerColor = containerColor,
        selectedContainerColor = selectedContainerColor,
        disabledContainerColor = disabledContainerColor,
        labelColor = labelColor,
        disabledLabelColor = disabledLabelColor,
        borderColor = borderColor,
        selectedBorderColor = selectedBorderColor,
        leadingIconColor = leadingIconColor,
        leadingIconBackgroundColor = leadingIconBackgroundColor,
        leadingIconBorderColor = leadingIconBorderColor,
        shimmerBaseColor = shimmerBaseColor,
        shimmerHighlightColor = shimmerHighlightColor,
    )

    @Composable
    fun chipSizes(
        borderWidth: Dp = 1.dp,
        selectedBorderWidth: Dp = 1.dp,
        roundedCornerSize: Dp = 300.dp,
        iconsSize: Dp = IconsSize,
        iconBorderWidth: Dp = 0.dp,
        iconPadding: Dp = 0.dp,
    ): ChipSizes = ChipSizes(
        borderWidth = borderWidth,
        selectedBorderWidth = selectedBorderWidth,
        roundedCornerSize = roundedCornerSize,
        iconsSize = iconsSize,
        iconBorderWidth = iconBorderWidth,
        iconPadding = iconPadding,
    )
}

@Immutable
class ChipColors internal constructor(
    private val containerColor: Color,
    private val selectedContainerColor: Color,
    private val disabledContainerColor: Color,
    private val labelColor: Color,
    private val disabledLabelColor: Color,
    private val borderColor: Color,
    private val selectedBorderColor: Color,
    private val leadingIconColor: Color,
    private val leadingIconBackgroundColor: Color,
    private val leadingIconBorderColor: Color,
    private val shimmerBaseColor: Color,
    private val shimmerHighlightColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun selectedContainerColor(): Color = selectedContainerColor

    @Composable
    internal fun disabledContainerColor(): Color = disabledContainerColor

    @Composable
    internal fun labelColor(): Color = labelColor

    @Composable
    internal fun disabledLabelColor(): Color = disabledLabelColor

    @Composable
    internal fun borderColor(): Color = borderColor

    @Composable
    internal fun selectedBorderColor(): Color = selectedBorderColor

    @Composable
    internal fun leadingIconColor(): Color = leadingIconColor

    @Composable
    internal fun leadingIconBackgroundColor(): Color = leadingIconBackgroundColor

    @Composable
    internal fun leadingIconBorderColor(): Color = leadingIconBorderColor

    @Composable
    internal fun shimmerBaseColor(): Color = shimmerBaseColor

    @Composable
    internal fun shimmerHighlightColor(): Color = shimmerHighlightColor
}

@Immutable
class ChipSizes internal constructor(
    private val borderWidth: Dp,
    private val selectedBorderWidth: Dp,
    private val roundedCornerSize: Dp,
    private val iconsSize: Dp,
    private val iconBorderWidth: Dp,
    private val iconPadding: Dp,
) {
    @Composable
    internal fun borderWidth(): Dp = borderWidth

    @Composable
    internal fun selectedBorderWidth(): Dp = selectedBorderWidth

    @Composable
    internal fun roundedCornerSize(): Dp = roundedCornerSize

    @Composable
    internal fun iconsSize(): Dp = iconsSize

    @Composable
    internal fun iconBorderWidth(): Dp = iconBorderWidth

    @Composable
    internal fun iconPadding(): Dp = iconPadding
}
