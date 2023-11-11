package com.example.practiceandroid.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.practiceandroid.feature.first.FirstScreen
import com.example.practiceandroid.feature.second.SecondScreen
import com.example.practiceandroid.feature.third.ThirdScreen
import com.example.practiceandroid.ui.PracticeIcon


@Composable
fun PracticeNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = PracticeNavigationItem.FIRST.route) {
        composable(PracticeNavigationItem.FIRST.route) {
            FirstScreen()
        }
        composable(PracticeNavigationItem.SECOND.route) {
            SecondScreen()
        }
        composable(PracticeNavigationItem.THIRD.route) {
            ThirdScreen()
        }
    }
}

@Composable
fun PracticeNavigationBar(navController: NavController) {
    NavigationBar {
        PracticeNavigationItem.entries.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.label)
                },
                label = {
                    Text(text = item.label)
                })
        }
    }
}

enum class PracticeNavigationItem(
    val label: String,
    val route: String,
    val icon: ImageVector
) {
    FIRST("First", "First", PracticeIcon.FIRST),
    SECOND("Second", "Second", PracticeIcon.SECOND),
    THIRD("Third", "Third", PracticeIcon.THIRD)
}