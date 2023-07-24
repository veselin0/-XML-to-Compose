package com.example.jetpackcomposebasics

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComponentsPreview() {
    NewTextView()
}

@Composable
fun NewTextView() {
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
}
