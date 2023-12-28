package com.tweener.czan.android.designsystem.atom.chip

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
import com.tweener.czan.android.designsystem.atom.image.ImageDefaults
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
    sizes: ChipSizes = ChipDefaults.chipSizes(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    contentPadding: PaddingValues = ChipDefaults.ContentPadding,
    canBeDeleted: Boolean = false,
    onDismiss: (() -> Unit)? = null,
) {
    InputChip(
        modifier = modifier,
        title = title,
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
    @DrawableRes placeholder: Int = 0,
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
        colors = colors,
        sizes = sizes,
        textStyle = textStyle,
        contentPadding = contentPadding,
        canBeDeleted = canBeDeleted,
        onDismiss = onDismiss,
        leadingIcon = {
            leadingIconUrl?.let {
                Image(
                    modifier = Modifier
                        .size(sizes.iconsSize())
                        .clip(CircleShape)
                        .background(colors.leadingIconBackgroundColor()),
                    imageUrl = it,
                    placeholder = placeholder,
                    colors = ImageDefaults.imageColors(
                        shimmerBaseColor = colors.shimmerBaseColor(),
                        shimmerHighlightColor = colors.shimmerHighlightColor(),
                    ),
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
        selected = false,
        shape = RoundedCornerShape(sizes.roundedCornerSize()),
        colors = InputChipDefaults.inputChipColors(
            containerColor = colors.containerColor(),
            disabledContainerColor = colors.disabledContainerColor(),
            labelColor = colors.labelColor(),
            disabledLabelColor = colors.disabledLabelColor(),
        ),
        border = InputChipDefaults.inputChipBorder(
            borderColor = colors.borderColor(),
            borderWidth = sizes.borderWidth()
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

    @OptIn(ExperimentalMaterial3Api::class)
    val IconsSize = InputChipDefaults.AvatarSize

    private val ChipHorizontalPadding = 0.dp
    private val ChipVerticalPadding = 0.dp

    val ContentPadding = PaddingValues(
        horizontal = ChipHorizontalPadding,
        vertical = ChipVerticalPadding,
    )

    @Composable
    fun chipColors(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        disabledContainerColor: Color = MaterialTheme.colorScheme.surface,
        labelColor: Color = MaterialTheme.colorScheme.onSurface,
        disabledLabelColor: Color = MaterialTheme.colorScheme.onSurface,
        borderColor: Color = MaterialTheme.colorScheme.outline,
        leadingIconColor: Color = MaterialTheme.colorScheme.primary,
        leadingIconBackgroundColor: Color = MaterialTheme.colorScheme.background,
        shimmerBaseColor: Color = Color.Transparent,
        shimmerHighlightColor: Color = Color.Transparent,
    ): ChipColors = ChipColors(
        containerColor = containerColor,
        disabledContainerColor = disabledContainerColor,
        labelColor = labelColor,
        disabledLabelColor = disabledLabelColor,
        borderColor = borderColor,
        leadingIconColor = leadingIconColor,
        leadingIconBackgroundColor = leadingIconBackgroundColor,
        shimmerBaseColor = shimmerBaseColor,
        shimmerHighlightColor = shimmerHighlightColor,
    )

    @Composable
    fun chipSizes(
        borderWidth: Dp = 1.dp,
        roundedCornerSize: Dp = 300.dp,
        iconsSize: Dp = IconsSize,
    ): ChipSizes = ChipSizes(
        borderWidth = borderWidth,
        roundedCornerSize = roundedCornerSize,
        iconsSize = iconsSize,
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
    private val shimmerBaseColor: Color,
    private val shimmerHighlightColor: Color,
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

    @Composable
    internal fun shimmerBaseColor(): Color = shimmerBaseColor

    @Composable
    internal fun shimmerHighlightColor(): Color = shimmerHighlightColor
}

@Immutable
class ChipSizes internal constructor(
    private val borderWidth: Dp,
    private val roundedCornerSize: Dp,
    private val iconsSize: Dp,
) {
    @Composable
    internal fun borderWidth(): Dp = borderWidth

    @Composable
    internal fun roundedCornerSize(): Dp = roundedCornerSize

    @Composable
    internal fun iconsSize(): Dp = iconsSize
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
            leadingIconVector = Icons.Filled.AccountCircle,
            canBeDeleted = true,
            textStyle = MaterialTheme.typography.titleMedium,
            sizes = ChipDefaults.chipSizes(iconsSize = 32.dp),
            contentPadding = PaddingValues(vertical = 12.dp),
        )
    }
}
