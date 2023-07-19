package com.example.jetpackcomposebasics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LayoutPreview() {
//    NewFrameLayout()

    NewLinearLayout()
}

@Composable
fun NewLinearLayout() {
    Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center) {
        Text(text = "ANT Android Courses")
        Text(text = "Frogames")
    }
}

@Composable
fun NewFrameLayout() {
    Box(contentAlignment = Alignment.CenterEnd) {
        Text(text = "ANT Android Courses")
        Text(text = "Frogames")
    }

}
