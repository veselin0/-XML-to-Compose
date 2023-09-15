package com.example.formjc.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.example.formjc.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AutocompleteTextFieldCountries(onValueChanged: (String) -> Unit) {
    var selectedText by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }

    val countries = arrayOf(
        "Argentina", "Bolivia", "Chile", "Colombia", "Ecuador", "España",
        "Estados Unidos", "México", "Panamá", "Peru", "Uruguay"
    )

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {}) {
        val focusManager = LocalFocusManager.current
        OutlinedTextField(
            value = selectedText,
            onValueChange = {
                isExpanded = true
                selectedText = it
                onValueChanged(selectedText)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.common_padding_default)),
            label = { Text(text = stringResource(id = R.string.hint_country)) },
            singleLine = true,
            trailingIcon = {
                           ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(backgroundColor = Color.White),
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_place), contentDescription = null)
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) })
        )
        val filteringOptions = countries.filter { it.contains(selectedText, ignoreCase = true) }
        if (filteringOptions.isNotEmpty()) {
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                filteringOptions.forEach { selectionOption ->
                    DropdownMenuItem(onClick = {
                        selectedText = selectionOption
                        isExpanded = false
                        onValueChanged(selectedText)
                    }) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
    }

}

@Composable
fun SpinnerCountries() {
    var selectedText by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }

    val countries = arrayOf(
        "Argentina", "Bolivia", "Chile", "Colombia", "Ecuador", "España",
        "Estados Unidos", "México", "Panamá", "Peru", "Uruguay"
    )

    Column(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.common_padding_default))) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isExpanded = true }
        )
        DropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            countries.forEach {
                DropdownMenuItem(onClick = {
                    isExpanded = false
                    selectedText = it
                }) {
                    Text(text = it)
                }
            }
        }
    }
}