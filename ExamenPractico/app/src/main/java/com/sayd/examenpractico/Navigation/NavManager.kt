package com.sayd.examenpractico.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sayd.examenpractico.ui.screens.ChangeThemeScreen
import com.sayd.examenpractico.ui.screens.DashboardScreen
import com.sayd.examenpractico.ui.screens.UserScreen

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.Dashboard.route) {
        composable(AppRoutes.Dashboard.route) {
            DashboardScreen(navController)
        }
        composable(AppRoutes.ChangeTheme.route) {
            ChangeThemeScreen(navController)
        }
        composable(AppRoutes.User.route) {
            UserScreen(navController)
        }
    }
}
