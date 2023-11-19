package com.example.practiceandroid.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.practiceandroid.navigation.PracticeNavHost
import com.example.practiceandroid.navigation.PracticeNavigationBar

@Suppress("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PracticeApp() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                PracticeNavigationBar(navController = navController)
            }
        ) { padding ->
            Row(modifier = Modifier.padding(padding)) {
                PracticeNavHost(navController)
            }
        }
    }
}