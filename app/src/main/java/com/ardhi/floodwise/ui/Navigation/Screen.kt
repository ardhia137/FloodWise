package com.ardhi.floodwise.ui.Navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Maps : Screen("maps")
    object Report : Screen("report")
    object Profile : Screen("profile")
    object Status : Screen("status")
    object Artikel : Screen("artikel")

}
