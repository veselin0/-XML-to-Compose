package com.example.formjc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.formjc.ui.components.MyTopAppBar
import com.example.formjc.ui.components.ToolbarForm
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
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        ToolbarForm {
                            coroutineScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    "You have pressed: $it"
                                )
                            }
                        }
                    },
                    scaffoldState = scaffoldState,
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        CForm()
                    }
                )
            }
        }
    }
}


@Composable
fun CForm() {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormJCTheme {
        CForm()
    }
}