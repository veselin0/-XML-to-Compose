package com.example.jetpackcomposebasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFE1E1E1)
@Composable
private fun ModifierPreview() {
//    NewSpacing()
    NewSize()
}

@Composable
fun NewSize() {
    Column(
        modifier = Modifier
            .size(280.dp)
            .background(Color.Yellow)
    ) {
        Column(
            modifier = Modifier
                .size(260.dp)
                .background(Color.DarkGray)
        ) {
            TextANT()
//            TextFro(Modifier.fillMaxSize())
//            TextFro(Modifier.fillMaxWidth())
//            TextFro(Modifier.fillMaxHeight())
//            TextFro(Modifier.width(80.dp))
            TextFro(Modifier.requiredWidth(80.dp).requiredHeight(40.dp))
        }
        TextFro(Modifier.size(width = 128.dp, height = 64.dp))
    }
}

@Composable
fun NewSpacing() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White.copy(alpha = 0.6f))
    ) {
        TextANT()
        TextFro(
            modifier = Modifier
//            .paddingFromBaseline(top = 24.dp)
                .offset(x = 16.dp, y = 16.dp)
        )
    }
}
