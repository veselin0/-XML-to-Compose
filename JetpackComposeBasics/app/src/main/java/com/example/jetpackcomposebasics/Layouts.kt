package com.example.jetpackcomposebasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LayoutPreview() {
//    NewFrameLayout()

    NewLinearLayout()
}

@Composable
fun NewLinearLayout() {
//    Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center) {
//        Text(text = "ANT Android Courses")
//        Text(text = "Frogames")
//
//        Row {
//            TextANT()
//            TextFro()
//        }
//    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        TextFro()
        Column {
            TextANT()
            TextANT()
            TextFro()
            Row {
                TextANT()
                TextFro()
            }
        }
    }
}

@Composable
fun TextANT() {
    Text(text = "ANT Android Courses", modifier = Modifier.background(Color.Cyan))
}

@Composable
fun TextFro() {
    Text(text = "Frogames", modifier = Modifier.background(Color.LightGray))
}

@Composable
fun NewFrameLayout() {
    Box(contentAlignment = Alignment.CenterEnd) {
        Text(text = "ANT Android Courses")
        Text(text = "Frogames")
    }

}
