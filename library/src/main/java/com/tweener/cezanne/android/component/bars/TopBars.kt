package com.tweener.cezanne.android.component.bars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.tweener.cezanne.android.component.bars.icon.ArrowBackIconButton
import com.tweener.cezanne.android.component.bars.icon.CloseBackIconButton
import com.tweener.cezanne.android.component.text.Text
import com.tweener.cezanne.android.preview.UiModePreviews
import com.tweener.cezanne.android.theme.CezanneTheme
import com.tweener.cezanne.android.theme.Size

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBar(
    text: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    logo: Painter? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    val contentColor = MaterialTheme.colorScheme.onPrimary

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Size.Padding.Default)
            ) {
                logo?.let {
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = logo,
                        colorFilter = ColorFilter.tint(color = contentColor),
                        contentDescription = null
                    )
                }

                Text(
                    text = text,
                    color = contentColor,
                    style = textStyle
                )
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            actionIconContentColor = contentColor
        )
    )
}

@Composable
fun TopBarWithBackButton(
    title: String,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        navigationIcon = { ArrowBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@Composable
fun TopBarWithCloseButton(
    title: String,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        navigationIcon = { CloseBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarWithIcon(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = title) },
        navigationIcon = navigationIcon,
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(),
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}

@UiModePreviews
@Composable
private fun TopLevelScreenTopBarPreview() {
    CezanneTheme {
        CenterAlignedTopAppBar(
            text = "App name",
            textStyle = MaterialTheme.typography.bodyLarge
        )
    }
}

@UiModePreviews
@Composable
private fun TopBarWithBackButtonPreview() {
    CezanneTheme {
        TopBarWithBackButton(title = "Title")
    }
}

@UiModePreviews
@Composable
private fun TopBarWithCloseButtonPreview() {
    CezanneTheme {
        TopBarWithCloseButton(title = "Title")
    }
}
