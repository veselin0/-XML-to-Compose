package com.example.filmsjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.filmsjc.ui.theme.FilmsJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmsJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListBasic(FakeDatabase.getAllFilms())
                }
            }
        }
    }
}

@Composable
fun ListBasic(films: List<Film>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState()) ) {
        films.forEach { Text(text = it.name)}
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FilmsJCTheme {
        ListBasic(FakeDatabase.getAllFilms())

    }
}