package com.example.jetpackcomposebasics

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LayoutPreview() {
    NewFrameLayout()
}

@Composable
fun NewFrameLayout() {
    Box(contentAlignment = Alignment.CenterEnd) {
        Text(text = "ANT Android Courses")
        Text(text = "Frogames")
    }

}
