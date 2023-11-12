package com.example.practiceandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.practiceandroid.theme.PracticeAndroidTheme
import com.example.practiceandroid.ui.PracticeApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeAndroidTheme {
                // A surface container using the 'background' color from the theme
                PracticeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeAndroidTheme {
        PracticeApp()
    }
}