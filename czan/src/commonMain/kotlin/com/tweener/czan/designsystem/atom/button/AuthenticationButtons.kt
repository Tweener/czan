package com.tweener.czan.designsystem.atom.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tweener.czan._internal.kotlinextensions.clickableRipple
import com.tweener.czan.designsystem.atom.image.Image
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import io.github.tweener.czan.generated.resources.Res
import io.github.tweener.czan.generated.resources.apple_logo
import io.github.tweener.czan.generated.resources.button_apple_login
import io.github.tweener.czan.generated.resources.button_apple_signup
import io.github.tweener.czan.generated.resources.button_email_login
import io.github.tweener.czan.generated.resources.button_email_signup
import io.github.tweener.czan.generated.resources.button_google_login
import io.github.tweener.czan.generated.resources.button_google_signup
import io.github.tweener.czan.generated.resources.google_logo
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

/**
 * @author Vivien Mahe
 * @since 24/07/2024
 */

@Composable
fun GoogleSignUpButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    AuthenticationButton(
        modifier = modifier,
        title = Res.string.button_google_signup,
        icon = Res.drawable.google_logo,
        onClick = onClick,
    )
}

@Composable
fun GoogleLogInButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    AuthenticationButton(
        modifier = modifier,
        title = Res.string.button_google_login,
        icon = Res.drawable.google_logo,
        onClick = onClick,
    )
}

@Composable
fun AppleSignUpButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    AuthenticationButton(
        modifier = modifier,
        title = Res.string.button_apple_signup,
        icon = Res.drawable.apple_logo,
        onClick = onClick,
    )
}

@Composable
fun AppleLogInButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    AuthenticationButton(
        modifier = modifier,
        title = Res.string.button_apple_login,
        icon = Res.drawable.apple_logo,
        onClick = onClick,
    )
}

@Composable
fun EmailSignUpButton(
    emailIcon: DrawableResource,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    AuthenticationButton(
        modifier = modifier,
        title = Res.string.button_email_signup,
        icon = emailIcon,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        onClick = onClick,
    )
}

@Composable
fun EmailLogInButton(
    emailIcon: DrawableResource,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    AuthenticationButton(
        modifier = modifier,
        title = Res.string.button_email_login,
        icon = emailIcon,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        onClick = onClick,
    )
}

@Composable
private fun AuthenticationButton(
    title: StringResource,
    icon: DrawableResource,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.background,
    onClick: (() -> Unit)? = null,
) {
    val shape = RoundedCornerShape(36.dp)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(ButtonSize.BIG.height)
            .clip(shape = shape)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.outline, shape = shape)
            .background(containerColor)
            .clickableRipple { onClick?.invoke() },
        horizontalArrangement = Arrangement.spacedBy(space = Size.Padding.Small, alignment = Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(22.dp),
            resource = icon,
        )

        Text(
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        )
    }
}
