package com.example.formjc

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
import com.example.formjc.ui.components.AlertDialogContent
import com.example.formjc.ui.components.FormToolbar
import com.example.formjc.ui.components.MyTopAppBar
import com.example.formjc.ui.components.ToolbarForm
import com.example.formjc.ui.theme.FormJCTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormJCTheme {
//                val scaffoldState = rememberScaffoldState()
//                val coroutineScope = rememberCoroutineScope()
                var openDialog by remember { mutableStateOf(false) }
                Scaffold(
                    topBar = {
                        FormToolbar { openDialog = true }
                    },
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        CForm()
                    }
                )
                if (openDialog) {
                    AlertDialogContent(content = "Gocho!", onContentChange = { openDialog = false })
                }
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