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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import com.example.formjc.R

@Composable
fun EtCustom(
    paddingTop: Dp = dimensionResource(id = R.dimen.common_padding_default),
    onValueChanged: (String) -> Unit
) {
    var textValue by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    Column() {
        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
                isError = it.isEmpty()
                onValueChanged(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = paddingTop),
            label = {
                Text(text = stringResource(id = R.string.hint_surname))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = null)
            },
            isError = isError
        )

        Text(
            text = stringResource(id = R.string.help_required),
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
