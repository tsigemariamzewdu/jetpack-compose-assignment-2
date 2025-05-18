package com.example.todoapptrail.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapptrail.ui.screens.TodoDetailScreen
import com.example.todoapptrail.ui.screens.TodoListScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
            TodoListScreen(navController = navController)
        }
        composable(
            route = "detail/{todoId}",
            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
        ) { backStackEntry ->
            TodoDetailScreen(
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}