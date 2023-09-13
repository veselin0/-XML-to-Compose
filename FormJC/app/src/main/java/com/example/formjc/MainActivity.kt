package com.example.formjc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.formjc.Utils.joinData
import com.example.formjc.ui.components.AlertDialogContent
import com.example.formjc.ui.components.TextFieldCustom
import com.example.formjc.ui.components.FormToolbar
import com.example.formjc.ui.theme.FormJCTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint(
        "UnusedMaterial3ScaffoldPaddingParameter",
        "UnusedMaterialScaffoldPaddingParameter"
    )
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormJCTheme {
                val scaffoldState = rememberScaffoldState()
                val coroutineScope = rememberCoroutineScope()
                var openDialog by remember { mutableStateOf(false) }
                var userData by remember { mutableStateOf("") }
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        FormToolbar {
                            if (userData.isNotEmpty()) {
                                openDialog = true
                            } else {
                                coroutineScope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        getString(R.string.app_bar_incomplete_form)
                                    )
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize(),
                    content = { CForm { userData = it } }

                )
                if (openDialog) {
                    AlertDialogContent(content = userData, onContentChange = { openDialog = false })
                }
            }
        }
    }
}


@Composable
fun CForm(inputCallback: (String) -> Unit) {
    var nameValue by remember { mutableStateOf("") }
    var surnameValue by remember { mutableStateOf("") }
    var heightValue by remember { mutableStateOf("") }
    var birthDateValue by remember { mutableStateOf("") }
    val countryValue by remember { mutableStateOf("") }
    var birthPlaceValue by remember { mutableStateOf("") }
    var notesValue by remember { mutableStateOf("") }

    if (nameValue.isEmpty() || surnameValue.isEmpty() || heightValue.isEmpty()) {
        inputCallback("")
    } else {
        inputCallback(
            joinData(
                nameValue,
                surnameValue,
                heightValue,
                birthDateValue,
                countryValue,
                birthPlaceValue,
                notesValue
            )
        )
    }

    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.common_padding_default))
            .verticalScroll(rememberScrollState())
    ) {

//        Name
        TextFieldCustom(
            paddingTop = dimensionResource(id = R.dimen.common_padding_null),
            labelResource = R.string.hint_name,
            iconResource = R.drawable.ic_person,
            maxLengthResource = integerResource(id = R.integer.name_max_length),
            isRequired = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
        ) { nameValue = it }

//        Surname
        TextFieldCustom(
            labelResource = R.string.hint_surname,
            iconResource = R.drawable.ic_person,
            isRequired = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
        ) { surnameValue = it }

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.common_padding_default)
            )
        ) {
            //        Height
            TextFieldCustom(
                modifier = Modifier.weight(40f),
                labelResource = R.string.hint_height,
                iconResource = R.drawable.ic_height,
                maxLengthResource = integerResource(id = R.integer.height_max_length),
                isRequired = true,
                minValue = integerResource(id = R.integer.height_min_value),
                errorResource = R.string.help_min_height_valid,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            ) { heightValue = it }

//        Birth Date
            TextFieldCustom(
                modifier = Modifier.weight(60f),
                labelResource = R.string.hint_birth_date,
                iconResource = R.drawable.ic_calendar_today,
                isClickable = true
            ) { birthDateValue = it }


        }

        //        Birthplace
        TextFieldCustom(
            labelResource = R.string.hint_birth_place,
            iconResource = R.drawable.ic_place
        ) { birthPlaceValue = it }

//        Notes
        TextFieldCustom(
            labelResource = R.string.hint_notes,
            iconResource = R.drawable.ic_notes,
            isSingleLine = false, maxLengthResource = R.integer.notes_max_length,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        ) { notesValue = it }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormJCTheme {
        CForm {}
    }
}
