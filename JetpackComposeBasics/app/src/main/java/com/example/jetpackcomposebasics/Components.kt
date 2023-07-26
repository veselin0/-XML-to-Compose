package com.example.jetpackcomposebasics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComponentsPreview() {
//    NewTextView()

    Components()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTextFieldOutlined() {
    var textValue by remember { mutableStateOf("") }
    var passValue by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text(text = "Enter More Data")},
        modifier = Modifier.fillMaxWidth())

    OutlinedTextField(
        value = passValue,
        onValueChange = { passValue = it },
        label = { Text(text = "Enter Password")},
        visualTransformation =  PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth())
}

@Composable
fun CustomDivider() {
    Spacer(modifier = Modifier.height(8.dp))
    Divider(Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun Components() {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(Modifier.padding(8.dp)) {
            NewTextView()
            CustomDivider()
            NewTextField()
            NewTextFieldOutlined()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTextField() {
    var textValue by remember { mutableStateOf("Hi!") }

    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text(text = "Enter Data") },
        modifier = Modifier.fillMaxWidth())
}

@Composable
fun NewTextView() {
    Column {
        Text(
            text = "Jetpack Compose",
            color = Color.Red,
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(2f, 2f),
                    blurRadius = 4f
                )
            )
        )

        Text(
            text = "Jetpack Compose desde cero, migra tus vistas de Android XML. " +
                    "Jetpack Compose desde cero, migra tus vistas de Android XML",
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            ) { append("Batman") }
            append(", Bruce Wayne")
        })

        Text(
            text = "Diseños avanzados en Text.",
            Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
    }
}
