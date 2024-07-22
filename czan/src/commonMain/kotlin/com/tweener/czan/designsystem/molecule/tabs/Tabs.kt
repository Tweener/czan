package com.tweener.czan.designsystem.molecule.tabs

/**
 * @author Vivien Mahe
 * @since 21/07/2024
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

class TabItem(
    val id: String,
    val title: StringResource,
    val icon: DrawableResource? = null,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTabs(
    tabItems: List<TabItem>,
    modifier: Modifier = Modifier,
    colors: TabsColors = TabsDefaults.colors(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    fontWeight: FontWeight = FontWeight.Normal,
    shape: Shape = RoundedCornerShape(Size.Padding.Small),
    contentPadding: PaddingValues = TabsDefaults.ContentPadding,
    showDivider: Boolean = false,
    onTabChanged: (@Composable (String) -> Unit)? = null,
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(modifier = modifier.fillMaxWidth()) {
        PrimaryTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = colors.containerColor(),
            contentColor = colors.contentColor(),
            divider = { if (showDivider) CzanTabHorizontalDivider(color = colors.contentColor(), horizontalPadding = contentPadding) },
            indicator = {
                CzanTabIndicator(
                    modifier = Modifier.tabIndicatorOffset(selectedTabIndex),
                    containerColor = colors.selectedTabContainerColor(),
                    shape = shape,
                    contentPadding = contentPadding,
                )
            }
        ) {
            tabItems.forEachIndexed { index, tabItem ->
                CzanTab(
                    tabItem = tabItem,
                    selected = selectedTabIndex == index,
                    shape = shape,
                    textStyle = textStyle,
                    fontWeight = fontWeight,
                    selectedContentColor = colors.selectedTabContentColor(),
                    unselectedContentColor = colors.contentColor(),
                    onClick = { selectedTabIndex = index },
                )
            }
        }

        onTabChanged?.invoke(tabItems[selectedTabIndex].id)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryTabs(
    tabItems: List<TabItem>,
    modifier: Modifier = Modifier,
    colors: TabsColors = TabsDefaults.colors(),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    fontWeight: FontWeight = FontWeight.Normal,
    shape: Shape = RoundedCornerShape(Size.Padding.Small),
    contentPadding: PaddingValues = TabsDefaults.ContentPadding,
    showDivider: Boolean = false,
    onTabChanged: (@Composable (String) -> Unit)? = null,
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(modifier = modifier.fillMaxWidth()) {
        SecondaryTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = colors.containerColor(),
            contentColor = colors.contentColor(),
            divider = { if (showDivider) CzanTabHorizontalDivider(color = colors.contentColor(), horizontalPadding = contentPadding) },
            indicator = {
                CzanTabIndicator(
                    modifier = Modifier.tabIndicatorOffset(selectedTabIndex),
                    containerColor = colors.selectedTabContainerColor(),
                    shape = shape,
                    contentPadding = contentPadding,
                )
            }
        ) {
            tabItems.forEachIndexed { index, tabItem ->
                CzanTab(
                    tabItem = tabItem,
                    selected = selectedTabIndex == index,
                    shape = shape,
                    textStyle = textStyle,
                    fontWeight = fontWeight,
                    selectedContentColor = colors.selectedTabContentColor(),
                    unselectedContentColor = colors.contentColor(),
                    onClick = { selectedTabIndex = index },
                )
            }
        }

        onTabChanged?.invoke(tabItems[selectedTabIndex].id)
    }
}

@Composable
private fun CzanTabHorizontalDivider(
    color: Color,
    horizontalPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    HorizontalDivider(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding.calculateStartPadding(LayoutDirection.Ltr)),
        thickness = 1.dp,
        color = color,
    )
}

@Composable
private fun CzanTabIndicator(
    modifier: Modifier,
    containerColor: Color,
    shape: Shape,
    contentPadding: PaddingValues = TabsDefaults.ContentPadding,
) {
    Box(
        modifier
            .fillMaxSize()
            .padding(contentPadding)
            .background(color = containerColor, shape = shape)
    )
}

@Composable
private fun CzanTab(
    tabItem: TabItem,
    selected: Boolean,
    shape: Shape,
    textStyle: TextStyle,
    fontWeight: FontWeight,
    selectedContentColor: Color,
    unselectedContentColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Tab(
        modifier = modifier
            .clip(shape = shape)
            .zIndex(2f), // Places the text above the background
        selected = selected,
        onClick = onClick,
        selectedContentColor = selectedContentColor,
        unselectedContentColor = unselectedContentColor,
        text = {
            Text(
                text = tabItem.title,
                style = textStyle,
                fontWeight = fontWeight,
                lines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        icon = tabItem.icon?.let { { Icon(resource = it, contentDescription = null) } },
        interactionSource = DisabledInteractionSource(), // Disable ripple effect
    )
}

object TabsDefaults {

    private val TabHorizontalPadding = Size.Padding.ExtraSmall
    private val TabVerticalPadding = Size.Padding.ExtraSmall

    val ContentPadding = PaddingValues(horizontal = TabHorizontalPadding, vertical = TabVerticalPadding)

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        selectedTabContainerColor: Color = MaterialTheme.colorScheme.primaryContainer,
        selectedTabContentColor: Color = MaterialTheme.colorScheme.onPrimary,
        tabDividerColor: Color = contentColor,
    ): TabsColors = TabsColors(
        containerColor = containerColor,
        contentColor = contentColor,
        selectedTabContainerColor = selectedTabContainerColor,
        selectedTabContentColor = selectedTabContentColor,
        tabDividerColor = tabDividerColor,
    )
}

@Immutable
class TabsColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
    private val selectedTabContainerColor: Color,
    private val selectedTabContentColor: Color,
    private val tabDividerColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun contentColor(): Color = contentColor

    @Composable
    internal fun selectedTabContainerColor(): Color = selectedTabContainerColor

    @Composable
    internal fun selectedTabContentColor(): Color = selectedTabContentColor

    @Composable
    internal fun tabDividerColor(): Color = tabDividerColor
}

private class DisabledInteractionSource : MutableInteractionSource {
    override val interactions: Flow<Interaction> = emptyFlow()
    override suspend fun emit(interaction: Interaction) {}
    override fun tryEmit(interaction: Interaction) = true
}
