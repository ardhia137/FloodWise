package com.ardhi.floodwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ardhi.floodwise.ui.Screen.ArtikelScreen
import com.ardhi.floodwise.ui.Screen.LoginScreen
import com.ardhi.floodwise.ui.Screen.Navigation.NavigationScreen
import com.ardhi.floodwise.ui.Screen.RegisterScreen
import com.ardhi.floodwise.ui.Screen.StatusKetinggianAirScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "login") {
                composable("login") { LoginScreen(navController) }
                composable("main") {
                    val mainNavController = rememberNavController()
                    NavigationScreen(mainNavController)
                }
                composable("register") { RegisterScreen(navController) }
            }


        }
    }
}
