package com.moriawe.bottomnavbar2.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moriawe.bottomnavbar2.screens.DetailScreen
import com.moriawe.bottomnavbar2.screens.MailScreen
import com.moriawe.bottomnavbar2.screens.MainScreen
import com.moriawe.bottomnavbar2.screens.SettingsScreen

@Composable
fun NavigationGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Main.route
    ) {
        composable(route = BottomNavItem.Main.route) {
            MainScreen(navController, innerPadding)
        }
        composable(route = BottomNavItem.Detail.route) {
            DetailScreen("Name", innerPadding)
        }
        composable(route = BottomNavItem.Mail.route) {
            MailScreen(innerPadding)
        }
        composable(route = BottomNavItem.Settings.route) {
            SettingsScreen(innerPadding)
        }
    }
}


/*
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
        ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Jennie"
                    nullable = true
                } )
            ) { entry ->
                DetailScreen(name = entry.arguments?.getString("name"))
            }
    }
}
 */