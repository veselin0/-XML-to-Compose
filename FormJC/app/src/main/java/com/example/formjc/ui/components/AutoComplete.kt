package com.example.formjc.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.formjc.R

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