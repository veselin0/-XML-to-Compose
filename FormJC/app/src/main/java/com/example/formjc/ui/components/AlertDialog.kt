package com.example.formjc.ui.components

import androidx.compose.material.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.formjc.R

@Composable
fun AlertDialogContent(content: String, onContentChange: (Boolean) -> Unit) {
    AlertDialog(
        onDismissRequest = { onContentChange(false) },
        title = { Text(text = stringResource(id = R.string.dialog_title)) },
        text = { Text(text = content) },
        confirmButton = {
            TextButton(onClick = { onContentChange(true) }) {
                Text(text = stringResource(id = R.string.dialog_OK))
            }
        },
        dismissButton = {
            TextButton(onClick = { onContentChange(false) }) {
                Text(text = stringResource(id = R.string.dialog_cancel))
            }
        }
    )
}