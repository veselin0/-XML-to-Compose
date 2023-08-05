package com.example.jetpackcomposebasics

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFFFFFFFF,
    device = Devices.NEXUS_7
)
@Composable
private fun ModifierPreview() {
//    NewSpacing()
//    NewSize()
//    NewClick()
    NewResponsive()
}

@Composable
fun NewResponsive() {
    BoxWithConstraints() {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            if (minWidth > 600.dp) {
                Row(modifier = Modifier.padding(8.dp)) {
                    TextFro(modifier = Modifier.fillMaxWidth())
                    TextANT()
                }
            } else {
                Column(modifier = Modifier.padding(8.dp)) {
                    TextFro(modifier = Modifier.fillMaxWidth())
                    TextANT()
                }
            }

        }
    }

}

@Composable
fun StandardBox(modifier: Modifier = Modifier) {
    Box(modifier = modifier)
    {
        TextFro(
            modifier = Modifier
                .size(width = 128.dp, height = 64.dp)
                .padding(16.dp)
                .clickable { })
    }
}

@Composable
fun NewClick() {
    StandardBox(
        modifier = Modifier
            .padding(36.dp)
            .background(Color.Cyan)
    )


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
            TextFro(
                Modifier
                    .requiredWidth(80.dp)
                    .requiredHeight(40.dp)
            )
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
