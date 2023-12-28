package com.example.practiceandroid.feature.third

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.practiceandroid.network.PracticeClient
import kotlinx.coroutines.runBlocking

@Composable
fun ThirdScreen() {
    //TODO
    val client = PracticeClient()

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Yellow) {
        Column(verticalArrangement = Arrangement.Center) {
            Button(onClick = {
                runBlocking {
                    client.connect()
                }
            }) {
                Text(text = "API")
            }
        }
    }
}