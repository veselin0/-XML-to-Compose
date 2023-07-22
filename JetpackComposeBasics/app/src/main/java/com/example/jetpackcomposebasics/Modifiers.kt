package com.example.jetpackcomposebasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFE1E1E1)
@Composable
private fun ModifierPreview() {
    NewSpacing()
}

@Composable
fun NewSpacing() {
    Box(modifier = Modifier
        .padding(16.dp)
        .background(Color.White.copy(alpha = 0.6f))) {
        TextANT()
        TextFro(
            modifier = Modifier
//            .paddingFromBaseline(top = 24.dp)
                .offset(x = 16.dp, y = 16.dp)
        )
    }
}
