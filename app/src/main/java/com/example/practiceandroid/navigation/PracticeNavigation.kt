package com.example.practiceandroid.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = navBackStackEntry?.destination

    NavigationBar {
        PracticeNavigationItem.entries.forEach { item ->
            val selected = destination?.hierarchy?.any {
                it.route == item.route
            } == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (selected) item.filledIcon else item.outlinedIcon,
                        contentDescription = item.label
                    )
                },
                label = {
                    val fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                    Text(text = item.label, fontWeight = fontWeight)
                })
        }
    }
}

enum class PracticeNavigationItem(
    val label: String,
    val route: String,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector
) {
    FIRST("First", "First", PracticeIcon.First, PracticeIcon.FirstBorder),
    SECOND("Second", "Second", PracticeIcon.Second, PracticeIcon.SecondBorder),
    THIRD("Third", "Third", PracticeIcon.Third, PracticeIcon.ThirdBorder)
}