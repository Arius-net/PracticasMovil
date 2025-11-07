package com.sayd.examenpractico.Navigation

sealed class AppRoutes(val route: String){
    object Dashboard: AppRoutes("Dashboard")
    object ChangeTheme: AppRoutes("ChangeTheme")
    object User: AppRoutes("User")
}
