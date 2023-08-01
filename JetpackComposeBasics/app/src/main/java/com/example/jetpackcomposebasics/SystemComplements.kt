package com.example.jetpackcomposebasics

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SystemComplementsPreview() {
    NewAppBars()
}

@Composable
fun NewAppBars() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) })
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Add") },
                onClick = {
                    scope.launch {
                        scaffoldState
                            .snackbarHostState
                            .showSnackbar("Launch Fragment/Dialog")
                    }
                })
        },
        content = {
            Components(modifier = Modifier.padding(it))
        })
}