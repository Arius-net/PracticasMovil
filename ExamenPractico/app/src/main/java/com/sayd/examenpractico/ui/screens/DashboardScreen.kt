package com.sayd.examenpractico.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sayd.examenpractico.Navigation.AppRoutes

@Composable
fun DashboardScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.navigate(AppRoutes.ChangeTheme.route) }) {
                Text("Cambiar Tema")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate(AppRoutes.User.route) }) {
                Text("Usuarios")
            }
        }
    }
}
