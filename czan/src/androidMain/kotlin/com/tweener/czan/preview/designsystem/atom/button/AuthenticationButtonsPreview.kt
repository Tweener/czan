package com.tweener.czan.preview.designsystem.atom.button

import androidx.compose.runtime.Composable
import com.tweener.czan.designsystem.atom.button.AppleLogInButton
import com.tweener.czan.designsystem.atom.button.AppleSignUpButton
import com.tweener.czan.designsystem.atom.button.EmailLogInButton
import com.tweener.czan.designsystem.atom.button.EmailSignUpButton
import com.tweener.czan.designsystem.atom.button.GoogleLogInButton
import com.tweener.czan.designsystem.atom.button.GoogleSignUpButton
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import io.github.tweener.czan.generated.resources.Res
import io.github.tweener.czan.generated.resources.email

/**
 * @author Vivien Mahe
 * @since 24/07/2024
 */

@UiModePreviews
@Composable
private fun GoogleSignUpButtonPreview() {
    CzanThemePreview {
        GoogleSignUpButton()
    }
}

@UiModePreviews
@Composable
private fun GoogleLogInButtonPreview() {
    CzanThemePreview {
        GoogleLogInButton()
    }
}

@UiModePreviews
@Composable
private fun AppleSignUpButtonPreview() {
    CzanThemePreview {
        AppleSignUpButton()
    }
}

@UiModePreviews
@Composable
private fun AppleLogInButtonPreview() {
    CzanThemePreview {
        AppleLogInButton()
    }
}

@UiModePreviews
@Composable
private fun EmailSignUpButtonPreview() {
    CzanThemePreview {
        EmailSignUpButton(emailIcon = Res.drawable.email)
    }
}

@UiModePreviews
@Composable
private fun EmailLogInButtonPreview() {
    CzanThemePreview {
        EmailLogInButton(emailIcon = Res.drawable.email)
    }
}

