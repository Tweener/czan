package com.tweener.czan.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.dialog.AlertDialog
import com.tweener.czan.designsystem.atom.scaffold.Scaffold
import com.tweener.czan.sample.ui.theme.CzanSampleTheme

/**
 * @author Vivien Mahe
 * @since 12/01/2025
 */

@Composable
fun App() {
    var showAlertDialog by remember { mutableStateOf(false) }

    CzanSampleTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.CenterVertically),
            ) {
                Button(
                    text = "Show Alert Dialog",
                    onClick = { showAlertDialog = true }
                )
            }

            if (showAlertDialog) {
                AlertDialog(
                    title = "This is an AlertDialog",
                    message = "Which can include a message",
                    confirmButtonLabel = "Confirm",
                    onConfirmButtonClicked = { showAlertDialog = false },
                    onDismiss = { showAlertDialog = false },
                    dismissButtonLabel = "Dismiss",
                    icon = null,
                )
            }
        }
    }
}
