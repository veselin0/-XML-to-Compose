package com.example.formjc.ui.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.example.formjc.R
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldCustom(
    modifier: Modifier = Modifier,
    paddingTop: Dp = dimensionResource(id = R.dimen.common_padding_default),
    labelResource: Int,
    iconResource: Int,
    isRequired: Boolean = false,
    isSingleLine: Boolean = true,
    minValue: Int = 0,
    errorResource: Int = R.string.help_required,
    maxLengthResource: Int? = null,
    isClickable: Boolean = false,
    keyboardOptions: KeyboardOptions? = null,
    clearValue: Boolean = false,
    onValueChanged: (String) -> Unit
) {
    var textValue by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    if (clearValue) textValue = ""

    val context = LocalContext.current


    Column(modifier = modifier) {
        val keyboard = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current
        OutlinedTextField(
            value = textValue,
            onValueChange = {
                if (maxLengthResource == null) {
                    textValue = it
                } else {
                    if (it.length <= maxLengthResource) {
                        textValue = it
                    }
                }

                isError = it.isEmpty()
                if (minValue > 0) isError = (textValue.toIntOrNull() ?: 0) < minValue
                onValueChanged(textValue)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = paddingTop)
                .clickable { if (isClickable) datePickerTextField(context) {
                    textValue = it
                    onValueChanged(textValue)
                } },
            label = {
                Text(text = stringResource(id = labelResource))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardOptions?.keyboardType ?: KeyboardType.Text,
                capitalization = keyboardOptions?.capitalization
                    ?: KeyboardCapitalization.Sentences,
                imeAction = if (keyboardOptions == null || keyboardOptions.imeAction == ImeAction.Default) ImeAction.Next
                else keyboardOptions.imeAction
            ),
            keyboardActions = KeyboardActions(onDone = { keyboard?.hide() }, onNext = {
                focusManager.moveFocus(FocusDirection.Next)
            }),
            leadingIcon = {
                Icon(painter = painterResource(id = iconResource), contentDescription = null)
            },
            singleLine = isSingleLine,
            isError = isError && isRequired,
            readOnly = isClickable,
            enabled = !isClickable
        )

        if (isRequired) {
            Text(
                text =
                if (isError) stringResource(id = errorResource)
                else stringResource(id = R.string.help_required),
                style = MaterialTheme.typography.caption,
                color = if (isError) MaterialTheme.colors.error
                else MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.common_padding_default),
                    top = dimensionResource(id = R.dimen.common_padding_micro)
                )
            )
        }
    }
}

@Composable
fun NotesMaxLengthCounter(currentLength: Int, maxLengthResource: Int) {
    Text(
        text = "$currentLength/${integerResource(id = maxLengthResource)}",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.common_padding_micro)),
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)

    )
}