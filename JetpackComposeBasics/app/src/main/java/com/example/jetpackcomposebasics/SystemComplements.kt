package com.example.jetpackcomposebasics

<<<<<<< HEAD
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


=======
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

>>>>>>> e71381034fa7ce27db494f96f8532676f8784085
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
<<<<<<< HEAD
                title = { Text(text = stringResource(id = R.string.app_name)) })
=======
                title = { Text(text = stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Open Drawer")
                    }
                },
                actions = {
                    var isMenuOpened by remember { mutableStateOf(false) }
                    IconButton(onClick = { isMenuOpened = true }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Menu Options"
                        )
                        NewMenu(isExpanded = isMenuOpened, onItemClick = {
                            scope.launch { scaffoldState.snackbarHostState.showSnackbar(it) }
                        }) {
                            isMenuOpened = false
                        }
                    }
                }
            )
        },
        drawerContent = {
            var selectedItem by remember { mutableStateOf("Favorites") }
            val menuItems = mapOf<String, ImageVector>(
                Pair("Favorites", Icons.Filled.Favorite),
                Pair("Save", Icons.Filled.Send),
                Pair("History", Icons.Filled.List),
                Pair("Settings", Icons.Filled.Settings),
            )

            Divider(modifier = Modifier.padding(top = 128.dp, bottom = 8.dp))

            menuItems.forEach {
                Row(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .clickable {
                            selectedItem = it.key
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }

                        }
                        .padding(horizontal = 12.dp)
                        .clip(RoundedCornerShape(28.dp))
                        .background(if (selectedItem == it.key) Color.LightGray else Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = it.value,
                        contentDescription = it.key,
                        modifier = Modifier
                            .size(56.dp)
                            .padding(16.dp, end = 12.dp)
                    )
                    Text(text = it.key, style = MaterialTheme.typography.h6)
                }
            }
>>>>>>> e71381034fa7ce27db494f96f8532676f8784085
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Add") },
                onClick = {
                    scope.launch {
                        scaffoldState
                            .snackbarHostState
<<<<<<< HEAD
                            .showSnackbar("Launch Fragment/Dialog")
=======
                            .showSnackbar("Launch Fragment / Dialog")
>>>>>>> e71381034fa7ce27db494f96f8532676f8784085
                    }
                })
        },
        content = {
            Components(modifier = Modifier.padding(it))
        })
}
<<<<<<< HEAD
=======

@Composable
fun NewMenu(isExpanded: Boolean, onItemClick: (String) -> Unit, onDismiss: () -> Unit) {
    val items = listOf("Favourite", "Save Mode", "History", "Settings")

    DropdownMenu(expanded = isExpanded, onDismissRequest = onDismiss) {
        items.forEach { item ->
            DropdownMenuItem(onClick = {
                onItemClick(item)
                onDismiss()
            }) {
                Text(text = item)
            }
        }
        Divider()
        DropdownMenuItem(onClick = {
            onItemClick("action_logout")
            onDismiss()
        }) {
            Text(text = "Log out")
        }
    }
}
>>>>>>> e71381034fa7ce27db494f96f8532676f8784085
