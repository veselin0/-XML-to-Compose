package com.example.formjc.ui.components

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.material.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.formjc.R
import java.util.Calendar
import java.util.Date

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

fun datePickerTextField(context: Context, onValueChanged: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    calendar.time = Date()
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val textValue = "$dayOfMonth/${month + 1}/$year"
            onValueChanged(textValue)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
    datePickerDialog.show()
}