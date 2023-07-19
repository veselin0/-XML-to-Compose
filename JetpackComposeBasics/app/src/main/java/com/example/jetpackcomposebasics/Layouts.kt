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
import androidx.constraintlayout.compose.ConstraintLayout


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LayoutPreview() {
//    NewFrameLayout()

//    NewLinearLayout()

    NewConstraintLayout()
}

@Composable
fun NewConstraintLayout() {
    ConstraintLayout {
        val (normA, normF, filledF, container) = createRefs()

        Text(
            text = "ANT Android Courses",
            modifier = Modifier.constrainAs(normA) { top.linkTo(parent.top) })
        Text(text = "Frogames",
            modifier = Modifier.constrainAs(normF) { top.linkTo(normA.bottom) })
        TextFro(modifier = Modifier.constrainAs(filledF) {
            top.linkTo(normF.top)
            start.linkTo(normF.end)
        })
        Row(modifier = Modifier.constrainAs(container){
            top.linkTo(normF.bottom)
        }) {
            TextANT()
            TextFro()
        }
    }
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
fun TextANT(modifier: Modifier = Modifier) {
    Text(text = "ANT Android Courses", modifier = modifier.background(Color.Cyan))
}

@Composable
fun TextFro(modifier: Modifier = Modifier) {
    Text(text = "Frogames", modifier = modifier.background(Color.LightGray))
}

@Composable
fun NewFrameLayout() {
    Box(contentAlignment = Alignment.CenterEnd) {
        Text(text = "ANT Android Courses")
        Text(text = "Frogames")
    }

}
