package com.ardhi.floodwise.ui.Screen.Navigation
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.SideEffect
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ardhi.floodwise.ui.Navigation.NavigationItem
import com.ardhi.floodwise.ui.Navigation.Screen
import com.ardhi.floodwise.ui.Screen.ArtikelScreen
import com.ardhi.floodwise.ui.Screen.StatusKetinggianAirScreen
import com.ardhi.floodwise.ui.theme.PrimaryColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
@Composable
fun NavigationScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val systemUiController = rememberSystemUiController()

    // Mengatur warna status bar
    SideEffect {
        systemUiController.setStatusBarColor(color = PrimaryColor)
    }

    // Cek apakah layar saat ini membutuhkan BottomBar
    val showBottomBar = currentRoute == Screen.Home.route ||
            currentRoute == Screen.Maps.route ||
            currentRoute == Screen.Report.route ||
            currentRoute == Screen.Profile.route


    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        // Hapus padding dari BottomBar jika tidak ditampilkan
        val adjustedPadding = if (showBottomBar) innerPadding else PaddingValues(0.dp)

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(adjustedPadding) // Sesuaikan padding
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }
            composable(Screen.Maps.route) {
                MapsScreen()
            }
            composable(Screen.Report.route) {
                ReportScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(Screen.Status.route) {
                StatusKetinggianAirScreen(onBackClick = {
                    navController.popBackStack()
                })
            }
            composable(Screen.Artikel.route) {
                ArtikelScreen(onBackClick = {
                    navController.popBackStack()
                })
            }
        }
    }
}



@Composable
private fun BottomBar(
    navController: NavHostController,

    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                icon = Icons.Default.LocationOn,
                screen = Screen.Maps
            ), NavigationItem(
                icon = Icons.Default.Call,
                screen = Screen.Report
            ),
            NavigationItem(
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = ""
                    )
                },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFFDAE2FF),
                )
            )
        }
    }
}