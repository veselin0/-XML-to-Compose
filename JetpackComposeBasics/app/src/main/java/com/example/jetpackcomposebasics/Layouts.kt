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


@Composable
private fun LayoutPreview() {
//    NewFrameLayout()

//    NewLinearLayout()

    NewConstraintLayout()
}

@Composable
fun NewConstraintLayout() {
    /*ConstraintLayout {
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
    }*/
    ConstraintLayout {
        val (normA, normF, filledF, container) = createRefs()

        Text(
            text = "ANT Android Courses",
            modifier = Modifier.constrainAs(normA) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Text(text = "Frogames",
            modifier = Modifier.constrainAs(normF) {
                top.linkTo(normA.bottom)
                start.linkTo(normA.start)
            })
        TextFro(modifier = Modifier.constrainAs(filledF) {
            top.linkTo(normF.top)
            start.linkTo(normF.end)
        })
        Row(modifier = Modifier.constrainAs(container) {
            top.linkTo(normF.bottom)
            start.linkTo(normA.start)
        }) {
            TextANT()
            TextFro()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
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

//    Row(verticalAlignment = Alignment.CenterVertically) {
//        TextFro()
//        Column {
//            TextANT()
//            TextANT()
//            TextFro()
//            Row {
//                TextANT()
//                TextFro()
//            }
//        }
//    }

    ConstraintLayout {
        val (rowFro, colAnt0, colAnt1, colFro, row) = createRefs()
        TextFro(modifier = Modifier.constrainAs(rowFro) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })
        TextANT(modifier = Modifier.constrainAs(colAnt0) {
                start.linkTo(rowFro.end)
                bottom.linkTo(colAnt1.top)
            })
        TextANT(modifier = Modifier.constrainAs(colAnt1) {
                start.linkTo(rowFro.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })
        TextFro(modifier = Modifier.constrainAs(colFro) {
                start.linkTo(rowFro.end)
                top.linkTo(colAnt1.bottom)
            })
        Row(modifier = Modifier.constrainAs(row){
            start.linkTo(colFro.start)
            top.linkTo(colFro.bottom)
        }) {
                TextANT()
                TextFro()
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
