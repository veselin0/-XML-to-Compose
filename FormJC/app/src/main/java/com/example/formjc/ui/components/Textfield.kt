package com.example.formjc.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import com.example.formjc.R

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
    maxLength: Int? = null,
    onValueChanged: (String) -> Unit
) {
    var textValue by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        OutlinedTextField(
            value = textValue,
            onValueChange = {
                if (maxLength == null) {
                    textValue = it
                } else {
                    if (it.length <= maxLength) {
                        textValue = it
                    }
                }

                isError = it.isEmpty()
                if (minValue > 0) isError = (textValue.toIntOrNull() ?: 0) < minValue
                onValueChanged(textValue)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = paddingTop),
            label = {
                Text(text = stringResource(id = labelResource))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            ),
            leadingIcon = {
                Icon(painter = painterResource(id = iconResource), contentDescription = null)
            },
            singleLine = isSingleLine,
            isError = isError && isRequired
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
